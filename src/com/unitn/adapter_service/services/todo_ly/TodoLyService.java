package com.unitn.adapter_service.services.todo_ly;

import com.unitn.adapter_service.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by demiurgo on 1/31/16.
 */
public interface TodoLyService {



    // PROJECTS API

    @POST("api/projects.json")
    Call<Project> createProject(@Body Project project);

    @GET("api/projects/{id}.json")
    Call<Project> getProjectByID(@Path("id") long projectID);

    @GET("api/projects/{id}/items.json")
    Call<List<Task>> getProjectTasks(@Path("id") long projectID);

    @GET("api/projects/{id}/doneitems.json")
    Call<List<Task>> getProjectDoneTasks(@Path("id") long projectID);


    // TASKS API

    @POST("api/items.json")
    Call<Task> createTask(@Body Task task);

    @PUT("api/items/{id}.json")
    Call<Task> updateTask(@Path("id") long taskID, @Body Task task);

}
