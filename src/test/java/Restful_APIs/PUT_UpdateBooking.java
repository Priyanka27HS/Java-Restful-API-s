package Restful_APIs;

import io.restassured.RestAssured;

public class PUT_UpdateBooking {

    public static void main(String[] args) {

        RestAssured
        .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/1")

                // Setting the Content-Type header to specify JSON format
                .header("Content-Type", "application/json")

                // Setting the Authorization header for authentication
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")

                .body("{\n" +     // Providing the request body in JSON format
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when() // Starting the request action
                    .put() // Making a PUT request
                .then() // Starting the response validation
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200);

    }
}

//This Java program sends a PUT request to update a booking on a RESTful API endpoint.
//It sets up the request using RestAssured library, including specifying the base URI, base path,
//request headers (Content-Type and Authorization), and request body in JSON format.
//The request is then executed using the given(), when(), and then() methods, followed by assertion of the response
//status code to ensure the operation was successful (status code 200).
//Finally, the program logs both the request and response details.