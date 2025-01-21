package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameter
{
    @Test
    public void testQuerynadPathParameter()
    {

       // https://reqres.in/api/users?page=2
        given()
                .contentType("appilcation/json")
                .pathParams("mypath","users") //path parameter
                .queryParams("page",2) //query paramater
                .when()
                .get("https://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();

    }
}
