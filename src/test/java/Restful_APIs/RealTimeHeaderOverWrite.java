package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RealTimeHeaderOverWrite {

    @Test
    public void realTimeHeaderOverWrite()
    {
        RequestSpecification res1 = RestAssured.given()
                .header("header1", "value1");

        RequestSpecification res2 = RestAssured.given()
                .header("header2", "value3")
                .header("header1", "value2");


        // We can pass multiple RequestSpecification and ResponseSpecification in our spec
        RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .headerConfig(HeaderConfig.headerConfig()
                                .overwriteHeadersWithName("header1")))
                .spec(res1)
                .spec(res2)
                .log()
                .all()
        .given()
                .get();
    }
}
