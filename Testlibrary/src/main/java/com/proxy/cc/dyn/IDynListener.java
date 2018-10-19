package com.proxy.cc.dyn;

/**
 * Created by Administrator on 2018/10/18.
 */

public interface IDynListener {
    public void onResult(String msg);
    public String getResult();
    public void setResult(String rlt);
}
