package JsonPathExamples;

import io.restassured.path.json.JsonPath;

public class JsonPathForSimpleJsonObject {

    public static void main(String[] args) {

        String jsonObject = "{\"firstname\" : \"Tom\",\n" +
                "    \"lastname\" : \"Jerry\",\n" +
                "    \"age\" : 21,\n" +
                "    \"address\" : \"Bengaluru\",\n" +
                "    \"job\" : \"IT\",\n" +
                "    \"married\" : true,\n" +
                "}";

        JsonPath jp = new JsonPath(jsonObject);
        String firstName = jp.getString("$.firstName");
        System.out.println(firstName);

        int age = jp.getInt("age");
        System.out.println(age);

        boolean married = jp.getBoolean("married");
        System.out.println(married);



    }

}
