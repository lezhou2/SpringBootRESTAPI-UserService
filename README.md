# A Spring Boot RESTful Web Service to manage user records

## The `userservice`, provides REST end-point for managing user records. This app is to demonstate how to generate API codes(Controller, Service, Model object) from API Spec, use Mapstruct to map JPA entities to API Model and also use H2 in-memory database.

### Dependencies

* Java 11 (Java SDK 1.11).
*  Maven 3.3.8 or later.


### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program
Open a terminal and navigate to the home directory of this app.

* Open a terminal and navigate to the home directory of this app.
* Build application
```
 mvn spring-boot:run
    or
java -jar target/userservice-0.0.1-SNAPSHOT.jar
```
*  Connect Database
```
    http://localhost:8080/h2-console/
    JDBC URL:   jdbc:h2:mem:testdb
    User Name:  sa
    Password:   password
```
* Create a user using 
    ```
     POST http://localhost:8080/api/user 
     {
        
        "userName":"john_user",
        "emailAddress":"j@example.com",
        "preferredPhoneNumber":"+353881234567"
    }
   
   ```
* Get Users using
 
   ```
   GET http://localhost:8080/api/users
   
   ```

* Delete a user using

  ```
   DELETE http://localhost:8080/api/user/93f3ed0a-92bd-4c82-ba0e-c098111cef59
   
   ```
