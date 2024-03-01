package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBooking {

    public static void main(String[] args) {

        // Construct request
        RestAssured
            .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{bookingID}")
                .pathParam("bookingID", "5") // keep changing the ID
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")

        // Hit request
            .when()
                .delete()  // Making a DELETE request

        // Validate the response
            .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

    }
}

//This Java program sends a DELETE request to delete a booking on a RESTful API endpoint.
//It sets up the request using RestAssured library, including specifying the base URI, base path,
//path parameter (bookingID), request headers (Content-Type and Authorization).
//The request is then executed using the given() and when() methods to construct the request and hit the endpoint,
//respectively. Finally, the response is validated using the then() method, and the status code is asserted
//to ensure the operation was successful (status code 201).
//The program also logs both the request and response details.
