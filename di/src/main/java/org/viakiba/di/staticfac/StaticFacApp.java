package org.viakiba.di.staticfac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author viakiba
 * @description
 * @date Create in 8:26 2018/8/4
 */
@Component
@Slf4j
public class StaticFacApp implements CommandLineRunner {

    @Autowired
    private StaticFacBean1 staticFacBean1;

    @Bean()
    public StaticFacBean1 getStaticFacBean1(){
        return new StaticFacBean1();
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug(staticFacBean1.toString());
    }

}
