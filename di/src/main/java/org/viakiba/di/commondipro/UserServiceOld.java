package org.viakiba.di.commondipro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.viakiba.di.commondipro.bean.Admin;
import org.viakiba.di.commondipro.bean.User;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author viakiba
 * @description
 * @date Create in 9:05 2018/8/4
 */
@Service
@Slf4j
public class UserServiceOld extends AbsServiceOld<User> implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info(absDao.getType(new User()));
    }
}
