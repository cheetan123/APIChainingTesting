package pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.TestData;

import static io.restassured.RestAssured.given;

public class CreateUser {

    private String token = "2303e5cc66b9bc0e9768b7b0be46db7d03d9b2299d90bbebd31001018fff7548";
    TestData user = new TestData();
    Response res = null;

    public Response createUser() {
        res = given()
                .header("Authorization", "Bearer "+token)
                .contentType("application/json")
                .body(user.createUser().toString())
                .when()
                .post("https://gorest.co.in/public/v2/users");

        return res;
    }

    public String getUserId(Response response) {
        JSONObject data = null;
        JSONParser parser = new JSONParser();
        try {
            data = (JSONObject) parser.parse(response.asString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return data.get("id").toString();
    }
}
