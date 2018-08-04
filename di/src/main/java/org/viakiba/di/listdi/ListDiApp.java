package org.viakiba.di.listdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author viakiba
 * @description
 * @date Create in 9:34 2018/8/4
 */
@Component
@Slf4j
public class ListDiApp implements CommandLineRunner {

    @Autowired
    private List<ListDiInterNoOrder> lostNoOrder;
    @Autowired
    private List<ListDiInterWithOrder> lostWithOrder;

    @Override
    public void run(String... args) throws Exception {
        log.info(lostNoOrder.size() + "");
        log.info(lostWithOrder.size() + "");
    }
}
