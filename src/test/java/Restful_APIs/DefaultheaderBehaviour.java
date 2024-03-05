package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

public class DefaultheaderBehaviour {

    @Test
    public void defaultBehaviour()
    {
        // Duplicate values are over loaded here
        RestAssured
                .given()
                .header("header1", "value1", "value2")
//                .header("header1", "value2")
                .log()
                .all()
         .when()
                .get();

    }

    @Test
    public void overwriteHeaderValue()
    {
        RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .headerConfig(HeaderConfig.headerConfig()
                        .overwriteHeadersWithName("header1", "header2")))

                // to hide the content from the logs use the blacklist method
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("header1")))

                .config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("header1")))

                .header("header1", "value1")
                .header("header1", "value2")
                .header("header3", "value3")
                .header("header3", "value4")
                .header("header2", "value5")
                .header("header2", "value6")
                .log()
                .all()
                .when()
                .get();


    }
}
