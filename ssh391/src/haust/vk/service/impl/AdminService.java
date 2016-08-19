package haust.vk.service.impl;

import haust.vk.dao.IAdminDao;
import haust.vk.dao.impl.AdminDao;
import haust.vk.entity.Admin;
import haust.vk.service.IAdminService;

/**
 * Created by viakiba on 2016/8/19.
 */
public class AdminService implements IAdminService{
    private IAdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }


    @Override
    public void register(Admin admin){
       adminDao.save(admin);
   }

    @Override
   public Admin login(Admin admin){
       return adminDao.findByAdmin(admin);
    }
}
