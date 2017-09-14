package com.yuncanting.restcontroller;

import com.yuncanting.utils.SecurityUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 微信推送API
 * @Author viakiba
 * @Date 2017-09-03
 */
public class WechatValidateApi {

    @Resource
    private SecurityUtil securityUtil;
    /**
     * 服务器验证
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        /***/
        System.out.println("=================================");
        System.out.println(timestamp);
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        String token = "viakiba";

        //验证配置
        String signCompar = securityUtil.getSHA1(token, timestamp, nonce);

        PrintWriter pw = resp.getWriter();

        if(signCompar.equals(signature)){
            pw.print(echostr);
        }
    }

    /**
     * 消息接收
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        try {
            System.out.println("");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pw.flush();
            pw.close();
        }
    }
}
