# adapter_service
This Adapter Service provides a REST interface to link an application to these four differents API:

[Random quotes](https://market.mashape.com/andruxnet/random-famous-quotes)  - [TodoLy](http://todo.ly/apiwiki/) - [Xkcd webcomic](http://xkcd.com/json.html) -
[GoogleCharts API](https://developers.google.com/chart/)

All these endpoints method expects JSON as input and give JSON as output.
## Endpoints

##### TodoLy API
    @POST("adapter_service/todo")
    Call<Project> createProject(@Body Project project);

Creates a new project on TodoLy.

---

    @GET("adapter_service/todo/{id}")
    Call<List<Task>> getTaskList(@Path("id") long projectId);

Returns the list of active tasks in the specified project.

    @GET("adapter_service/todo/done/{id}")
    Call<List<Task>> getDoneTaskList(@Path("id") long projectId);

Returns the list of completed tasks in the specified project.

    @POST("adapter_service/todo/task")
    Call<Task> createTask(@Body Task task);

Creates a new task.

    @PUT("adapter_service/todo")
    Call<Task> updateTask(@Body Task task);

Updates a task.

##### Xkcd API
    @GET("adapter_service/xkcd/random")
    Call<XkcdComic> randomComic();

Returns a random comic from [xkcd.com](https://xkcd.com)


##### Quotes API

    @GET("adapter_service/quotes/famous")
    Call<Quote> famousQuote();

Returns a random famous quote.

    @GET("adapter_service/quotes/movie")
    Call<Quote> movieQuote();

Returns a random movie quote.

##### GoogleChart API
    @POST("adapter_service/chart")
    Call<Chart> getChart(@Body List<Integer> data);

Returns the image url for the chart
generated from the given data.
