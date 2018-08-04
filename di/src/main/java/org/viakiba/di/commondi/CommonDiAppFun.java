package org.viakiba.di.commondi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description
 * @author viakiba
 * @date Create in 21:46 2018/8/2
 */
@Component
@Slf4j
public class CommonDiAppFun implements CommandLineRunner {

    private CommonInter commonDiCompoents;
    private CommonCompontDi commonCompoentDi;
    private CommonInter commonCompoentDis;
    private CommonInter diCommonCompoent;
    private CommonInter diCommonCompoents;
    private CommonInter diCommonCompoentss;
    private CommonInter diCommonCompoentsss;

    @Autowired
    public CommonDiAppFun(CommonCompontDi diCommonCompoents) {
        this.diCommonCompoents = diCommonCompoents;
    }
    @Autowired
    public void setCommonDiCompoent(CommonDiCompoent commonDiCompoent,CommonCompontDi diCommonCompoentsss) {
        this.diCommonCompoentss = commonDiCompoent;
        this.diCommonCompoentsss = diCommonCompoentsss;

    }
    @Autowired
    @Qualifier("commonDiCompoent")
    public void setCommonDiCompoents(CommonInter commonDiCompoents) {
        this.commonDiCompoents = commonDiCompoents;
    }
    @Resource
    public void setCommonCompoentDi(CommonCompontDi commonCompoentDi) {
        this.commonCompoentDi = commonCompoentDi;
    }
    @Resource(name = "commonCompoentDi")
    public void setCommonCompoentDis(CommonInter commonCompoentDis) {
        this.commonCompoentDis = commonCompoentDis;
    }
    @Resource(name = "DicommonCompoent",type = org.viakiba.di.commondi.DiCommonCompont.class)
    public void setDiCommonCompoent(CommonInter diCommonCompoent) {
        this.diCommonCompoent = diCommonCompoent;
    }
    @Override
    public void run(String... args) throws Exception {
        log.debug(commonDiCompoents.toString());
        log.debug(commonCompoentDi.toString());
        log.debug(commonCompoentDis.toString());
        log.debug(""+(commonCompoentDi == commonCompoentDis));
        log.debug(diCommonCompoent.toString());
    }
}
