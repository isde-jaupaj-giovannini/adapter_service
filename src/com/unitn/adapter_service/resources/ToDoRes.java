package com.unitn.adapter_service.resources;

import com.unitn.adapter_service.services.ServiceGenerator;
import com.unitn.adapter_service.services.todo_ly.Project;
import com.unitn.adapter_service.services.todo_ly.Task;
import com.unitn.adapter_service.services.todo_ly.TodoLyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by demiurgo on 11/9/15.
 */

@Path("/todo")
public class ToDoRes {

    TodoLyService todoLyService = ServiceGenerator.getTodoLyService();

    /**
     * Request #9: GET /measureTypes
     * should return the list of measures your model supports
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_JSON })
    public Project createProject(Project project) {
        Project res = null;
        try {
            res = todoLyService.createProject(project).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }


    @POST
    @Path("/task")
    @Consumes({MediaType.APPLICATION_JSON })
    @Produces({MediaType.APPLICATION_JSON })
    public Task createTask(Task task){
        Task t = null;
        try {
            t = todoLyService.createTask(task).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    @GET
    @Path("{projectId}")
    @Produces({MediaType.APPLICATION_JSON })
    public List<Task> getTaskList(@PathParam("projectId") long projectId){
        List<Task> ls = null;
        try {
            ls = todoLyService.getProjectTasks(projectId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @GET
    @Path("done/{projectId}")
    @Produces({MediaType.APPLICATION_JSON })
    public List<Task> getDoneTaskList(@PathParam("projectId") long projectId){
        List<Task> ls = null;
        try {
            ls = todoLyService.getProjectDoneTasks(projectId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ls;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON })
    public Task updateTask(Task task){
        try {
            return todoLyService.updateTask(task.getId(), task).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
