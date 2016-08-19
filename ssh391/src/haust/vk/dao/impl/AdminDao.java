package haust.vk.dao.impl;

import haust.vk.dao.IAdminDao;
import haust.vk.entity.Admin;
import org.hibernate.SessionFactory;

/**
 * Created by viakiba on 2016/8/17.
 */
public class AdminDao implements IAdminDao{
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Admin findByAdmin(Admin admin){
        return (Admin) sf.getCurrentSession()
                .createQuery("from Admin where adminName = ? and pwd= ? ")
                .setString(0,admin.getAdminName())
                .setString(1,admin.getPwd())
                .uniqueResult();
    }

    @Override
    public void save(Admin admin){
        sf.getCurrentSession().save(admin);
    }
}
