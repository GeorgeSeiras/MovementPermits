Github Repository : [GitHub - GeorgeSeiras/MovementPermits](https://github.com/GeorgeSeiras/MovementPermits)

# Installation Guide

## Intranet

    This application requires java 11 and a MySql databse.

1. Create the database:
   
   The databse should be running on port 3306.
   
   Run the db.sql script to create the database.

2. Run the initialization dbInit.sql script.
   
   This script creates a department with the name ADMIN, a user named Adam Smith with the username: admin and password:password assigned to the ADMIN department, the 4 Roles ADMIN,SUPERVISOR,HR,DIRECTOR and finally assigns the ROLE_ADMIN to the created user.

3.  Create a file called application.properties on the path :   
   
   > - MovementPermits\intranet\src\main\resources
   
   application.properties example:
   
   ```
   info.app.name=Movement Permits
   
   server.port = 8080
   
   spring.datasource.url=jdbc:mysql://localhost:3306/ds?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   spring.datasource.username=george
   spring.datasource.password=password
   
   management.endpoints.web.exposure.include=*
   
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
   
   spring.datasource.initialization-mode=always
   spring.jpa.hibernate.ddl-auto=none
   
   secret='AmazinglyVerySpecialDifficultForbiddenSecret'
   ```
   
   You can modify the server.port, the spring.datasource.url/username/password and the secret, to the desired port and database.
   
   Run the group15_intranet.jar file under the intranet folder.

4. ```
   java -jar group15_intranet.jar
   ```
   
   This will run the application on localhost, at the port 8080.

5. Connect at localhost:8080.



## Internet

This application requires Node.js and npm to run
