package org.viakiba.di.mapdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 9:43 2018/8/4
 */
@Component
@Slf4j
public class MapDiBean1 implements MapDiInter {
    @Override
    public void printType() {
        log.info(this.getClass().getName());
    }
}
