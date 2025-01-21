package day7;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class UpdateUser
{
    @Test
    public void updateUsers(ITestContext context){
        int id= (int) context.getSuite().getAttribute("user_id");
        Faker faker=new Faker();
        JSONObject data = new JSONObject();
        data.put("name",faker.name().fullName());
        data.put("gender","female");
        data.put("email",faker.internet().emailAddress());
        data.put("status","active");

        String token = "ff87785d62b874151267219613a6d807af19a3267c1dba5a4788fee00dd28e5a";
                given()
                        .headers("Authorization","Bearer "+token)
                        .contentType("application/JSON")
                        .pathParam("id",id)
                        .body(data.toString())
                        .log().all()


                .when()
                        .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                        .statusCode(200)
                        .log().all();
}
}
