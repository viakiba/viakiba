package com.company;

import com.company.bean.GroovyDemo;
import com.company.hotreload.HotReloadClassData;
import com.company.hotreload.HotReloadService;
import com.company.hotreload.HotReloadTask;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考：
 *      https://www.ibm.com/developerworks/cn/java/j-lo-jse61/index.html
 *      http://www.wuqianling.top/software/notepad/compress.html
 *
 * Premain-Class: com.company.hotreload.InstrumentationHolder
 * Can-Redefine-Classes: true
 */
public class HotLoadTest {

    public static GroovyDemo grooyDemo = new GroovyDemo();

    public HotLoadTest(){
    }

    public static void main(String[] args){
        int i=1;
        while(i<10){
            grooyDemo.main(i+"<<<<<");
            if (i==4){
                //触发热更新
                Map<String,String> name2Codes = new HashMap<>();
                name2Codes.put("com.company.bean.GroovyDemo","package com.company.bean; public class GroovyDemo { public String main(String... args){ System.out.println(\"fix Hello World\"+args[0]); return \"<><><><>\"; } }");
                HotReloadTask hotReloadTask = new HotReloadTask(name2Codes);
                hotReloadTask.run();
                HotReloadClassData hotReloadClassData = hotReloadTask.hotreloadClassData.get(0);
                HotReloadService.getInstance().hotReload(hotReloadClassData);
            }
            i++;
        }
    }

}
