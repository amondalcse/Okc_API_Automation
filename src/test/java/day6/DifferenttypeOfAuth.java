package day6;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DifferenttypeOfAuth
{

    //Basic auth
    @Test(priority = 0)
    public void basicAuth(){
                given()
                        .auth().basic("postman","password")
                .when()
                        .get("https://postman-echo.com/basic-auth")
                .then()
                        .statusCode(200)
                        .log().all()
                        .body("authenticated",equalTo(true));

    }
    @Test(priority = 1)
    public void digestAuth(){
                given()
                    .auth().digest("postman","password")
                .when()
                    .get("https://postman-echo.com/basic-auth")
                .then()
                    .statusCode(200)
                     .log().all()
                    .body("authenticated",equalTo(true));

    }
    @Test(priority = 2)
    public void preemptiveAuth(){
                given()
                     .auth().preemptive().basic("postman","password")
                .when()
                        .get("https://postman-echo.com/basic-auth")
                .then()
                    .statusCode(200)
                    .log().all()
                    .body("authenticated",equalTo(true));

    }
    @Test(priority = 3)
    public void bearerTokenAuth(){
        String token = "eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIiwidHlwIjoiSldUIn0..FgUuEZrnd5a03XSO.Wcz8ypArKlHHfDtFaP3Hst1Vh5hook7b_vJdQUfn6TTeEe6dEvgqmOwxtYlqvcRhg2eJPRWVWeMHiP9KP9EsQQFSKVAVrYxfHo1TKrmd6SnKvZvV8OHwvP5tswB_ihjkB4dnHYgFZGs5o5k2mEsafG3CGt7aPG9xgIyebox-XLggkrNd_eRAgz-W4N1zpeC-JbhzWCWS40eUvmDLo4Wk6F6zJ61NN1v7Egoeu8HX8WSzhSUBaTUkt6OaxlBeNdsvPRc8mI2WSMST.F71ccvRnbAMu_uxAcBKmlw";
        HashMap map = new HashMap();
        map.put("pan","BMXPM4664E");
        map.put("service_name","collection");
                given()

                        .headers("Authorization","Bearer "+token)
                        .body(map)
                .when()
                        .post("https://kyc.staging.okcredit.io/verify/pan")
               // .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .log().all()
                .body("result.pan_name",equalTo("ABHIJIT MONDAL"))
                .body("result.verified",equalTo(false));

    }

    //api-key: ac70bbb4995d82fb7723faa2add80c8f

    @Test
    public void apiKeyAuth()
    {
                given()

                .when()
                .then();
    }
}
