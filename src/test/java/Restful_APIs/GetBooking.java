package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBooking {

    public static void main(String[] args) {

        // Build Request
//        RequestSpecification requestSpecification = RestAssured.given().log().all();
//        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
//        requestSpecification.basePath("booking/{id}");
//
//        requestSpecification.pathParam("id", 82);

        // Hit the request and get response
//        Response response = requestSpecification.get();

        // Validate the response
//        ValidatableResponse validatableResponse = response.then().log().body();
//        System.out.println(validatableResponse);

        // Build Request
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}")
                .pathParam("id", 82)

                // Hit the request and get response
            .when()
                .get()

                // Validate the response
            .then()
                .log()
                .all()
                .statusCode(200);

    }
}
