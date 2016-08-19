package haust.vk.service;

import haust.vk.entity.Admin;

/**
 * 管理员业务逻辑接口
 * Created by viakiba on 2016/8/18.
 */
public interface IAdminService {
    /**
     * 注册
     */
    void register(Admin admin);
    /**
     * 登录
     */
    Admin login(Admin admin);
}
