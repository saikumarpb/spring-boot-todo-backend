### ToDO Application Backend
#### Tech stack : SpringBoot, Kotlin, Gradle and Postgres

To run this application, follow the below steps

1. clone the frontend git repository from https://github.com/saikumarpb/todo-react

2. clone the backend git repository from https://github.com/saikumarpb/spring-boot-todo-backend

3. Instructions to setup frontend repository are mentioned in the [Readme.md](https://github.com/saikumarpb/todo-react#readme) file in the frontend repository. Follow the instructions and complete the frontend setup successfully.

4. The configuration file for this application is located at `src\main\resources\application.properties`

5. This application uses `postgres` as database. if you have an existing postgres service available update database configuration such as _database url, port, databse name, username, password_ in **DATABASE PROPERTIES** section of the `application.properties` file and proceed from step 7.

6. if existing `postgres` service is not available, (assuming docker/docker desktop is available in your machine) open terminal project folder and execute `docker-compose up -d` command.

7. once the postgres service is up and running. next step is to create a database with a name. in this project the database name is `test`. if running postgres on docker execute the container either through docker desktop or from terminal (assuming terminal is linux or git bash) with  `docker exec -it postgres bash` > `su postgres` > `psql` > `CREATE DATABASE test;`

8. After creating a databse and configuring it properly in application.properties. (Assuming code editor is `intellij`) 

    1. this project uses java 11 . use a java 11 sdk from File > Project structure > Project > Project SDK > select a version 11 SDK.
    2. choose a proper jvm under File > Settings > Build, Execution and Deployment > Build Tools > Gradle > Gradle JVM to be version 11.

9. Load/Reload the gradle project and complete the build.

10. Once the build, indexing is completed. now setup the run configuration Run/Debug Configuration menu > Edit Configurations > Add new configuration > Gradle > select spring-boot-todo-backend > Run > select bootRun > Click on Ok.

11. Now setup is completed. run the application. Tomcat should start on port specified in application.properties file (Port: 8000). backend is available at http://localhost:8000 

12. Add the backend url in frontend application to connect to backend and run the frontend application.

#### Available API's
1. Get Todolist API 
<pre>
Request : curl --location --request GET 'http://localhost:8000/todolist/'`
Response : 
{
    "pending": [
        {
            "id": 1,
            "text": "test task desciption"
        }
    ],
    "completed": [
        {
            "id": 2,
            "text": "completed task desciption"
        }
    ]
}
</pre>

2. Post Task API (create/update a task/todo)
<pre>
curl --location --request POST 'http://localhost:8000/todolist/post' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "id": 1,
   "text": "test task desciption",
   "isPending": true
   }'`
</pre>

3. Delete task API
<pre>
curl --location --request DELETE 'http://localhost:8000/todolist/delete/1'
</pre>

#### Database
- Todo is a very basic and simple CRUD application with add,edit,delete functionality.
- DB contains a single table `todo`
<pre>
                         Table "public.todo"
   Column   |          Type          | Collation | Nullable | Default
------------+------------------------+-----------+----------+---------
 id         | bigint                 |           | not null |
 is_pending | boolean                |           | not null |
 text       | character varying(255) |           |          |
Indexes:
    "todo_pkey" PRIMARY KEY, btree (id)
</pre>