package haust.vk.dao;

import java.util.List;

/**
 * 所有dao的通用接口定义
 * Created by viakiba on 2016/8/17.
 */
public interface IBaseDao<T> {
    /**
     * 保存
     * @parm emp
     */
    void save(T emp);

    /**
     * 更新对象信息
     * @parm emp
     */
    void update(T emp);

    /**
     * 根据主键删除
     * @parm id
     */
    void delete(int id);

    /**
     * 根据主键查询
     * @return
     */
    T findById(int id);

    /**
     * 查询全部
     * @return
     */
    List<T> getAll();
}
