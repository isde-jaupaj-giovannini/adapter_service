package com.unitn.adapter_service.services;

import com.unitn.adapter_service.services.quotes.QuotesService;
import com.unitn.adapter_service.services.todo_ly.TodoLyService;
import com.unitn.adapter_service.services.xkcd.XkcdService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;

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

    public <S> S createService(Class<S> serviceClass, final String AUTH) {
        if (AUTH != null ) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", AUTH)
                            .header("Accept", "applicaton/json")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(serviceClass);
    }



    public static QuotesService getQuoteService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://andruxnet-random-famous-quotes.p.mashape.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(QuotesService.class);
    }

    public static TodoLyService getTodoLyService() {
        return new ServiceGenerator("https://todo.ly").createService(TodoLyService.class, System.getenv("TODOLY_AUTH"));
    }

    public static XkcdService getXkcdService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://xkcd.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(XkcdService.class);
    }
}