1.  A Spring Boot application to manage employees, projects, their assignments and reporting.  
    This system provides REST APIs and simple frontend integration (AJAX + Bootstrap) to handle employee and project data efficiently.

2.  Backend: Java 17+, Spring Boot, Spring Data JPA  
    -  Database: MySQL  
    -  Frontend: HTML, CSS, Bootstrap 5, AJAX  
    -  Build Tool: Maven

3.  Clone the repository

    git clone https://github.com/Vishal3546/Employee-Project-Management-System-API.git

4. Employee&ProjectManagementSystem import in eclipse by following Step
   go to File and click on Import and click on Existing Maven Project then after select location for project and select and finish.
    
5. Configure Database

   Create a MySQL database (e.g., employeeDb)
   Update application.properties with your DB credentials:
  
   spring.datasource.url=jdbc:mysql://localhost:3306/employeeDb
   spring.datasource.username=vishal
   spring.datasource.password=123456
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   MySql Database uploaded in Employee&ProjectManagementSystemAPI.

6. Run the project
