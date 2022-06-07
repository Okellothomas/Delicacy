package com.pro.delicacy.network;

import com.pro.delicacy.Credentials;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DelicacyClient {

    private static Retrofit retrofit = null;

    public static DelicacyAPi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .client(myHttp())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(DelicacyAPi.class);
    }

    private static Interceptor logininterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient myHttp() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(logininterceptor())
                .build();
    }
}
