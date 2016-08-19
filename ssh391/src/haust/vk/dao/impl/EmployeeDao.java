package haust.vk.dao.impl;

import haust.vk.dao.IEmployeeDao;
import haust.vk.entity.Employee;

import java.util.List;


public class EmployeeDao extends BaseDao<Employee>  implements IEmployeeDao{

    @Override
    public List<Employee> getAll(String employeeName){
        return getSf().getCurrentSession()
                .createQuery("from Employee where empName LIKE ?")
                .setParameter(0,"%"+ employeeName +"%")
                .list();
    }

    @Override
    public Employee findById(int id){
      /*  return (Employee)getSf().getCurrentSession()
                .get(Employee.class , id);*/
       String hql="from Employee e left join fetch e.dept where e.id=?";
       return (Employee) getSf().getCurrentSession()
               .createQuery(hql)
               .setParameter(0, id)
               .uniqueResult();
    }
}
