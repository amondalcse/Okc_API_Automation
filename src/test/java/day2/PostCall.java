package day2;

//import jdk.internal.org.objectweb.asm.Handle;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostCall
{
    //@Test
    public void requestOTP(){
        HashMap data = new HashMap();
        data.put("grant_type","password");
        data.put("username","6666660722");
        data.put("password","1234");

                given()
                        .contentType("application/JSON")
                        .body(data)

                        .log().all()


                .when()
                        .post("https://auth.staging.okcredit.in/v1.0/auth")
                .then()
                        .statusCode(200)
                        .log().body();
    }
   /*@Test
    public void usingMapConcept(){
        HashMap data = new HashMap();
        data.put("name","test1");
        data.put("location","USA");
        data.put("phone","5555550001");
       String courses1[] ={"A","B"};
       data.put("courses",courses1);

                given()
                        .contentType("application/JSON")
                        .body(data)
                .when()
                        .post("http://localhost:3000/students")
                .then()
                        .log().body()
                        .statusCode(201)
                        .body("name",equalTo("test1"))
                        .body("location",equalTo("USA"));






    }*/
}
