# proto 解析

## 背景

```text
    在游戏开发过程中，很多项目都是用 protobuf 进行消息序列化与反序列化。
    在服务器收到客户端发来的消息进行反序列化时，根据 消息 msgId ，对消息体进行解析到对应的消息。
```

原来都是用的id手写的注册器或者生产注册器代码，去根据注册器的对象进行反序列化。类似如下：

```text
ms.Register(&protobufEmpty.Empty{})
ms.Register(&com.BattleHeroEquipInfo{})
ms.Register(&com.BattleHeroInfo{})
ms.Register(&com.BattleHeroWeaponInfo{})
ms.Register(&com.BattleMsg{})
ms.Register(&com.BattlePlayerInfo{})
ms.Register(&com.DBChapterReward{})
ms.Register(&com.DBChapterRewardInfo{})
ms.Register(&com.DBChapterUntreatedReward{})
ms.Register(&com.DBDailyReset{})
ms.Register(&com.DBEquipInfo{})
```

## protobuf 自描述特性

protoc 有一个 --descriptor_set_out 可以导出消息的 描述文件，官方各种语言的sdk都提供解析api。接下来我们通过一个java的demo项目开展思路讲解。

```text
环境
    java8 + maven
依赖
    <dependency>
        <groupId>com.google.protobuf</groupId>
        <artifactId>protobuf-java</artifactId>
        <version>3.19.4</version>
    </dependency>
protoc导出代码的工具下载：
    https://github.com/protocolbuffers/protobuf/releases
```

## 项目结构

```text
❯ tree
.
├── genMes.sh                                               生成消息代码的脚本 根目录执行 生成位置  ./src/main/java/
├── genMesDesc.sh                                           生成描述文件的脚本 根目录执行 生成位置  ./protoc/desc/test.desc
├── pom.xml
├── protoc
│   ├── desc
│   │   └── test.desc
│   ├── mac
│   │   ├── download.md
│   │   └── protoc
│   └── message
│       └── mes
│           ├── demo.proto
│           ├── google
│           │   └── protobuf
│           │       ├── any.proto
│           │       ├── api.proto
│           │       ├── compiler
│           │       │   └── plugin.proto
│           │       ├── descriptor.proto
│           │       ├── duration.proto
│           │       ├── empty.proto
│           │       ├── field_mask.proto
│           │       ├── source_context.proto
│           │       ├── struct.proto
│           │       ├── timestamp.proto
│           │       ├── type.proto
│           │       └── wrappers.proto
│           └── options.proto
├── readme.md
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── viakiba
    │   │           └── protobuf
    │   │               └── message
    │   │                   └── mes
    │   │                       ├── DemoMessage.java
    │   │                       └── Options.java
    │   └── resources
    └── test
        └── java
            └── org
                └── viakiba
                    └── desc
                        └── TestDesc.java

22 directories, 24 files
```

## options.proto

```text
声明 扩展字段 msgId , 定义消息号使用。
```

如何使用 见 demo.proto 新建的 消息例子。

## TestDesc（test里面）
执行了 genMesDesc.sh 与 genMes.sh 之后，见test里面的测试代码。
### 解析扩展字段 （testMsgIdExtendInfo）

```java
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

//输出：
//msgId   54321
```

### 解析描述文件（testMesMetaAnalytics）

```java
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
                // entry.getKey() 与 options 的字段一致。
            }
        }
        System.out.println(" ==================================  结束文件" + fileDescriptorProto.getName() + " 解析打印 ==================================");
    }
}
```

输出

```text
 ==================================  开始文件options.proto 解析打印 ==================================
proto 文件名称 ：options.proto
proto 文件Options参数 ：
java_package: "org.viakiba.protobuf.message.mes"
java_outer_classname: "Options"

 ==================================  结束文件options.proto 解析打印 ==================================
 ==================================  开始文件demo.proto 解析打印 ==================================
proto 文件名称 ：demo.proto
proto 文件Options参数 ：
java_package: "org.viakiba.protobuf.message.mes"
java_outer_classname: "DemoMessage"

消息名称 org.viakiba.protobuf.message.mes.DemoMessage.Server 的字段信息 ======
字段名称 Time ,字段index 1 ,字段类型 TYPE_INT64
消息名称 Server 的字段信息 ======
额外的字段  key:54321 ,字段的值[100010]
 ==================================  结束文件demo.proto 解析打印 ==================================
```

### 根绝msgId动态解析消息

```java
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
```

    testDynamicMessageAnalytics 里面最后一行，强转对象到预期的类型即可。这样就完成对应类型的解析。
    这种方法 比 DynamicMessage 方法摇号，因为 DynamicMessage 无法很容易的获得字段值。如下是其中一直：

DynamicMessage 方式

```text
 @Test
public void testDynamicMessageAnalytics1() throws Exception {
    DemoMessage.Server.Builder builder = DemoMessage.Server.newBuilder();
    builder.setTime(1000);
    DemoMessage.Server build = builder.build();
    byte[] bytes = build.toByteArray(); //测试数据

    DynamicMessage dynamicMessage = DynamicMessage.parseFrom(build.getDescriptorForType(), bytes);
    System.out.println(dynamicMessage.getField(DemoMessage.Server.getDescriptor().findFieldByNumber(1)));
    // 1000
}
```