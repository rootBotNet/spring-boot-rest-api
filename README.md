# spring-boot-rest-api

This is a RESTful webservice which uses spring boot, maven, h2 embedded database and swagger.

#Running the programme
This guide assumes that you already have java 8 or later- and maven installed.
  1.Clone or download the repository.
  2.Open the project in your ide(Intelli J was used to create this project.).
  3.Run the following commands from the maven projects pane if using Intelli J:
    a)clean install -U
    b)spring-boot:run
    
    The project will create 4 URL's
      1)http://localhost:8086/api/console
        Here you can access the embedded h2 database.
      2)http://localhost:8086/api/v2/api-docs
        Here you will see the json file created by swagger from the @RestController UserManagementController.
        This file can be converted to a yaml file using the web swagger editor.
        The yaml file which has been generated will be used to create an external jar (ext-service-swagger-rest-api) project which can be
        consumed by any front end as an api to access the RESTFul Service.
      3)http://localhost:8086/api/swagger-ui.html
        Here you will be able to view a web ui document representing the RESTful service.
      4)http://localhost:8086/api
        This is the base path from where the RESTful Service can be accessed.
        The UserManagementController for the RESTful Service has a request mapping of /usermanagement. So in order to access this
        controllers methods, you will have to append the http://localhost:8086/api path with /usermanagement before accessing the method.
        The client will handle this for us, but this needs to be kept in mind when using SOAP or any other Interface for service testing.
