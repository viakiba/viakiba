package org.viakiba.di.otherdi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 9:49 2018/8/4
 */
@Component
@Slf4j
@Data
@Lazy
public class Lazydi {

    private String name = "Lazydi";

}
