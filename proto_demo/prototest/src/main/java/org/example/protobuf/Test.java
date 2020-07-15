package org.example.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.JsonFormat;
import org.example.protobuf.message.AdressOuterClass;
import org.example.protobuf.message.PersonMessage;

import java.util.Base64;
import java.util.HashMap;

public class Test {

    private static JsonFormat.Printer printer = JsonFormat.printer().omittingInsignificantWhitespace();

    public static void main(String[] args) throws InvalidProtocolBufferException {
        // write
        String name = "hello_world";
        PersonMessage.Person.Builder builder = PersonMessage.Person.newBuilder();
        builder.addName(name);// name 属性
        HashMap<String, String> map = new HashMap<>();
        map.put("1","sad");
        builder.putAllBag(map);// bag 属性
        AdressOuterClass.Adress.Builder adress = AdressOuterClass.Adress.newBuilder();
        adress.setAdressName("长安街100号");
        builder.setAdress(adress);//Adress 属性
        PersonMessage.Sex.Builder sex = PersonMessage.Sex.getDefaultInstance().toBuilder();
        sex.setSexType(PersonMessage.SexType.woman);
        builder.setSex(sex.build());// sex 属性
        PersonMessage.Person.High defaultInstance = PersonMessage.Person.High.getDefaultInstance();
        PersonMessage.Person.High.Builder high = defaultInstance.newBuilderForType().setHeighNum(100);
        builder.setHigh(high);
        byte[] bytes = builder.build().toByteArray();
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        //byte数组 可以在网路中 通过 TCP 进行传递 例如 socket
        // read
        PersonMessage.Person builderreader = PersonMessage.Person.parseFrom(bytes);
        String nameReader = builderreader.getName(0);
        // 输出 这是 protobuf 提供的 toString 工具 格式化输出 目前已经被标记为废弃 但是还能用
        System.out.println("-----------------------文本格式----------------------");
        String ret = TextFormat.printToString(builderreader);
        System.out.println(ret);
        System.out.println("-----------------------转为JSON格式----------------------");
        // 也可以使用 protobuf-java-util pom文件有依赖 这个可以使 输出json字符串
        String jsonStr = printer.print(builderreader);
        System.out.println(jsonStr);
        System.out.println("-----------------------name第一个值----------------------");
        System.out.println(nameReader);
        System.out.println("-----------------------sex属性----------------------");
        System.out.println(builderreader.getSex().getSexType().getNumber());
        System.out.println("-----------------------json转protobuf对象并输出字符串----------------------");
        // json 转 protobuf
        PersonMessage.Person.Builder newPerson = PersonMessage.Person.newBuilder();
        JsonFormat.parser().merge(jsonStr,newPerson);
        jsonStr = printer.print(builderreader);
        System.out.println(jsonStr);
    }
}
