## Seed code - Boilerplate for step 2 - Activity Stream Assignment
### Assignment Step Description
In this Case Study, we will create an Activity Stream Application which accepts Sender's name and Message as input from the front end and displays the same along with the timestamp posting in a reverse chronological order (latest message first). 

Even though functionality-wise and the output of step - 1 and step 2 are same, in step 1:
 1. We created a monolithic application but in this step 2, we will use proper annotations like @Component, @Repository,  @Autowired etc.,  
 2. In this step 2, we should not use "new"  keyword to create an instance.  
 3. Hibernate configuration was in the xml file in step-1.  In Step-2 it is in java.
 4. Hibernate session factory should be created automatically instead of getting it from HibernateUtil.

In this case study, we are defining the beans related to hibernate from inside **ApplicationContextConfig** class only. Hence hibernate-cfg.xml file and HibernateUtil class are no more required in this step.

Here we will have a **Message** class which will be acting as the data model for message table in the database. Please note that this class is annotated with **@Entity annotation** (**The @Entity annotation marks the class as an entity bean, so it must have a no-argument constructor that is visible with an at least protected scope**), 
where Hibernate will scan all the packages for any Java objects annotated with the @Entity annotation. 
If it finds any, then it will begin the process of looking through that particular Java object to recreate it as a table in your database. 

### Problem Statement
In this case study: Activity Stream Step 2 we will create an application that requires us to implement two functionalities. They are as follows:
1. Display the list of existing messages from the database. Each message should contain senderName, message, and timestamp. 
2. The Message which is sent should contain the senderName, message, and timestamp.
    
    Note: For detailed clarity on the class files, kindly go thru the Project Structure

### Expected solution

A form containing two text fields one for Sender Name, other for Message and a submit button, below to this will be a tabular column with the fields Sender Name, Message and Timestamp (This will be published in reverse chronological order). 
When the user enters the Sender name, Message and clicks on submit button, it gets stored in the database and later render in tabular column.

### Following are the broad tasks:
1. Create the application-context for the application. 
2. Extend AbstractAnnotationConfigDispatcherServletInitializer class WebApplicationInitializer.
3. Display the list of existing messages from the database. Each message should contain senderName, message, and timestamp. send a message which should contain the senderName, message, and timestamp.
4. Implement the MessageDAO interface and annotate with @Repository annotation in MessageDAOImpl.

### Steps to be followed:

    Step 1: Clone the boilerplate in a specific folder in your local machine and import the same in your eclipse STS.
    Step 2: Add relevant dependencies in pom.xml file. 
        Note: Read the comments mentioned in pom.xml file for identifying the relevant dependencies.
    Step 3: In ApplicationContextConfig.java add the required annotations, as well as add base packages to scan in @componentScan Annotation. Define the bean for DataSource, SessionFactory and Transaction Manager.
    Step 4: Specify Root config class in WebApplicationInitializer.java file.
    Step 5: In Message.java file (which is considered as Model class), annotate this class with @Entity Annotation and add @Id annotation to specify the primary key for the table.
    Step 6: Read all the methods mentioned in the MessageDAO interface.
    Step 7: Provide the implementation for all the methods of MessageDAO interface in MessageDAOImpl. These classes have to be annotated with @Repository and @Transactional.
    Step 8: Run the JUnit testcases for MessageDAOImpl.java class (MessageDAOTest.java)
    Step 9: Annotate the MessageController.java class with @Controller annotation, also define a handler method to read the existing messages from the database, 
            and to read the senderName and message from requested parameters and save the message in the message table in the database.
    Step 10: Run the MockMVCTest cases for MessageController.java (MessageControllerTest.java)
    Step 11: Design a form with 2 text boxes (one for sender name and other for Message) and a submit button. 
            A table which shows Senders name, Message and the Message posted date.
    Step 12: Run the application on configured web server.

### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
    |
    ├──src/main
	|	    └── com.stackroute.activitystream.config	           
	|   	        └── ApplicationContextConfig.java           // This class will contain the application-context for the application.
	|	            └── WebApplicationInitializer.java          // This class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer class.
	|	    └── com.stackroute.activitystream.controller
	|		        └── MessageController.java 	                    // This class is used to control all the transactions with the database.	               
	|	    └── com.stackroute.activitystream.dao
	|		        └── MessageDAO.java                         // An interface that provides access to an underlying database (Message) or any other persistence storage.
	|	    └── com.stackroute.activitystream.daoimpl
	|		        └── MessageDAOImpl.java                     // This class is implementing the MessageDAO interface. This class has to be annotated with @Repository annotation.
	|	    └── com.stackroute.activitystream.model
	|		        └── Message.java                            // The class will be acting as the data model for the message Table in the database.
	|	    └── webapp/WEB-INF/views
    |               └── index.jsp                               // A JSP page with a form in it, which will have textboxes for Sender Name and Message content along with a Send Submit button. 
    |
    ├──src/test/java/com/stackroute/activitystream/test      // All your test cases are written using JUnit, these test cases can be run by selecting Run As -> JUnit Test
    |           └── MessageControllerTest.java      
    |           └── MessageDAOTest.java             
    ├── .settings
	├── .classpath			                    // This file is generated automatically while creating the project in eclipse
	├── .hobbes   			                    // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
	├── .project			                    // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
	├── pom.xml 			                    // This is a default file generated by maven, if this file is removed your project will not get recognised in hobbes.
	└── PROBLEM.md  		                    // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however if need to be customizing, you should copy from this repo and modify in your project repo


#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in the folder **assignment-solution-step2** of your local machine
     
    `git clone https://gitlab-dev.stackroute.in/activity-stream-java/step2-boilerplate.git assignment-solution-step2`

2. Navigate to assignment-solution-step2 folder

    `cd assignment-solution-step2`

3. Remove its remote or original reference

     `git remote rm origin`

4. Create a new repo in gitlab named `assignment-solution-step2` as private repo

5. Add your new repository reference as remote

     `git remote add origin https://gitlab-wd.stackroute.in/{{yourusername}}/assignment-solution-step2.git`

     **Note: {{yourusername}} should be replaced by your username from gitlab**

5. Check the status of your repo 
     
     `git status`

6. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

     `git add .`
 
7. Commit and Push the project to git

     `git commit -a -m "Initial commit | or place your comments according to your need"`

     `git push -u origin master`

8. Check on the git repo online, if the files have been pushed

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> Run on Server to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.