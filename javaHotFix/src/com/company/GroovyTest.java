package com.company;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GroovyTest {

    @Test
    public void testGroovyFile() throws IOException {
        GroovyShell groovyShell = new GroovyShell();
        Object evaluate = groovyShell.evaluate(new File("C:\\Users\\89264\\Desktop\\hotload\\src\\com\\company\\GroovyDemo.java"));
    }
    @Test
    public void testGroovyScript() throws IOException {
        GroovyShell groovyShell = new GroovyShell();
        /*
        public String main(String[] args){
            System.out.println("=================");
            return "<><><><>";
        }
         */
        Script script = groovyShell.parse("String test(String[] args){\n" +
                "        System.out.println(\"=================\");\n" +
                "        return \"<><><><>\";\n" +
                "    }" );
        String[] strings = new String[1];
        strings[0] = "dsa";
        Object main = script.invokeMethod("test","");
        System.out.println(main);
    }

}
