package com.example.cooper_up.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    //gestiona retrofit
//patron singleton
    private static ApiAdapter instance = null;
    private static Retrofit retrofitClient = null;
    private static ApiService apiService = null;
    private ApiAdapter(){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        OkHttpClient okHttpClient = okHttpBuilder.build();
        retrofitClient =  new Retrofit.Builder()
                .baseUrl("http://192.168.128.233:8086")//link de la url(seria el puerto de nuestro locahost ) que es tu ip
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        apiService =   retrofitClient.create(ApiService.class);
    }

    //instancia del metodo de creacion de la apiClient
    static public ApiAdapter getInstance(){
        if(instance==null){
            instance = new ApiAdapter();
        }
        return instance;
    }


    public static ApiService getApiService(){
        return apiService;
    }

}
