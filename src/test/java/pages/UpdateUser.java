package pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.TestData;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    private String token = "2303e5cc66b9bc0e9768b7b0be46db7d03d9b2299d90bbebd31001018fff7548";
    TestData user = new TestData();
    Response res = null;
    CreateUser cu = new CreateUser();

    public Response updateUserData(String id) {
        res = given()
                .header("Authorization", "Bearer "+token)
                .contentType("application/json")
                .pathParams("id", id)
                .body(user.updateUser().toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}");

        return res;
    }
}
