package Restful_APIs;

import io.restassured.RestAssured;

// HashMap class for storing path parameters
import java.util.HashMap;

// Map interface for storing path parameters
import java.util.Map;

public class PathParamsExample2 {

    public static void main(String[] args) {

        // Creating a HashMap to store path parameters
        Map<String, Object> pathParameters = new HashMap<>();

        // Adding base path parameter "basePath" with value "booking"
        pathParameters.put("basePath", "booking");

        // Adding booking ID parameter "bookingId" with value 2
        pathParameters.put("bookingId", 2);

        // Using RestAssured to make an HTTP request
        RestAssured
                .given() // Starting the request specification
                .log() // Logging the request details
                .all() // Logging all  request details
                .baseUri("https://restful-booker.herokuapp.com/") // Setting the base URI for the request
                .basePath("{basePath}/{bookingId}") // Setting the base path with placeholders for path parameters
                .pathParams(pathParameters) // Setting the path parameters using the HashMap
                .when() // Starting the request action
                .get() // Making a GET request
          // OR .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}", 2,  "booking")
                .then() // Starting the response validation
                .log() // Logging the response details
                .all(); // Logging all response details
    }
}


//This Java program uses RestAssured library to make an HTTP GET request to a RESTful API endpoint.
//It sets up a base URI and a base path with placeholders for path parameters.
//Path parameters are provided using a HashMap, and the request is executed using the
//given(), when(), and then() methods to set up the request specification, perform the request,
//and validate the response, respectively. Finally, the program logs both the request and response details.
