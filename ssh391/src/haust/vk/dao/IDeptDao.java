package haust.vk.dao;

import haust.vk.entity.Dept;

import java.util.List;

/**
 * Created by viakiba on 2016/8/17.
 */
public interface IDeptDao {
    /**
     * 查询全部
     * @return 返回全部信息
     */
    List<Dept> getAll();

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回查询后的结果
     */
    Dept findById(int id);
}
