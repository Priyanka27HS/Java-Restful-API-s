package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

public class MeasureResponseTime {

    public static void main(String[] args) {

        Response response = RestAssured
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
                .post();

//                // Validatable response
//                .then();

                long responseTimeInMS = response.time();
                System.out.println("Response Time in MS :" + responseTimeInMS);

                long responseTimeInSeconds = response.timeIn(TimeUnit.SECONDS);
                System.out.println("Response Time in Seconds :" + responseTimeInSeconds);

                long responseTimeInMS1 = response.getTime();
                System.out.println("Response Time in MS 1:" + responseTimeInMS1);

                long responseTimeInSeconds1 = response.getTimeIn(TimeUnit.SECONDS);
                System.out.println("Response Time in Seconds 1:" + responseTimeInSeconds1);

                response.then().time(Matchers.lessThan(5000L));
                response.then().time(Matchers.greaterThan(2000L));
                response.then()
                        .time(Matchers.both(Matchers.greaterThan(2000L))
                        .and(Matchers.lessThan(5000L)));

                response.then().time(Matchers.lessThan(2L), TimeUnit.SECONDS);

    }
}
