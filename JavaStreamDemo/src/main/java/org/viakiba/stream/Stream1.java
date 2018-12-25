package org.viakiba.stream;

import org.testng.annotations.Test;
import org.viakiba.stream.bean.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *      Collecton 相关的 Stream 操作
 *              Collection.stream() 串行
 *              Collection.parallelStream() 并行
 * @author: viakiba
 * @date: 2018/12/25 10:36
 */
public class Stream1 {

    /**
     *  List ==> skip / toArray
     */
    @Test(testName = "skip")
    public void testCollection1(){
        List<String> list = new ArrayList<String>();
        list = Arrays.asList("a","b","c","d");
        Stream<String> stream = list.stream();
        //skip 操作 跳过指定索引前的内容
        Object[] objects = stream.skip(2).toArray();
        System.out.println(objects.length+""+objects[0] +""+objects[1]);
//Stream 不可重复使用 即 不可逆
//        objects = stream.skip(2).toArray();
//        System.out.println(objects.length+""+objects[0] +""+objects[1]);
    }

    /**
     *  List ==> filter / sorted / min /max / toArray
     */
    @Test(testName = "filter")
    public void testCollection2(){
        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(1,2,8,6,3);
        Integer[] integers = list.stream().filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println(integers.length+"："+integers[0] +""+integers[1]);

        long count = list.stream().filter(x -> x / 2 == 1).count();
        System.out.println(count);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        studentList.add(new Student("s4",4));

        Student[] students = studentList.stream().filter(n -> n.getAge() < 2).toArray(Student[]::new);
        System.out.println(students[0]);
        for(Student s:students){
            System.out.println(s);
        }
        System.out.println("=====================");
        Student[] students1 = studentList.stream().sorted().toArray(Student[]::new);
        for(Student s:students1){
            System.out.println(s);
        }
        System.out.println("=====================");
        Student students2 = studentList.stream().min(Student::compareTo).get();
        System.out.println(students2);
        System.out.println("=====================");
        Student students3 = studentList.stream().min((x,y) -> {
            if(x.getAge() > y.getAge()){
                return 1;
            }else if(x.getAge() == y.getAge()){
                return 0;
            }else {
                return -1;
            }
        }).get();

        System.out.println(students3);
    }

    /**
     *  List ==> limit / forEach / peek / count
     */
    @Test(testName = "limit")
    public void testCollection3(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        studentList.add(new Student("s4",4));

        //并发 流  对一个 parallel 的 Steam 管道来说，如果其元素是有序的，那么 limit 操作的成本会比较大，
        //因为它的返回对象必须是前 n 个也有一样次序的元素。取而代之的策略是取消元素间的次序，或者不要用 parallel Stream。
        Stream<Student> parallel = studentList.stream().parallel();


        Stream<Student> stream = studentList.stream();
        //返回由该流的元素组成的流，该流被截断为长度不超过maxSize。
        //这是一个 short-circuiting 状态
        Student[] students = stream.limit(2).toArray(Student[]::new);

        for(Student s:students){
            System.out.println(s);
        }
        System.out.println("=======================");

        // forEach 会消费掉 forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环。

        studentList.stream().forEach(x -> {
            System.out.println("foreach "+ x);
        });

        System.out.println("====================");
        //peek 可以像 foreach 输出 而且不会消费
        long count = studentList.stream().peek(x -> {
            System.out.println(x +"peek");
        }).count();
        System.out.println(count);
        System.out.println("====================");



    }

    /**
     *  List ==> distinct / sequential / unordered / forEach
     */
    @Test(testName = "distinct")
    public void testCollection4(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        Student s4 = new Student("s4", 4);
        studentList.add(s4);
        studentList.add(s4);
        System.out.println(studentList.size());
        System.out.println("================================");
        // distinct 根据Object.equals(Object) 去重
        studentList.stream().distinct().forEach(x -> {
            System.out.println(x);
        });

        System.out.println("================================");

        //返回有序的等效流。可能返回自身，或者因为流已经无序，或者因为底层流状态被修改为无序。
        studentList.stream().limit(3).sequential().forEach(
                x -> {
                    System.out.println(x);
                }
        );

        System.out.println("================================");

        //返回无序的等效流。可能返回自身，或者因为流已经无序，或者因为底层流状态被修改为无序。
        studentList.stream().unordered().forEach(
                x -> {
                    System.out.println(x);
                }
        );

    }

