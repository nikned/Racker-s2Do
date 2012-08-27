# TO-DO RestFul Application #

The To-DO application is documented [here].

This application provides an example of Building a complete 
RESTful API in Java using JAX-RS and Jersey.
Consuming these services using jQuery

Set Up:

1. Import the Dynamic Web Project in Eclipse.

#Test the Application#

Set the Run Properties:
    a. Right-click the project node and select Run As.
    b. In the dialog, select the Run on server
    c. This step deploys the application in  the Apache Tomcat server and brings up a Index.html in the browser.
	
Steps to Create Task	
    a. When the page appears, In the left panel, we can see the added To-Do taks (Intinitially it's blank , until add the new tasks).
    b. In the right panel, we can add any New tasks by entering the information in the fields and click save.
    c. We can see the newly added Taks in the left panel. 
    d. To update any tasks or delete, select the task In the left panel the task detials will be populate on the right side panel.

To see the webservice representation , need to click on "View All tasks XML Response"

About Project
--------------

Packages:
com.racker.todo.beans
	1.com.racker.todo.beans.Task 
	2.com.racker.todo.beans.TasksList 
		Entity providers supply mapping services between representations and their associated Java types. 
		The two types of entity providers are Task and TasksList. 
		For HTTP requests, the Task is used to map an HTTP request entity body to method parameters. 
		On the response side, a return value is mapped to an HTTP response entity body by using a TasksList.
	
com.racker.todo.resources
	1.com.racker.todo.resources.TaskResource -- Root resource classes are POJOs that are annotated with @Path and 
						have methods are  annotated with @Path or a request method designator, such as @GET, @PUT, @POST, or @DELETE. 
	    	a. To create a To-Do task in the xml using @POST annotation.
		b. To retrieve a task using @GET annotation.
		c. To change the state of a any task or to update it using @PUT annotation.
		d. To remove or delete a task using @DELETE annotation.
		
	2.com.racker.todo.resources.TasksResource
		a. Java class will be hosted at the URI path " /tasks ".
		b. The @GET annotation is a request method designator, along with @POST, @PUT, and @DELETE
		   defined by JAX-RS and corresponding to the similarly named HTTP methods.
		c. The @Produces annotation is used to specify the MIME media types a resource can produce and send back to the client. 
		   The Java method will produce representations identified by the MIME media type "MediaType.TEXT_PLAIN".
		d. The @Consumes annotation is used to specify the MIME media types a resource can consume that were sent by the client

com.racker.todo.task.storage
	1. com.racker.todo.task.storage.TaskStore
		Adds the task information to Map and used mehtod getStore() to fetch the added tasks.
	
com.racker.todo.util
	1.com.racker.todo.util.JAXBUtil - Used as singleton
	2.com.racker.todo.util.ParamUtil - Used to parse the xml by spliting the xml and retun tasks Map with key value pairs.