!!!!!!!!!!!!Project Report!!!!!!!!!!!!

This is a maven project, You can make save person, update person, delete person and if you want you can get all list of person or just get one person with id.


!!!!!!!!!!Technologies used !!!!!!!!!!

The project was developed in eclipce or intellij idea, because maven project.

Maven was used for this project.

It was used as the programming language, java 1.8.

the database was used as mongodb.

the web service was used as restful web services.

the framework was used as Spring MVC.

It was used as a jetty application server.


!!!!!!!!!!Embedded Jetty server, for testing!!!!!!!!!!

In this tutorial, we will show you a Spring MVC form handling project to do the following stuff :

1.Form value binding – JSP and Model.

2.Form validation and display error message.

3.Form POST/REDIRECT/GET pattern, and add messages to flash attribute.

4.CRUD operations, add, get, update and delete with an HTML form.


Logging : slf4j

Download the project and type mvn jetty:run

List all users. http://localhost:8080/spring-mvc-form/users

The URI structure :



URI	Method	Action

/users	            GET	    Listing, display all users

/users	            POST	Save or update user

/users/{id}	        GET	    Display user {id}

/users/add	        GET	    Display add user form

/users/{id}/update	GET	    Display update user form for {id}

/users/{id}/delete	POST	Delete user {id}


MongoDB JSON model:

Kullanicilar:

    {
        "name":"",
        "surname":"",
        "captcha":"",
        "numbers":""
    }