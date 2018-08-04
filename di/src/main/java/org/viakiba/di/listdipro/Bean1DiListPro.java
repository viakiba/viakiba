package org.viakiba.di.listdipro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.viakiba.di.listdipro.bean.Bean1;
import org.viakiba.di.listdipro.bean.Bean2;
import org.viakiba.di.listdipro.bean.BeanInter1;

/**
 * @author viakiba
 * @description
 * @date Create in 10:08 2018/8/4
 */
@Component
@Slf4j
public class Bean1DiListPro extends AbsDiListPro<Bean1, Bean2> {


    @Override
    public <T extends BeanInter1> T getRest(T t, Bean2 bean2) {
        log.info(t+"");
        log.info(bean2.toString());
        return t;
    }
}
