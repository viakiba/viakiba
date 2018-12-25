package org.viakiba.stream;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *      获取 Stream 的 方法
 *
 * @author: viakiba
 * @date: 2018/12/25 10:36
 */
public class Stream0 {

    /**
     *      从 Collection 和数组
     * @param:
     * @return:
     * @author: viakiba
     * @date: 2018/12/25 16:53
     */
    @Test
    public void test1(){
        List<Integer> integers = Arrays.asList(1, 2, 3);

//        integers.stream()
//        integers.parallelStream()

//        Arrays.stream(new int[])

//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

//        Stream<String> lines = BufferedReader.lines();

    }


    /**
     *  静态工厂
     * @param:
     * @return:
     * @author: viakiba
     * @date: 2018/12/25 16:57
     */
    @Test
    public void test2(){
//        IntStream range = IntStream.range();

//        Stream<Path> walk = Files.walk();
    }

    /**
     *  自己构建
     * @param: 
     * @return: 
     * @author: viakiba
     * @date: 2018/12/25 16:59
     */
    @Test
    public void test3(){
//        java.util.Spliterator
    }

    /**
     *   其他方式
     * @param:
     * @return:
     * @author: viakiba
     * @date: 2018/12/25 17:00
     */
    @Test
    public void test4(){
//        IntStream ints = Random.ints();

//        IntStream stream = BitSet.stream();

//        Stream<JarEntry> stream = JarFile.stream();
    }


}
