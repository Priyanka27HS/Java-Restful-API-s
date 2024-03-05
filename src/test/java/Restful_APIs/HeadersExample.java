package Restful_APIs;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import org.apache.http.entity.mime.Header;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadersExample {

    @Test
    public void passHeader()
    {
        RestAssured
                .given()
                .log()
                .all()
                .header("Header1", "value1")
                .header("Header2", "value1", "value2", "value3")
                .when()
                .get();
    }

    @Test
    public void passHeader1()
    {
        RestAssured
                .given()
                .log()
                .all()
                .header("Header1", "value1")
                .header("Header2",  "value2")
                .when()
                .get();
    }

    @Test
    public void passHeader2()
    {
//        List<Header> allHeaders = new ArrayList<>();
//        Header header = new Header();
//        Header header1 = new Header("Header2", "value2");
//        allHeaders.add(header);
//        allHeaders.add(header1);
//
//        Headers headers = new Headers(allHeaders);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("h1", "v1");
        headerMap.put("h2", "v2");
        headerMap.put("h3", "v3");
        headerMap.put("h4", "v4");

        RestAssured
                .given()
                .log()
                .all()
                .headers(headerMap)
                .when()
                .get();
    }

}
