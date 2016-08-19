package haust.vk.service;

import haust.vk.entity.Dept;

import java.util.List;

/**
 * 部门模块业务逻辑层接口
 * Created by viakiba on 2016/8/18.
 */
public interface IDeptService {
    /**
     * 查询全部
     * @return 返回全部信息
     */
    List<Dept> getAll();

    /**
     * 根据主键查询
     * @parm id
     * @return
     */
    Dept findById(int id);
}
