package org.viakiba.di.commondipro;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author viakiba
 * @description
 * @date Create in 8:58 2018/8/4
 */
@Slf4j
public abstract class AbsDao<M extends Serializable>{

    public String getType(M m){
        return m.getClass().getName();
    }

}
