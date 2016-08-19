package haust.vk.service.impl;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;

import java.util.List;

/**
 * Created by viakiba on 2016/8/19.
 */
public class EmployeeService implements IEmployeeService{
    private IEmployeeDao employeeDao;

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void delete(int id){
        employeeDao.delete(id);
    }

    @Override
    public void deleteMany(int[] ids){
        if(ids != null && ids.length > 0){
            for(int id : ids){
                delete(id);
            }
        }
    }

    @Override
    public Employee findById(int id){
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> getAll(){
       return employeeDao.getAll();
    }

    @Override
    public List<Employee> getAll(String empName){
        return employeeDao.getAll(empName);
    }

    @Override
    public void save(Employee employee){
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee){
        employeeDao.update(employee);
    }

}
