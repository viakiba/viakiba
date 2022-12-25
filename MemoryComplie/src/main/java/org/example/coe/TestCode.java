package org.example.coe;

public class TestCode {

    public static void main(String[] args) throws Exception {
        new Test().print();
        DynamicEngine.redefineClass("org.example.coe.Test","package org.example.coe;\n" +
                "\n" +
                "class Test {\n" +
                "\n" +
                "    public void print(){\n" +
                "        System.out.println(\"xx\");\n" +
                "    }\n" +
                "\n" +
                "}\n");
        new Test().print();
    }
}

class Test {
    public void print(){
        System.out.println("yyyy");
    }
}