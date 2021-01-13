Github Repository : [GitHub - GeorgeSeiras/MovementPermits](https://github.com/GeorgeSeiras/MovementPermits)

# Installation Guide

## Intranet

    This application requires java 11 and a MySql databse.

1. Create the database:
   
   The databse should be running on port 3306.
   
   Run the db.sql script to create the database.

2. Run the initialization dbInit.sql script.
   
   This script creates a department with the name ADMIN, a user named Adam Smith with the username: admin and password:password assigned to the ADMIN department, the 4 Roles ADMIN,SUPERVISOR,HR,DIRECTOR and finally assigns the ROLE_ADMIN to the created user.

3. Run the group15_intranet.jar file under the intranet folder.
   
   ```
   java -jar group15_intranet.jar
   ```
   
   This will run the application on localhost, at the port 8080.

4. Connect at localhost:8080.
