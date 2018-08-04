package org.viakiba.di.commondi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 20:41 2018/8/2
 */
@Component("commonCompoentDi")
@Slf4j
@Data
public class CommonCompontDi implements CommonInter{

    private String  username = "CommonCompontDi";

}
