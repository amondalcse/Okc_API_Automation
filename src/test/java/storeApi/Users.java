package storeApi;
import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Users
{
    Faker faker = new Faker();
    String username = faker.name().username();
    @Test(priority = 0)
    public void createUser()
    {

        //Faker faker = new Faker();
        //HashMap data = new HashMap();
        JSONObject data = new JSONObject();
        data.put("id",1);
        data.put("username",username);
        data.put("firstName", faker.name().firstName());
        data.put("lastname",faker.name().lastName());
        data.put("email",faker.internet().emailAddress());
        data.put("password","abhi@123");
        data.put("phone","5555551111");
        data.put("userStatus",faker.number().numberBetween(1,5));
        JSONArray users = new JSONArray();
        users.put(data);
      //  https://petstore.swagger.io/v2/user/createWithList
        Response res = given()
                .contentType("application/JSON")
                .body(users.toString())
                .log().all()
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
                Assert.assertEquals(res.getStatusCode(),200);
                res.then().log().all();
                //username = res.jsonPath().get("username");
                //System.out.println(username);

    }
    @Test(priority = 1)
    public void getUser()
    {
        given()
                .contentType("application/JSON")
                .when()
                .log().all()
                .pathParam("username",username)
                .get("https://petstore.swagger.io/v2/user/{username}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void deleteUser()
    {
        given()
                .contentType("applicaion/JSON")
                .pathParam("username",username)
                .when()
                .log().all()
                .delete("https://petstore.swagger.io/v2/user/{username}")
                .then().log().all()
                .statusCode(200);


    }
}
