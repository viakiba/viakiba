package org.viakiba.di.mapdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author viakiba
 * @description
 * @date Create in 9:43 2018/8/4
 */
@Component
@Slf4j
public class MapDiApp implements CommandLineRunner {

    @Autowired
    private Map<String,MapDiInter> map;


    @Override
    public void run(String... args) throws Exception {
        log.info(map.toString());
    }
}
