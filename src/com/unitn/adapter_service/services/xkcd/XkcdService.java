package com.unitn.adapter_service.services.xkcd;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by demiurgo on 2/6/16.
 */
public interface XkcdService {

    @GET("{id}/info.0.json")
    Call<XkcdComic> getComic(@Path("id") long comicID);
}
