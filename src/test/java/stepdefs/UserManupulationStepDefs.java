package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CreateUser;
import pages.DeleteUser;
import pages.UpdateUser;
import utils.TestData;


public class UserManupulationStepDefs {

    private Response response;
    private String token = "2303e5cc66b9bc0e9768b7b0be46db7d03d9b2299d90bbebd31001018fff7548";
    TestData user = new TestData();
    public static String id;

    @When("create a user")
    public void createUser() {
        CreateUser cu = new CreateUser();
        response = cu.createUser();
        id = cu.getUserId(response);
        System.out.println("User Id : "+id);
    }

    @Then("verify user created successfully with status code {int}")
    public void verifyUserCreated(Integer statusCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

    @When("update the user")
    public void updateUser() {
        UpdateUser uu = new UpdateUser();
        response = uu.updateUserData(id);
    }

    @Then("verify updated successfully and api returns status code {int}")
    public void verifyUserUpdated(Integer statusCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

    @When("delete the user")
    public void deleteUser() {
        DeleteUser du = new DeleteUser();
        response = du.deleteUser(id);
    }

    @Then("verify user deleted successfully and api returns status code {int}")
    public void verifyUserDeleted(Integer statusCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

}
