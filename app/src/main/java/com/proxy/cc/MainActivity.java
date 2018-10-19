package com.proxy.cc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.proxy.cc.dyn.DynListenerTester;
import com.proxy.cc.dyn.DynMulInfImpl;
import com.proxy.cc.dyn.DynToolsImpl;
import com.proxy.cc.dyn.IDynItf1;
import com.proxy.cc.dyn.IDynItf2;
import com.proxy.cc.dyn.IDynListener;
import com.proxy.cc.dyn.IDynTools;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    private ITools tools;
    private IDynTools dynTools;
    private IDynListener listener1,listener2;
    private IDynItf1 dynItf1;
    private IDynItf2 dynItf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Static Proxy
        //tools = new ToolsImpl();
        tools = new ProxyToolsImpl(new ToolsImpl());
        findViewById(R.id.static_btn).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tools.showDialog(MainActivity.this);
            }
        });
        //Dynamic Proxy 1
        dynTools = (IDynTools) Proxy.newProxyInstance(getClassLoader(),new Class[]{IDynTools.class},new DynProxyHandler(new DynToolsImpl()));
        findViewById(R.id.dynamic_btn_1).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dynTools.showDialog(MainActivity.this);
            }
        });
        //Dynamic Proxy 2
        listener1 = (IDynListener) Proxy.newProxyInstance(getClassLoader(),new Class[]{IDynListener.class},new DynListenerProxyHandler());
        findViewById(R.id.dynamic_btn_2).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DynListenerTester tester = new DynListenerTester();

                //////////////////////////////
                listener1.setResult("input param.");//will call DynListenerProxyHandler
                String rlt = listener1.getResult();//will call DynListenerProxyHandler and replace result.
                System.out.println(rlt == null ? "output null":rlt);
                /////////////////////////////
                tester.setListener(listener1);
                tester.show();
                ////////////////////////////
            }

        });
        //Dynamic Proxy 3
        listener2 = (IDynListener) Proxy.newProxyInstance(getClassLoader(),new Class[]{IDynListener.class},new DynRecallHandler());
        findViewById(R.id.dynamic_btn_3).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener2.setResult("recall other method.");
            }
        });

        //Dynamic Proxy 4
        final Object proxyObj =  Proxy.newProxyInstance(getClassLoader(),DynMulInfImpl.class.getInterfaces(),new DynMulInfHandler(new DynMulInfImpl()));
        findViewById(R.id.dynamic_btn_4).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dynItf1 = (IDynItf1) proxyObj;
                dynItf1.jump("666");
                dynItf1.run();

                dynItf2 = (IDynItf2) proxyObj;
                dynItf2.head();
                dynItf2.body("obesity");
                dynItf2.foot();

            }
        });

    }
}
