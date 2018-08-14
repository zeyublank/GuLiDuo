package com.dangzhongyang.guliduo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends BasePresenter>  extends AppCompatActivity {
    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Type genericInterfaces = this.getClass().getGenericSuperclass();
            //获得第一个实现类中所有泛型参数的集合
            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces).getActualTypeArguments();
            //获得实现接口中第一个泛型的参数
            Class<T> actualTypeArgument = (Class<T>) actualTypeArguments[0];
            presenter = actualTypeArgument.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(this instanceof BaseView){
            presenter.attach(this);
        }
        setContentView(getLayout());
        initView();

    }

    protected abstract void initView();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(this instanceof BaseView){
            presenter.death();
        }
    }
}
