package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetHeaderInfo
{
    @Test
    public void getHeaderInfo(){
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws");

    }
}
