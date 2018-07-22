package org.vk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author viakiba
 * @description
 * @date Create in 20:34 2018/7/22
 */
@Service
public class PeopleEatServiceImpl implements PeopleEatService {

    @Autowired
    private EatCompentConfig eatCompentConfig;

    @Override
    public int eatService() {
        System.out.println("eatService 执行");
        return eatCompentConfig.eatConfig;
    }
}
