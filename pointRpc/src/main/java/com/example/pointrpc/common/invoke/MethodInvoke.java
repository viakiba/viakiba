package com.example.pointrpc.common.invoke;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodInvoke {

    private static final Logger logger = LoggerFactory.getLogger(MethodInvoke.class);

    public static Object invoke(String methodName, Class<?>[] parameterTypes, Object serviceBean,Object[] parameters) throws Exception{
        logger.debug("param type");
        for (int i = 0; i < parameterTypes.length; ++i) {
            logger.debug(parameterTypes[i].getName());
        }
         logger.debug("param value");
        for (int i = 0; i < parameters.length; ++i) {
            logger.debug(parameters[i].toString());
        }

        Method method = serviceBean.getClass().getMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(serviceBean, parameters);

        // FastClass serviceFastClass = FastClass.create(serviceBean.getClass(),);
        // int methodIndex = serviceFastClass.getIndex(methodName, parameterTypes);
        // return serviceFastClass.invoke(methodIndex, serviceBean, parameters);
    }
    
}
