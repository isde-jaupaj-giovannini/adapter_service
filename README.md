# adapter_service
This Adapter Service provides a REST interface to link an application to these four differents API:

[Random quotes](https://market.mashape.com/andruxnet/random-famous-quotes)  - [TodoLy](http://todo.ly/apiwiki/) - [Xkcd webcomic](http://xkcd.com/json.html) -
[GoogleCharts API](https://developers.google.com/chart/)

All these endpoints method expects JSON as input and give JSON as output.
## Endpoints
Base url: https://nameless-basin-58575.herokuapp.com/adapter_service/
### TodoLy API

#### POST todo

    @POST("adapter_service/todo")
    Call<Project> createProject(@Body Project project);

Creates a new project on TodoLy.

**Example of input:**

    {
      "Id": 3501606,
      "Content": "Project title",
    }

**Example of output:**

    {
      "Id": 3501606,
      "Content": "Project title",
      "ItemsCount": 0,
      "ItemType": 2,
      "ParentId": null,
      "Children": []
    }


---

#### GET todo/{id}

    @GET("adapter_service/todo/{id}")
    Call<List<Task>> getTaskList(@Path("id") long projectId);

Returns the list of active tasks in the specified project.

**Example of output:**

    [{
        "Id":9332194,
        "Content":"Name of the Task",
        "ItemType":1,
        "Checked":false,
        "ProjectId":3501561,
        "ParentId":null,
        "Path":"",
        "DateString":null,
        "DateStringPriority":0,
        "DueDate":"",
        "Priority":4,
        "Children":[],
        "CreatedDate":"/Date(1454933891050)/",
        "Deleted":false,
        "DueTimeSpecified":true
    }]
---

#### GET todo/done/{id}

    @GET("adapter_service/todo/done/{id}")
    Call<List<Task>> getDoneTaskList(@Path("id") long projectId);

Returns the list of completed tasks in the specified project.

**Example of output:**

    [{
        "Id":9332194,
        "Content":"Name of the completed Task",
        "ItemType":1,
        "Checked":false,
        "ProjectId":3501561,
        "ParentId":null,
        "Path":"",
        "DateString":null,
        "DateStringPriority":0,
        "DueDate":"",
        "Priority":4,
        "Children":[],
        "CreatedDate":"/Date(1454933891050)/",
        "Deleted":false,
        "DueTimeSpecified":true
    }]
---
#### POST todo/task

    @POST("adapter_service/todo/task")
    Call<Task> createTask(@Body Task task);

Creates a new task.

**Examples of input:**

    {
        "ProjectId": 1234,
        "Content": "Task Title",
        "DueDate": "02/01/2016 12:32"
    }

**Examples of output:**

    {
      "Id": 9332237,
      "Content": "Task Title",
      "ItemType": 1,
      "Checked": false,
      "ProjectId": 1234,
      "ParentId": null,
      "Path": "",
      "DateString": "7 days overdue",
      "DateStringPriority": 1,
      "DueDate": "1 Feb 12:32 PM",
      "Priority": 4,
      "Children": [],
      "CreatedDate": "/Date(1454935909570)/",
      "Deleted": false,
      "DueTimeSpecified": true
    }

---

#### PUT todo

    @PUT("adapter_service/todo")
    Call<Task> updateTask(@Body Task task);

Updates a task.

**Example of input:**

    {
      "Id": 9332237,
      "Content": "New Task title",
      "Checked": true
    }

**Example of output:**

    {
      "Id": 9332237,
      "Content": "New Task title",
      "ItemType": 1,
      "Checked": true,
      "ProjectId": null,
      "ParentId": null,
      "Path": "",
      "DateString": "7 days overdue",
      "DateStringPriority": 1,
      "DueDate": "1 Feb 12:32 PM",
      "Priority": 4,
      "Children": [],
      "CreatedDate": "/Date(1454935909570)/",
      "Deleted": false,
      "DueTimeSpecified": true
    }

---

### Xkcd API

#### GET xkcd/random

    @GET("adapter_service/xkcd/random")
    Call<XkcdComic> randomComic();

Returns a random comic from [xkcd.com](https://xkcd.com)

**Example of output:**

    {
        "title":"Trebuchet",
        "img":"http://imgs.xkcd.com/comics/trebuchet.png",
        "alt":"It was also fun when those teenagers tried to egg our house and it insta-cooked the eggs in mid-air.",
        "year":"2008",
        "month":"2",
        "day":"11"
    }
---

### Quotes API

#### GET quotes/famous

    @GET("adapter_service/quotes/famous")
    Call<Quote> famousQuote();

Returns a random famous quote.

**Example of output:**

    {
        "quote":"Black holes are where God divided by zero.",
        "author":"Steven Wright",
        "category":"Famous"
    }
----

#### GET quotes/movie

    @GET("adapter_service/quotes/movie")
    Call<Quote> movieQuote();

Returns a random movie quote.

**Example of output:**

    {
        "quote":"Mrs. Robinson, you're trying to seduce me. Aren't you?",
        "author":"The Graduate",
        "category":"Movies"  
    }
----

### GoogleChart API

#### POST chart

    @POST("adapter_service/chart")
    Call<Chart> getChart(@Body List<Integer> data);

Returns the image url for the chart
generated from the given data.

**Example of input:**

    [123,432,231]

**Example of output:**

    {
      "url": "http://chart.apis.google.com/chart?cht=r&chs=200x200&chd=t:28,100,53&chco=FF0000,FF9900&chls=2.0,4.0,0.0|2.0,4.0,0.0&chxt=x&chxl=0:|123|432|231&chxr=0,0.0,360.0"
    }
