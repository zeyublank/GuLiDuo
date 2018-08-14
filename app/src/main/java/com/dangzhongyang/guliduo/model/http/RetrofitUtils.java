package com.dangzhongyang.guliduo.model.http;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private RetrofitUtils(){
        okHttpClient=new OkHttpClient.Builder().build();
    }

    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
//    public HomeApiService getHomeApiService(){
//        retrofit=new Retrofit.Builder()
//                .baseUrl("http://v.juhe.cn/toutiao/")
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//        return retrofit.create(HomeApiService.class);
//    }
}
