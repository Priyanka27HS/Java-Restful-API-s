package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType; // Importing the ContentType enum for specifying content type

public class Partial_UpdateBooking {

    public static void main(String[] args) {

        RestAssured
           .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/1")
                .body("{\n" +
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Bond\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
           .when()
                .patch()   // Making a PATCH request (partial update)
           .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }
}


//This Java program sends a PATCH request to partially update a booking on a RESTful API endpoint.
//It sets up the request using RestAssured library, including specifying the base URI, base path, request body in JSON format
//(with only the fields to be updated), content type as JSON, and Authorization header for authentication.
//The request is then executed using the given(), when(), and then() methods, followed by assertion of the
//response status code to ensure the operation was successful (status code 200)
//Finally, the program logs both the request and response details.
