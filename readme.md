This is a Spring Boot Web application with Spring Kafka to demonstrate publishing message in JSON format to Kafka

Requirement: 
- JDK 11
- Kafka (tested with version 3)
- Maven

Optional:
- IDE like VS Code (WIth Spring Boot Extension)

To run the code checkout Exercise folder
1. Ensure the following properties in `application.properties` file (in resource folder) is updated to the correct Kafka server address, port, and SSL configuration.
				
		
2. Run the following command, in the Exercise folder: 
				`mvn spring-boot:run`

Another option, is by opening the Exercise project folder in VS Code with spring boot extension, and launch the spring boot application from there.

Upon sucessful startup the application will listen for request on port 8080 (Tomcat Default Port)

The application will publish message to kafka when the following URL http://localhost:8080/exercise/publish receive a HTTP GET request. 
This is handled by Spring REST Controller on ExerciseRestController class.

Example command to trigger the GET request:
	`curl "http://localhost:8080/exercise/publish?symbol=AMZN&buy=1000&sell=1100"`



