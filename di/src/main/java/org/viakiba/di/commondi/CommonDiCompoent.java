package org.viakiba.di.commondi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author viakiba
 * @description
 * @date Create in 20:41 2018/8/2
 */
@Component("commonDiCompoent")
@Slf4j
@Data
public class CommonDiCompoent implements CommonInter{

    private String  username = "CommonDiCompoent";

}
