package day7;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class ApiChaining
{

    //ff87785d62b874151267219613a6d807af19a3267c1dba5a4788fee00dd28e5a
    @Test
    public void createOtpId(ITestContext context){
        Faker faker =  new Faker();

        HashMap data = new HashMap();
        data.put("name",faker.name().fullName());
        data.put("gender","male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");

        String token = "ff87785d62b874151267219613a6d807af19a3267c1dba5a4788fee00dd28e5a";

               Response res = given()
                        .headers("Authorization","Bearer "+token)
                        .contentType("application/JSON")
                        .body(data)
                        .pathParam("public","public")
                       .pathParam("v2","v2")
                       .pathParam("user","users")
                       .log().all()

                .when()
                        .post("https://gorest.co.in/{public}/{v2}/{user}");
                        Assert.assertEquals(res.getStatusCode(),201);
                        int id=res.jsonPath().getInt("id");
                        String status = res.jsonPath().get("status");
                        Assert.assertEquals(status,"inactive");
               System.out.println("Genrated id is "+id);
               //context.setAttribute("user_id",id);
                context.getSuite().setAttribute("user_id", id);


    }
}
