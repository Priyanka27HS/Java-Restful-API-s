package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

// Both RequestSpecification and ResponseSpecification are used in the same API
public class CreateBookingWithRequestResponseSpec {

    public static void main(String[] args) {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON); // enum constant value

        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.time(Matchers.lessThan(5000L));

        RestAssured
                .given(requestSpecification)

                // Request part use here in given method and save 1 line of code since given method is overloaded
                //  spec(requestSpecification)
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
                .then()   // then method is not over loaded
                .log()
                .all()
                .spec(responseSpecification);

    }
}