package org.viakiba.di.commondipro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.viakiba.di.commondipro.bean.Admin;

/**
 * @author viakiba
 * @description
 * @date Create in 9:05 2018/8/4
 */
@Service
@Slf4j
public class AdminServiceOld extends AbsServiceOld<Admin> implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info(absDao.getType(new Admin()));
    }
}
