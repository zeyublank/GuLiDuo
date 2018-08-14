package com.dangzhongyang.guliduo.base;

public interface BasePresenter <T>{
    void attach(T view);
    void death();
}
