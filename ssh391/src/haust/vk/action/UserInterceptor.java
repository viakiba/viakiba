package haust.vk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by viakiba on 2016/8/19.
 */
public class UserInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception{
        //得到当前执行的方法
        String methodName = invocation.getProxy().getMethod();
        //得到ActionContext对象
        ActionContext ac = invocation.getInvocationContext();
        //获取session，从session中获取登录的管理员账号
        Object obj = ac.getSession().get("adminInfo");

        //判断
        if(!"login".equals(methodName) && !"list".equals(methodName)){
            //验证
            if(obj == null){
                //没有登录
                return "login";
            }else{
                //执行action
                return invocation.invoke();
            }

        }else{
            //允许访问登录，列表展示
            return invocation.invoke();
        }
    }
}
