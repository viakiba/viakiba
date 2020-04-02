package haust.vk.springboot.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 *
 * Created by bysocket on 16/4/26.
 */
public class HelloWorldControllerTest {

    @Test
    public void testSayHello() {
    	System.out.println("3");
        assertEquals("Hello,World! 11sa1",new HelloWorldController().sayHello());
        System.out.println("haha 2");
    }
}
