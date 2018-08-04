package org.viakiba.di.otherdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 9:50 2018/8/4
 */
@Component
@Slf4j
public class LazydiApp implements CommandLineRunner {

    @Lazy
    @Autowired
    private Lazydi lazydi;

    @Override
    public void run(String... args) throws Exception {
        log.info("");
//       log.info(lazydi.toString());
    }
}
