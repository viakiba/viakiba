package haust.vk.entity;

/**
 * Created by viakiba on 2016/8/17.
 */
public class Employee {
    private int id;
    private String empName;
    private double salary;
    private Dept dept;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }
}
