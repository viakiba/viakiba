package org.viakiba.di.commondi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description
 *
 * @author viakiba
 * @date Create in 20:43 2018/8/2
 */
@Component
@Slf4j
public class CommonDiAppAnno implements CommandLineRunner {

    @Autowired
    private CommonDiCompoent commonDiCompoent;
    @Autowired
    @Qualifier("commonDiCompoent")
    private CommonInter commonDiCompoents;
    @Resource
    private CommonCompontDi commonCompoentDi;
    @Resource(name = "commonCompoentDi")
    private CommonInter commonCompoentDis;
    @Resource(name = "DicommonCompoent",type = org.viakiba.di.commondi.DiCommonCompont.class)
    private CommonInter diCommonCompoent;

    @Override
    public void run(String... args) throws Exception {
        log.debug(commonDiCompoent.toString());
        log.debug(commonDiCompoents.toString());
        log.debug(""+(commonDiCompoent == commonDiCompoents));
        log.debug(commonCompoentDi.toString());
        log.debug(commonCompoentDis.toString());
        log.debug(""+(commonCompoentDi == commonCompoentDis));
        log.debug(diCommonCompoent.toString());
    }
}
