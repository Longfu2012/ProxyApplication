package com.proxy.cc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/10/18.
 */

public class DynListenerProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method:" + method.getName());
        if(null != args && args.length > 0){
            int size = args.length;
            for(int i = 0 ; i < size ; i++){
                System.out.println("args[" + i + "] = " + args[i]);
            }
        }
        if("getResult".equals(method.getName())){// if result null by call getResult,replace result.
            return "output param, getResult is ok.(~smile~)";
        }
        return null;
    }
}
