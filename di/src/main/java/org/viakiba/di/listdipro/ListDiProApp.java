package org.viakiba.di.listdipro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.viakiba.di.listdipro.bean.Bean1;
import org.viakiba.di.listdipro.bean.Bean2;

import java.util.List;

/**
 * @description
 * @author viakiba
 * @date Create in 9:48 2018/8/4
 */
@Component
@Slf4j
public class ListDiProApp implements CommandLineRunner {

    @Autowired
    private List<AbsDiListPro> list;

    @Override
    public void run(String... args) throws Exception {
        log.info(list.size() + "");
        for(AbsDiListPro absDiListPro : list){
            log.info(absDiListPro.getRest(new Bean1(),new Bean2())+"");
        }
    }

}
