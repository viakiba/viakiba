package org.viakiba.di.commondipro.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author viakiba
 * @description
 * @date Create in 8:59 2018/8/4
 */
@Slf4j
@Data
public class User implements Serializable {

    private String userName = "user";

}
