package day5;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
//import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidations
{
    @Test
    public void jsonValidation()
    {
                given()
                        .pathParam("user","users")
                        .log().all()
                .when()
                        .get("https://reqres.in/api/{user}/2")

                .then()
                        .statusCode(200)
                        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user2.json"));

    }
}
