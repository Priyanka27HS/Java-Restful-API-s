package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithoutResponseSpec {

    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setUpExpectations()
    {
        responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.time(Matchers.lessThan(5000L));
    }
    @Test
    public void createBooking()
        {

        // Setup Request
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\n" +
                        "    \"firstname\": \"Sam\",\n" +
                        "    \"lastname\": \"Joe\",\n" +
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
                .spec(responseSpecification);

    }
}
