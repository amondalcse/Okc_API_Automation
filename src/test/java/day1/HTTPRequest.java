package day1;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/*
given()
    content-type, add auth, set cookies, add param, set header info etc..
when()
    request type like: get, put,post,delete
then()
    validated status code, extract response,extract header cookies & response body etc..,
 */
public class HTTPRequest
{
    int id;
    @Test(priority = 3)
    public void getListOfUser()
    {
       given()
               .baseUri("https://reqres.in")
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200);
                //body("page",equalTo(2)).log().all();

    }

    @Test(priority = 1)
    public void createUser(){
        HashMap data = new HashMap();
        data.put("name","abhijit");
        data.put("job","student");

        id= given()
                .baseUri("https://reqres.in")
                .contentType("application/JSON")
                .body(data)
                .when()
                .post("/api/users")
                .jsonPath().getInt("id");

               /* .then()
                .statusCode(201)
                .body("name",equalTo("abhijit"))
                .body("job",equalTo("student"))
                .log().all();*/
    }
    @Test(priority = 2, dependsOnMethods = {"createUser"})
    public void updateUser()
    {
        HashMap data1 = new HashMap();
        data1.put("name","abhijit Kumar");
        data1.put("job","student update1");
        given()
                .baseUri("https://reqres.in")
                .contentType("application/JSON")
                .body(data1)
                .when()
                .put("/api/users/"+id)
                .then()
                        .statusCode(200)
                        .body("name",equalTo("abhijit Kumar"))
                        .body("job",equalTo("student update1"))
                        .log().all();
    }

    @Test(priority = 4)
    public void deleteUser()
    {
        given()
                .baseUri("https://reqres.in")
                .contentType("application/JSON")
                .when()
                .delete("/api/users/"+id)
                .then()
                .statusCode(204);
    }

}
