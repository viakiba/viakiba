package haust.vk.dao.impl;

import haust.vk.dao.IDeptDao;
import haust.vk.entity.Dept;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viakiba on 2016/8/18.
 */
public class DeptDao implements IDeptDao{
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
   public List<Dept> getAll(){
        return sf.getCurrentSession().createQuery("from Dept").list();
    }

    @Override
   public Dept findById(int id){
        return (Dept)sf.getCurrentSession().get(Dept.class, id);
    }
}
