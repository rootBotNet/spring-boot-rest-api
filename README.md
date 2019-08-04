# spring-boot-rest-api

This is a RESTful webservice which uses spring boot, maven, h2 embedded database and swagger.

#Running the programme
This guide assumes that you already have java 8 or later- and maven installed.
  1.Clone or download the repository.
   URI to clone: https://github.com/rootBotNet/spring-boot-rest-api.git
   
  2.Open the project in your ide(Intelli J was used to create this project.).
  3.Run the following commands from the maven projects pane if using Intelli J:
    a)clean install -U
    b)spring-boot:run
    
    The project will create 4 URL's
      1)Embedded h2 database URL:
          http://localhost:8086/api/console
          Login credentials: 
            user name: admin
            password: p@55w0rd
          Ensure the the JDBC URL in the console view is set to: jdbc:h2:mem:testdb
          Here you can access the embedded h2 database.
          
      2)JSON code:
          http://localhost:8086/api/v2/api-docs
          Here you will see the json file created by swagger from the @RestController PersonDetailsController.
          This file can be converted to a yaml file using the web swagger editor.
          The yaml file can then be consumed by any othe project to generate the java code api to make call to the service end points.
          I have placed a generated yaml file for this project in the resources directory.
        
      3)Documentation generated by swagger:
          http://localhost:8086/api/swagger-ui.html
          Login credentials: 
            user name: admin
            password: p@55w0rd
          Here you will be able to view a web ui document representing the RESTful service.
          
      4)Service endpoints:
          Base path: http://localhost:8086/api
          This is the base path from where the RESTful Service can be accessed.
          The PersonDetailsController for the RESTful Service has a request mapping of /v1. So in order to access this
          controllers methods, you will have to append the http://localhost:8086/api path with /v1 before accessing the method.
          
          Web security:
            There are two users allowed to access these endpoints:
            Admin user: Can access all the endpoints.
              Username: admin
              Password: p@55w0rd

            Guest user: Can only access the find by id and find all endpoints.
              Username: guest
              Password: p@55w0rd1
          
          Retrive all persons:
            http://localhost:8086/api/v1/person
            
          Retrieve person by id:
            http://localhost:8086/api/v1/person/{id} 
            Remove the curly braces and replace the variable id with the id you want to find details for.
            
          Add a new person to the database:
            http://localhost:8086/api/v1/person/{name}/{age}
            Remove the curly braces and replace the variable name with the name and the variable age with the age you  want to add.
          
