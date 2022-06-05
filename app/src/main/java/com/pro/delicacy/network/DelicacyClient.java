package com.pro.delicacy.network;

import com.pro.delicacy.Credentials;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DelicacyClient {

    private static Retrofit retrofit = null;

    public static DelicacyAPi getClient() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(DelicacyAPi.class);
    }
}


//        if (retrofit == null) {
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request newRequest  = chain.request().newBuilder()
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .build();
//
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Credentials.BASE_URL)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
