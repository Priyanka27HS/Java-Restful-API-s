package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

// POST request in rest assured
// Method chaining is used here using .
public class CreateBooking {

    public static void main(String[] args) {

        // Build Request -> in the empty request (requestSpecification) we pass the 4 details below

        // Setup Request
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\n" +
                "    \"firstname\": \"Josh\",\n" +
                "    \"lastname\": \"Allen\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"super bowls\"\n" +
                "}")
                .contentType(ContentType.JSON) // enum constant value

                // Hit the request and get response, response is a interface here
                .post()

                // Validate the response
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}