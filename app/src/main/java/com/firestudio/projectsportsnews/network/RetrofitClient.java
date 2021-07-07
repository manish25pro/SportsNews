package com.firestudio.projectsportsnews.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//SingleTon class for retrofit object
public class RetrofitClient {

    private RetrofitClient() {

    }

    public static Retrofit retrofit = null;
public  static String BASEURL ="https://newsapi.org/v2/";
    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }


}
