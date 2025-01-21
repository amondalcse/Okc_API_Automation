package day3;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CookiesAndHeaders
{
    @Test(priority = 1)
    public void TestcookiesAndHeader()
    {
        given()
                . when()
                .get("https://www.google.com/")
                .then()
                .cookie("AEC","Ackid1SZV3KNIB5-CyI9EbV9VAlME8xqY0MJq4gLL4omLJLDTl0kuWgMH6M; expires=Wed, 12-Jun-2024 08:40:04 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
                .log().all();
    }

   // @Test(priority = 2)
    public void getCookiesInfo() {
        Response res = given()
                .when()
                .get("https://www.google.com/");

        //get single cookies info

               /*String cookies_val=res.getCookie("AEC");
               System.out.println(cookies_val);*/

        //get multiple cookes

        Map<String, String> cookes_value = res.getCookies();
        for (String k : cookes_value.keySet()) {
            String cookies_val = res.getCookie(k);
            System.out.println(k + "  " + cookies_val);
        }
    }

        @Test(priority = 3)
        public void getHeaderInfo()
        {
            Response res = given()
                    . when()
                    .get("https://www.google.com/");


            //get single cookies info

               /*String cookies_val=res.getCookie("AEC");
               System.out.println(cookies_val);*/

            //get multiple cookes

           Map<String, String> cookies = res.getCookies();
           for(String k:cookies.keySet()){
               String cookies_value = res.getCookie(k);
               System.out.println(k +"  "+cookies_value);
            }




    }

}
