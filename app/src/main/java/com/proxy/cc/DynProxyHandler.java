package com.proxy.cc;

import com.proxy.cc.dyn.IDynTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/10/18.
 */

public class DynProxyHandler implements InvocationHandler {

    private Object mRealObj;

    public DynProxyHandler(Object obj){
        mRealObj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method:" + method.getName() + " args:" + args.length);
        method.invoke(mRealObj,args);
        return null;
    }

}
