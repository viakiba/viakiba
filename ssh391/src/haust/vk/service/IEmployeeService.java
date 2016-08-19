package haust.vk.service;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * 员工模块业务逻辑层接口
 * Created by viakiba on 2016/8/18.
 */
public interface IEmployeeService {
    /**
     * 保存
     */
    void save(Employee emp);

    /**
     * 更新
     */
    void update(Employee emp);

    /**
     * 根据主键查询
     */
    Employee findById(int id);

    /**
     * 查询全部
     */
    List<Employee> getAll();

    /**
     *
     */
    List<Employee> getAll(String empName);
    /**
     * 根据在逐渐删除
     */
    void delete(int id);

    /**
     * 删除多个员工
     */
    void deleteMany(int[] ids);
}
