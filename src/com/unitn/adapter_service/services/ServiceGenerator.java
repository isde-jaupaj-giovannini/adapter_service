package com.unitn.adapter_service.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by demiurgo on 1/31/16.
 */
public class ServiceGenerator {

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit.Builder builder;

    public ServiceGenerator(String API_BASE_URL) {
        builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }

    public <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public <S> S createService(Class<S> serviceClass, String AUTH) {
        if (AUTH != null ) {
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", AUTH)
                        .header("Accept", "applicaton/json")
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(serviceClass);
    }
}