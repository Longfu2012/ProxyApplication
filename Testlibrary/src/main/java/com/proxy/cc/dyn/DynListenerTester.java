package com.proxy.cc.dyn;

/**
 * Created by Administrator on 2018/10/18.
 */

public class DynListenerTester {

    private IDynListener mListener;

    public void setListener(IDynListener listener){
        mListener = listener;
    }

    public void show(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long millis = 0;
                while (true){
                    millis += 1000;
                    try {
                        if(null != mListener){
                            mListener.onResult("sleep " + millis + " millis");
                        }
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(millis >= 5000){
                        if(null != mListener){
                            mListener.onResult("test done.");
                        }
                        break;
                    }
                }
            }
        }).start();

    }

}
