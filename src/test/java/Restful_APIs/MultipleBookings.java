package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleBookings {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setupRequestSpec()
    {
        requestSpecification = RestAssured.given();
        requestSpecification
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON); // enum constant value
    }

    @Test
    public void createBooking1() {

        RestAssured
                .given()
                .spec(requestSpecification)

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

                // Hit the request and get response, response is a interface here
                .post()

                // Validate the response
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    @Test
    public void updateBooking()
    {
        RestAssured
                .given()
                .spec(requestSpecification)

                // Setting the Content-Type header to specify JSON format
//                .header("Content-Type", "application/json")

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
