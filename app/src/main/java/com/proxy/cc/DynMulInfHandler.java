package com.proxy.cc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/10/19.
 */

public class DynMulInfHandler implements InvocationHandler {

    private Object realObj;

    public DynMulInfHandler(Object rlObj){
        realObj = rlObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("method:" + methodName);
        if(null != args && args.length > 0){
            int size = args.length;
            for(int i = 0 ; i < size ; i++){
                System.out.println("args[" + i + "] = " + args[i]);
            }
        }
        ///////////////////////////////////////////////////////////
        if("head".equals(methodName) || "body".equals(methodName) || "foot".equals(methodName)){
            return method.invoke(realObj,args);//has return value
        }
        if("jump".equals(methodName) || "run".equals(methodName)){
            method.invoke(realObj,args);
        }
        return null;
    }
}
