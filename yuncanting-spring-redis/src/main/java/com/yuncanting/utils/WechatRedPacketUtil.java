package com.yuncanting.utils;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

/**
 * @Description https://github.com/viakiba/crmwechat/blob/master/src/com/xdailiao/wechat/pay/RedPacketUtil.java
 * @Author viakiba
 * @Date 2017-09-03
 */
@Component
public class WechatRedPacketUtil {
    /**
     *
     * openid 用户的openid  num 红包金额
     * @throws ClassNotFoundException
     * @throws Exception
     * @throws FileNotFoundException
     */
//    public static String RedPacketService(String openid,String num ) throws ClassNotFoundException, FileNotFoundException, Exception{
//        StringBuffer sb = new StringBuffer();
//        RedpacketSendbean redpack = new RedpacketSendbean();
//        String genstr = GenOrderId.GenString();
//        String[] temp = genstr.split("_");
//        System.out.println(temp[1]);
//        //设置完成 除sign外的所有信息
//        redpack.setNonce_str(temp[0]);
//        redpack.setMch_billno(WechatPropertiesUtil.getMch_id()+temp[1]);
//        System.out.println((WechatPropertiesUtil.getMch_id()+temp[1]).length());
//        redpack.setMch_id(WechatPropertiesUtil.getMch_id());
//        redpack.setWxappid(WechatPropertiesUtil.getWxappid());
//        redpack.setSend_name(WechatPropertiesUtil.getSend_name());
//        redpack.setRe_openid(openid);
//        redpack.setTotal_amount(num);
//        redpack.setTotal_num(WechatPropertiesUtil.getTotal_num());
//        redpack.setWishing(WechatPropertiesUtil.getWishing());
//        redpack.setClient_ip(WechatPropertiesUtil.getClient_ip());
//        redpack.setAct_name(WechatPropertiesUtil.getAct_name());
//        redpack.setRemark(WechatPropertiesUtil.getRemark());
//
//        //生成sign
//        //拿到属性名称  属性值不为空
//        Field[] fileds = redpack.getClass().getDeclaredFields();
//        temp = new String[fileds.length];
//        for(int i=0;i<fileds.length;i++){
//            temp[i] = fileds[i].getName();
//        }
//        //进行名称排序
//        Arrays.sort(temp);
//        //获取value 并进行 字符串拼接
//        for(int i=0;i<temp.length;i++){
//            Method method = null;
//            Object value = null;
//            try{
//                temp[i] = temp[i].substring(0, 1).toUpperCase()+temp[i].substring(1);
//                method = redpack.getClass().getMethod("get"+temp[i]);
//                value = method.invoke(redpack);
//                if(value != null & value != null){
//                    sb.append(temp[i].toLowerCase()+"="+value+"&");
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//                System.out.println("setter和getter 异常");
//            }
//        }
//        String str = sb.toString().substring(0, sb.toString().length()-1);
//        str = Md5Util.GenMd5(str+"&key="+WechatPropertiesUtil.getPaykey()).toUpperCase();
//        redpack.setSign(str);
//        str = Bean2TextXml.beantoTextXmlRead(redpack);
//        return str;
//    }
}
