package com.example.jsonapi.apimanager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse {
    public static Retrofit retrofit;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public  static OkHttpClient client;



    public static Retrofit getRetrofit(){
        if(retrofit == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    // simple retrofit api call instance...
    public static Api getApi(){
        return getRetrofit().create(Api.class);
    }

    // Rx java api call instance...
    public static RxApi getRxApi(){ return  getRetrofit().create(RxApi.class); }
}
