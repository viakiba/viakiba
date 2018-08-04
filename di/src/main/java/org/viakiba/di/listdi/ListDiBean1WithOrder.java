package org.viakiba.di.listdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 9:32 2018/8/4
 */
@Component
@Slf4j
@Order(3)
public class ListDiBean1WithOrder implements ListDiInterWithOrder {
    @Override
    public void printType() {
        log.info("ListDiBean1WithOrder");
    }
}
