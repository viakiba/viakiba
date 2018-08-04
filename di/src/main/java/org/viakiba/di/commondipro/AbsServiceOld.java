package org.viakiba.di.commondipro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author viakiba
 * @description
 * @date Create in 9:22 2018/8/4
 */
@Slf4j
public abstract class AbsServiceOld<M extends Serializable> {

    AbsDao<M> absDao;

    @Autowired
    public void setRepository(AbsDao<M> repository) {
        this.absDao = repository;
    }

    public void getType(M m){
        log.info(m.getClass().getName());
    }
}
