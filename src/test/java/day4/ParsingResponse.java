package day4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class ParsingResponse
{
   // String id="";

    @Test
    public void testJsonResonse(){
        //First approach 1
        //matcher assertion
                /*given()
                        .contentType("application/SON")
                        .pathParam("user","users")
                        .queryParams("page","2")
                        .log().all()

                .when()
                        .get("https://reqres.in/api/{user}")

                .then()
                        .statusCode(200)
                        .log().body()
                        .body("data[5].email",equalTo("rachel.howell@reqres.in"))
                        .body("page",equalTo(2))
                        .body("per_page",equalTo(6));*/

        //First approach 2
        //will save entire response as a variable and will validate
        //testng assertion

              /* Response res =  given()
                        .contentType("application/SON")
                        .pathParam("user","users")
                        .queryParams("page","2")
                .when()
                        .get("https://reqres.in/api/{user}");
            System.out.print(res.body());
            Assert.assertEquals(res.getStatusCode(),200);//validation 1
            Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
            String fname= res.jsonPath().get("data[3].first_name").toString();
            System.out.println("firstname for data3-->"+fname);
            Assert.assertEquals(fname,"Byron");
           id = res.jsonPath().get("data[0].id").toString();
            System.out.println("firstname for data0-->"+id);*/


            //Approach 3
        //need to capture all the first name
        //read all the element
        Response res =  given()
                .contentType(ContentType.JSON)
                .pathParam("user","users")
                .queryParams("page","2")
                .when()
                .get("https://reqres.in/api/{user}");

                //JSONObject Class
        /*JSONObject jo = new JSONObject(res.asString());//converting reponse type to JSON object type
        for(int i=0;i<jo.getJSONArray("data").length();i++){
            String first_name=jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
            System.out.println(first_name);
        }*/
        boolean  status = false;
        JSONObject jo = new JSONObject(res.asString());
        for(int i=0;i<jo.getJSONArray("data").getJSONObject(i).length();i++){
            String last_name = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
            System.out.println(last_name);
            if(last_name.equalsIgnoreCase("Funke")){
                status = true;
                break;
            }
        }
        Assert.assertEquals(status,true);

    }
}
