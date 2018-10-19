package com.proxy.cc.dyn;

/**
 * Created by Administrator on 2018/10/19.
 */

public class DynMulInfImpl implements IDynItf1,IDynItf2 {

    @Override
    public void run() {
        System.out.println("hero run!!");
    }

    @Override
    public void jump(String height) {
        System.out.println("hero jump!ooh~~ " + height + " m");
    }

    @Override
    public String head() {
        return "hero head";
    }

    @Override
    public String body(String shape) {
        return "hero body,your body is too " + shape;
    }

    @Override
    public String foot() {
        return "hero foot";
    }
}
