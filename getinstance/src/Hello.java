import java.io.*;
import java.lang.reflect.Constructor;

public class Hello implements  Cloneable,Serializable{
    private String str;

    public Hello(String str){
        this.str = str;
    }

    public  Hello(){
        this.str = "class";
    }

    public static void main(String[] args) throws Exception{
        Hello hello = Hello.getInstanceByNew();
        System.out.println(hello.str);
        System.out.println("=============================");
        try{
            Hello instanceByClone = Hello.getInstanceByClone(hello);
            System.out.println(instanceByClone.str);
            System.out.println(hello == instanceByClone);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=============================");
        Hello instanceByClass = Hello.getInstanceByClass();
        System.out.println(instanceByClass.str);
        System.out.println("=============================");

        System.out.println("使用无参构造");
        Hello instanceByConstructor = Hello.getInstanceByConstructor();
        System.out.println(instanceByConstructor.str);
        System.out.println("使用有参构造");
        Hello instanceByConstructor2 = Hello.getInstanceByConstructor("有参构造");
        System.out.println(instanceByConstructor2.str);
        System.out.println("=============================");

        /**
         * 首先 设置一个序列化文件位置
         */
        String path = "hello.obj";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        Hello xlh = new Hello("序列化");
        objectOutputStream.writeObject(xlh);
        objectOutputStream.close();
        /**
         * 反序列化拿到对象
         */
        Hello instanceBySerializable = Hello.getInstanceBySerializable(path);

        System.out.println(instanceBySerializable.hashCode()+"******************");
        System.out.println(xlh.str);
        System.out.println(instanceBySerializable.str);

        System.out.println("结束");
    }


    /**
     * 使用 new
     */
    public static Hello  getInstanceByNew(){
        return new Hello("new");
    }

    /**
     * 使用 clone 使用此方法 class类需要继承 cloneable 接口
     */
    public static  Hello getInstanceByClone(Hello hello) throws CloneNotSupportedException{
        Hello clone1 = (Hello) hello.clone();
        return clone1;
    }

    /**
     * 使用Class的 newInstance 这个newInstance方法调用无参的构造函数创建对象
     */
    public static Hello getInstanceByClass() throws Exception{
        Hello hello = (Hello) Class.forName("Hello").newInstance();
        return hello;
    }

    /**
     * 使用 构造器 无参函数
     */
    public static Hello getInstanceByConstructor() throws Exception{
        Constructor<Hello> constructor = Hello.class.getConstructor();
        Hello hello = constructor.newInstance();
        return hello;
    }

    /**
     * 使用 构造器 有参函数
     */
    public static Hello getInstanceByConstructor(String str) throws Exception{
        Constructor<Hello> constructor = Hello.class.getConstructor(String.class);
        Hello hello = constructor.newInstance(str);
        return hello;
    }

    /**
     * 使用反序列化 获取实例化对象  对象的类要继承 Serializable 接口表示可以进行序列化
     */
    public static Hello getInstanceBySerializable(String path) throws  Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(o.hashCode()+"******************");
        return  (Hello) o;
    }
}
