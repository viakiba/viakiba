package org.vk.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 20:35 2018/7/22
 */
@Component
public class EatCompentConfig {

    @Value("${eat.comfig}")
    int eatConfig;

}