    /**
     *  List ==> map / mapToInt / forEach
     */
    @Test(testName = "distinct")
    public void testCollection5(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        Student s4 = new Student("s4", 4);
        studentList.add(s4);
        studentList.add(s4);

        studentList.stream().map(student -> {
            return student.getAge();
        }).forEach(x ->{
            System.out.println(x);
        });
        System.out.println("================================");

        studentList.stream().mapToInt(student -> {
            return student.getAge();
        }).forEach(x ->{
            System.out.println(x);
        });
        System.out.println("================================");

        studentList.stream().map(student -> {
            return student.getAge();
        }).forEach(x ->{
            System.out.println(x);
        });

    }

    /**
     *  List ==> forEachOrdered / reduce / collect /
     */
    @Test(testName = "forEachOrdered")
    public void testCollection6(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        Student s4 = new Student("s4", 4);
        studentList.add(s4);
        studentList.add(s4);

        System.out.println(" ====================== ");
        // forEach 此操作的行为明确是不确定的。对于并行流管道，此操作不保证遵守流的遭遇顺序，因为这样做会牺牲并行性的好处。
        studentList.stream().parallel().forEach(x -> {
            System.out.println(x);
        });

        System.out.println(" ====================== ");

        //如果流具有已定义的遭遇顺序，则按流的遭遇顺序对此流的每个元素执行操作。
        studentList.stream().parallel().forEachOrdered(x -> {
            System.out.println(x);
        });

        //reduce 根据一定的规则将Stream中的元素进行计算后返回一个唯一的值。
        // https://blog.csdn.net/icarusliu/article/details/79504602
        System.out.println(" ====================== ");

        // 1个参数
        Student student = studentList.stream().reduce(new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                if (student.getAge() < student2.getAge()) {
                    return student;
                }
                return student2;
            }
        }).get();
        System.out.println(student);
        System.out.println(" ====================== ");

        // 2个参数
        Student s0 = studentList.stream().reduce(new Student("s0", 0), new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                if (student.getAge() < student2.getAge()) {
                    return student;
                }
                return student2;
            }
        });
        System.out.println(s0);
        System.out.println(" ====================== ");

        System.out.println(" ====================== ");
        List<Student> collect = studentList.stream().collect(Collectors.toList());

        System.out.println(collect.size());

    }




    /**
     *  List ==> findFirst / findAny / iterator
     */
    @Test(testName = "anyMatch")
    public void testCollection7(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        Student s4 = new Student("s4", 4);
        studentList.add(s4);

        //返回描述此流的第一个元素的Optional，或如果流为空，则返回空Optional。如果流没有遇到顺序，则可以返回任何元素。
        //这是一个短路终端操作。
        Student student = studentList.stream().findFirst().get();
        System.out.println(student);
        System.out.println("====================================");

        //返回描述流的某些元素的Optional，或如果流为空，则返回空Optional。
        //这是一个短路终端操作。
        //此操作的行为是显式不确定的；可以自由选择流中的任何元素。这是为了在并行操作中实现最大的性能；代价是在同一个源上的多个调用可能不返回相同的结果。（如果希望得到稳定的结果，则使用find.()代替。）
        student = studentList.parallelStream().findAny().get();
        System.out.println(student);
        System.out.println("====================================");
        // 返回此流的元素的迭代器。
        //这是一个 terminal  操作。
        Iterator<Student> iterator = studentList.parallelStream().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     *  List ==> anyMatch / allMatch / noneMatch
     */
    @Test(testName = "anyMatch")
    public void testCollection8(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("s1",1));
        studentList.add(new Student("s3",3));
        studentList.add(new Student("s2",2));
        studentList.add(new Student("s5",5));
        Student s4 = new Student("s4", 4);
        studentList.add(s4);

        //全部符合才是 true
        boolean b = studentList.stream().allMatch(x -> {
            if (x.getAge() == 3) {
                return true;
            }
            return false;
        });
        System.out.println(b);
        System.out.println("====================================");
        //有一个符合就是 true
        b = studentList.stream().anyMatch(x -> {
            if (x.getAge() == 3) {
                return true;
            }
            return false;
        });
        System.out.println(b);
        System.out.println("====================================");

        //都不符合才是 true
        b = studentList.stream().noneMatch(x -> {
            if (x.getAge() == 9) {
                return true;
            }
            return false;
        });
        System.out.println(b);
    }

}
