package haust.vk.dao;

import haust.vk.entity.Admin;

/**
 * Created by viakiba on 2016/8/17.
 */
public interface IAdminDao {
    /**
     * 保存
     * @parm admin 管理员对象
     */
    void save(Admin admin );

    /**
     * 根据管理员信息查询
     * @parm admin 管理员对象
     * @return 返回查询后的结果
     */
    Admin findByAdmin(Admin admin);
}
