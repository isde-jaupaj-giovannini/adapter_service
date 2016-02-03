package com.unitn.adapter_service.services.quotes;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by erinda on 1/31/16.
 */
public interface QuotesService {


    @Headers({
            "X-Mashape-Key : FuPi3q56U4mshaZJjiE6ucUEa7TAp1ki9PijsnX0RiklcDlJs8",
            "Content-Type : application/json",
            "Accept : application/json"
    })
    @POST("/?cat=movies")
    Call<Quotes> getQuoteFromMovies();

    @Headers({
            "X-Mashape-Key : FuPi3q56U4mshaZJjiE6ucUEa7TAp1ki9PijsnX0RiklcDlJs8",
            "Content-Type : application/json",
            "Accept : application/json"
    })
    @POST("/?cat=famous")
    Call<Quotes> getQuoteFromFamous();



}
