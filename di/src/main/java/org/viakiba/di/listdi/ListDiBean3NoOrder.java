package org.viakiba.di.listdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 9:32 2018/8/4
 */
@Slf4j
@Component
public class ListDiBean3NoOrder implements ListDiInterNoOrder {
    @Override
    public void printType() {
        log.info("ListDiBean3NoOrder");
    }
}
