package JsonPathExamples;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathIntro {

    @Test
    public void JsonPathDemo()
    {
        String json = "{\"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",}";

        // Get Json path instance of given json document
        JsonPath jsonPath = new JsonPath(json);

//        String firstName = jsonPath.getString("firstname");
//        System.out.println(firstName);
//
//        Object fname = jsonPath.get("firstname");
//        System.out.println(fname);

        // Class cast exception
//        int i = jsonPath.get("firstname");
//        System.out.println(i);

//        String s = "123";
//        System.out.println(Integer.parseInt(s));

        // JSON path Non existence
        System.out.println((Object)jsonPath.get("$"));
        System.out.println(jsonPath.getString("$"));
        System.out.println((Object)jsonPath.get());
        System.out.println(jsonPath.getString(""));

    }
}
