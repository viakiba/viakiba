package org.viakiba.desc;

import com.google.protobuf.*;
import org.junit.Test;
import org.viakiba.protobuf.message.mes.DemoMessage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDesc {

    /**
     * msgId 扩展字段
     * @throws IOException
     */
    @Test
    public void testMsgIdExtendInfo() throws IOException {
        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos.FileDescriptorSet.parseFrom(new FileInputStream("/Users/dd/Documents/protoDescAnalytics/protoc/desc/test.desc"));
        for (DescriptorProtos.FileDescriptorProto fileDescriptorProto : fdSet.getFileList()) {
            //fileDescriptorProto.getExtensionList() 获取扩展（proto中的extend）列表
            for (DescriptorProtos.FieldDescriptorProto fieldDescriptorProto : fileDescriptorProto.getExtensionList()) {
//                System.out.println(fieldDescriptorProto);
                System.out.println(fieldDescriptorProto.getName() + "   " + fieldDescriptorProto.getNumber());
            }
        }
    }

    @Test
    public void testMesMetaAnalytics() throws Exception {
        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos.FileDescriptorSet.parseFrom(new FileInputStream("/Users/dd/Documents/protoDescAnalytics/protoc/desc/test.desc"));
        //可以将多个proto文件的描述信息生成到同一个desc文件，每个proto文件对应一个FileDescriptorProto对象
        //FileDescriptorProto包含proto文件的信息，比如name、option（比如定义的java_package，java_outer_classname等）、消息等
        for (DescriptorProtos.FileDescriptorProto fileDescriptorProto : fdSet.getFileList()) {
            System.out.println(" ==================================  开始文件" + fileDescriptorProto.getName() + " 解析打印 ==================================");
            System.out.println("proto 文件名称 ：" + fileDescriptorProto.getName());
            System.out.println("proto 文件Options参数 ：\n" + fileDescriptorProto.getOptions());
            //DescriptorProto 代表 proto文件  中的一个消息 (getMessageTypeList 方法获取)
            for (DescriptorProtos.DescriptorProto descriptorProto : fileDescriptorProto.getMessageTypeList()) {
                System.out.println("消息名称 " + fileDescriptorProto.getOptions().getJavaPackage() +"."+fileDescriptorProto.getOptions().getJavaOuterClassname() + "."+ descriptorProto.getName() + " 的字段信息 ======");
                //FieldDescriptorProto 代表消息中的一个字段，包含名称、tag、类型等信息
                for (DescriptorProtos.FieldDescriptorProto fieldDescriptorProto : descriptorProto.getFieldList()) {
                    System.out.println("字段名称 "+fieldDescriptorProto.getName() + " ,字段index " + fieldDescriptorProto.getNumber() + " ,字段类型 "+ fieldDescriptorProto.getType().name());
                }
                System.out.println("消息名称 " + descriptorProto.getName() + " 的字段信息 ======");
                //如果消息中使用了自定义选项，通过UnknownFieldSet可以获取到相关信息
                UnknownFieldSet uf = descriptorProto.getOptions().getUnknownFields();
                for (Map.Entry<Integer, UnknownFieldSet.Field> entry : uf.asMap().entrySet()) {
                    System.out.println("额外的字段  key:" + entry.getKey() + " ,字段的值" + entry.getValue().getVarintList());
                    // entry.getKey() 与 options 的字段一致。  这里找的就是消息号
                }
            }
            System.out.println(" ==================================  结束文件" + fileDescriptorProto.getName() + " 解析打印 ==================================");
        }
    }

    @Test
    public void testMesAnalytics() throws Exception {
        DemoMessage.Server.Builder builder = DemoMessage.Server.newBuilder();
        builder.setTime(1000);
        DemoMessage.Server build = builder.build();
        byte[] bytes = build.toByteArray();

        // 核心就是 forName 参数
        Object newBuilder = Class.forName("org.viakiba.protobuf.message.mes.DemoMessage$Server").getMethod("newBuilder").invoke(null);
        GeneratedMessageV3.Builder clone1 = ((GeneratedMessageV3.Builder) newBuilder).clone();
        clone1.mergeFrom(bytes);
        Message build1 = clone1.build();
        System.out.println( ( (DemoMessage.Server)build1).getTime());
    }

    @Test
    public void testDynamicMessageAnalytics() throws Exception {
        DemoMessage.Server.Builder builder = DemoMessage.Server.newBuilder();
        builder.setTime(1000);
        DemoMessage.Server build = builder.build();
        byte[] bytes = build.toByteArray(); //测试数据

        HashMap<Long, Object> msgId2GeneratedMessageV3Builder = new HashMap<>();
        initDesc(msgId2GeneratedMessageV3Builder); //根据描述文件初始化注册器

        // 核心就是 forName 参数 消息号约定好的 100010 （TLV格式或者放到header里面）
        GeneratedMessageV3.Builder clone1 = ( (GeneratedMessageV3.Builder)msgId2GeneratedMessageV3Builder.get( (long)100010) ).clone();
        clone1.mergeFrom(bytes);
        Message build1 = clone1.build();
        System.out.println( ( (DemoMessage.Server)build1).getTime());
    }

    private static void initDesc(HashMap<Long, Object> msgId2GeneratedMessageV3Builder) throws Exception {
        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos.FileDescriptorSet.parseFrom(new FileInputStream("/Users/dd/Documents/protoDescAnalytics/protoc/desc/test.desc"));
        for (DescriptorProtos.FileDescriptorProto fileDescriptorProto : fdSet.getFileList()) {
            for (DescriptorProtos.DescriptorProto descriptorProto : fileDescriptorProto.getMessageTypeList()) {
                String className = fileDescriptorProto.getOptions().getJavaPackage() + "." + fileDescriptorProto.getOptions().getJavaOuterClassname() + "$" + descriptorProto.getName();
                UnknownFieldSet uf = descriptorProto.getOptions().getUnknownFields();
                for (Map.Entry<Integer, UnknownFieldSet.Field> entry : uf.asMap().entrySet()) {
                    if (entry.getKey() == 54321) {// entry.getKey() 与 options 的字段一致。 注册到map上
                        msgId2GeneratedMessageV3Builder.put(entry.getValue().getVarintList().get(0),Class.forName(className).getMethod("newBuilder").invoke(null));
                    }
                    System.out.println("额外的字段  key:" + entry.getKey() + " ,字段的值" + entry.getValue().getVarintList());
                }
            }
        }
    }

    @Test
    public void testDynamicMessageAnalytics1() throws Exception {
        DemoMessage.Server.Builder builder = DemoMessage.Server.newBuilder();
        builder.setTime(1000);
        DemoMessage.Server build = builder.build();
        byte[] bytes = build.toByteArray(); //测试数据

        DynamicMessage dynamicMessage = DynamicMessage.parseFrom(build.getDescriptorForType(), bytes);
        System.out.println(dynamicMessage.getField(DemoMessage.Server.getDescriptor().findFieldByNumber(1)));
    }

}
