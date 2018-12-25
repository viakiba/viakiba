package org.viakiba.stream.bean;

public class Student implements Comparable{

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student o1 = (Student) o;
        if(o1.getAge() == this.age){
            return 0;
        }

        if(o1.getAge() > this.age){
            return -1;
        }

        return 1;
    }
}
