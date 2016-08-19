package haust.vk.dao;

import haust.vk.entity.Employee;

import java.util.List;

/**
 * 员工模块dao接口设计
 * Created by viakiba on 2016/8/17.
 */
public interface IEmployeeDao {
    /**
     * 保存员工
     * @param emp
     */
    void save(Employee emp);

    /**
     * 更新员工信息
     * @parm Emp
     */
    void update(Employee emp);

    /**
     * 根据主键删除
     */
    void delete(int id);

    /**
     * 根据主键查询
     * @parm id
     * @return
     */
    Employee findById(int id);

    /**
     * 查询全部
     * @parm
     * @return
     */
    List<Employee> getAll();
    /**
     * 根据员工名称条件查询
     * @param employeeName
     * @return
     */
    List<Employee> getAll(String employeeName);
}
