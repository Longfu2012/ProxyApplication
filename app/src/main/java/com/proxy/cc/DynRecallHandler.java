package com.proxy.cc;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/10/19.
 */

public class DynRecallHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("methodName:" + methodName);
        if(null != args && args.length > 0){
            int size = args.length;
            for(int i = 0 ; i < size ; i++){
                System.out.println("args[" + i + "] = " + args[i]);
            }
        }
        ///////////////////////////
        if("setResult".equals(methodName)){
            Method md = proxy.getClass().getDeclaredMethod("getResult");
            md.setAccessible(true);
            md.invoke(proxy);
        }
        return null;
    }

}
