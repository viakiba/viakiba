import com.google.protobuf.InvalidProtocolBufferException;
import hello.world.example.Hello;

import java.util.Base64;

public class Test {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        // write
        String name = "hello_world";
        Hello.Person.Builder builder = Hello.Person.newBuilder();
        builder.setName(name);
        Hello.Person build = builder.build(); // Person 继承 com.google.protobuf.GeneratedMessageV3 抽象类
        //这里就可以了
        byte[] bytes = build.toByteArray();
        System.out.println(Base64.getEncoder().encodeToString(bytes));

        // read
        Hello.Person builderreader = Hello.Person.parseFrom(bytes);
        String nameReader = builderreader.getName();
        System.out.println(nameReader);
    }
}
