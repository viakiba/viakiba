package org.excmple;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Hello1 {

    public static void main(String[] args) throws IOException {
        // write
        String name = "哈哈哈";
        tutorial.Hello.Person.Builder builder = tutorial.Hello.Person.newBuilder();
        builder.setName(name);
        tutorial.Hello.Person build = builder.build();
        //这里就可以了
        byte[] bytes = build.toByteArray();
        System.out.println(Base64.getEncoder().encodeToString(bytes));

        // read
        tutorial.Hello.Person builderreader = tutorial.Hello.Person.parseFrom(bytes);
        String nameReader = builderreader.getName();
        System.out.println(nameReader);
    }

}
