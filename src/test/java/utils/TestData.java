package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class TestData {
    public JSONObject createUser() {
        Faker faker = new Faker();

        JSONObject userData = new JSONObject();
        userData.put("name", faker.name().fullName());
        userData.put("gender", "male");
        userData.put("email", faker.internet().emailAddress());
        userData.put("status", "inactive");

        return userData;
    }

    public JSONObject updateUser() {
        Faker faker = new Faker();

        JSONObject userData = new JSONObject();
        userData.put("name", faker.name().fullName());
        userData.put("gender", "male");
        userData.put("email", faker.internet().emailAddress());
        userData.put("status", "active");

        return userData;
    }
}
