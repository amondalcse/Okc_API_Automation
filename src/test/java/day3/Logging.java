package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Logging
{
    @Test
    public void testLog()
    {
                given()
                .when()
                        //.get("https://reqres.in/api/users?page=2")
                        .get("https://www.google.com")
                .then()
                        //.log().all();
                        //.log().body();
                        //.log().cookies();
                        .log().headers();
    }
}
