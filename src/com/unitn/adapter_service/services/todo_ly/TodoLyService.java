package com.unitn.adapter_service.services.todo_ly;

import com.unitn.adapter_service.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Created by demiurgo on 1/31/16.
 */
public interface TodoLyService {

    static TodoLyService getService() {
        return new ServiceGenerator("https://todo.ly").createService(TodoLyService.class, System.getenv("TODOLY_AUTH"));
    }

    @GET("api/items.json")
    Call<List<Task>> taskList();


}
