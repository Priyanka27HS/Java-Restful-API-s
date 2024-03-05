package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

// Purpose -> Once we hit the API, whatever response we're getting that response we need to extract as a String

public class ExtractResponseAsString {

    public static void main(String[] args) {

        // Sending a POST request and extracting the response as a String using RestAssured
        String responseBody =   // Declaring a String variable to store the response body
        RestAssured
                .given()
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
                .post()
                .then()
                .extract()   // Extracting part of the response
                .asPrettyString();  // Prints in JSON format

        System.out.println("Response Body is :" + responseBody);
    }
}

//This Java program sends a POST request to create a booking on a RESTful API endpoint using RestAssured library.
//It sets up the request including specifying the base URI, base path, request body in JSON format, and content type header.
//The request is executed using the given() method, and then() method is used to start the response validation.
//The response body is then extracted using extract() method and converted to a pretty-printed string in JSON format
//using asPrettyString() method.Finally, the extracted response body is printed to the console.
