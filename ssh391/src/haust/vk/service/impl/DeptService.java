package haust.vk.service.impl;

import haust.vk.dao.IDeptDao;
import haust.vk.entity.Dept;
import haust.vk.service.IDeptService;

import java.util.List;

/**
 * Created by viakiba on 2016/8/19.
 */
public class DeptService implements IDeptService{
    private IDeptDao deptDao;

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public List<Dept> getAll(){
        return deptDao.getAll();
    }

    public Dept findById(int id){
        return deptDao.findById(id);
    }
}
