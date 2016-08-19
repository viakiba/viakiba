package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import haust.vk.entity.Admin;
import haust.vk.service.IAdminService;

/**
 * Created by viakiba on 2016/8/19.
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
    private Admin admin = new Admin();

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    @Override
    public Admin getModel(){
        return admin;
    }

    //service
    private IAdminService adminService;

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    //登录
    public String login(){
        //登录验证
        Admin adminInfo = adminService.login(admin);

        //验证
        if(adminInfo == null){
            //登录失败
            return "loginFaild";
        }else{
            //登录成功，保存到session
            ActionContext.getContext().getSession().put("adminInfo",adminInfo);
            return "index";
        }


    }
}
