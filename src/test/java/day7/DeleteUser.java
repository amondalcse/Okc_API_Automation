package day7;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class DeleteUser {

    @Test
    public void deleteUseres(ITestContext context){
        int id = (int) context.getSuite().getAttribute("user_id");

        String token = "ff87785d62b874151267219613a6d807af19a3267c1dba5a4788fee00dd28e5a";
                given()
                        .headers("Authorization","Bearer "+token)
                        .pathParam("id",id)
                        .log().all()
                .when()
                        .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                        .statusCode(204);
    }
}
