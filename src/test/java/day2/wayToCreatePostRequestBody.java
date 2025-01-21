package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*
1. HashMap
2. Using org.json librabry(add the library in pom file it will create separate file)
3. POJO class(most relevant uses in industry)
4. Post request Using external json file.
 */
public class wayToCreatePostRequestBody
{
    int id;
    //1.HashMap
    @Test()
    public void testpostUsingHashMap(){
        HashMap data = new HashMap();

        data.put("name","ab");
        data.put("location","test");
        data.put("phone","12345777");

        String arr[]={"java1","selenium1"};
        data.put("cources",arr);

       id =  given()
                .contentType("application/JSON")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
               .jsonPath().getInt("id");
               /* .then()
                    .statusCode(201)
                .body("name",equalTo("ab"))

                .body("location",equalTo("test"))
                .body("phone",equalTo("12345777"))
                .body("cources[0]",equalTo("java1"))
                .body("cources[1]",equalTo("selenium1"))
                //.header("Content-Type","application/JSON; charset=utf-8")
                .log().all();*/


    }

    //@Test
    public void delete()
    {
        given()
                .contentType("application/JSON")
                .when()
                .delete("http://localhost:3000/students/"+id)
                .then()
                .statusCode(200);
    }

    // 2nd option using org.json library
    //@Test()
            public void usingORGJSONLibMethod() {

        JSONObject data = new JSONObject();
        data.put("name","pop");
        data.put("location","test");
        data.put("phone","434343");
        String arr[] ={"pppp","qqqq"};

        data.put("cources", arr);

       given()
                .contentType("application/JSON")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                //.jsonPath().getInt("id");
                .then()
                    .statusCode(201)
                .body("name",equalTo("pop"))
                .body("location",equalTo("test"))
                .body("phone",equalTo("434343"))
                .body("cources[0]",equalTo("pppp"))
                .body("cources[1]",equalTo("qqqq"))
                //.header("Content-Type","application/JSON; charset=utf-8")
                .log().all();
    }

    @Test
    public void deleteJSONLibPortCall()
    {
        given()
                .contentType("application/JSON")
                .when()
                .delete("http://localhost:3000/students/lkztV6K")
                .then().log().all();
    }

   // 3. POJO class(most relevant uses in industry)
   // @Test
    public void usingPojoClass() {

       POJOForPOstCall data = new POJOForPOstCall();
        data.setName("abhi");
        data.setPhone("77777");
        data.setLocation("Ind");
        String courcesArr[]={"ab","cd"};
        data.setCources(courcesArr);


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                //.jsonPath().getInt("id");
                .then()
                .statusCode(201)
                .body("name",equalTo("abhi"))
                .body("location",equalTo("Ind"))
                .body("phone",equalTo("77777"))
                .body("cources[0]",equalTo("ab"))
                .body("cources[1]",equalTo("cd"))
                //.header("Content-Type","application/JSON; charset=utf-8")
                .log().all();
    }
    //@Test()
    public void deletePojopostId()
    {
        given()
                .contentType("application/json")
                .when()
                .delete("http://localhost:3000/students/HyT2Ayu")
                .then().log().all();
    }

    //using external data file.
    @Test()
    public void externalJsonFile() throws FileNotFoundException {
        File f = new File(".//body.json");
        FileReader reader = new FileReader(f);
        JSONTokener jk = new JSONTokener(reader);
        JSONObject js = new JSONObject(jk);


        given()
                .contentType("application/json")
                .body(js.toString())
                .when()
                .post("http://localhost:3000/students")
                //.jsonPath().getInt("id");
                .then()
                .statusCode(201)
                .body("name",equalTo("abhi"))
                .body("location",equalTo("Ind"))
                .body("phone",equalTo("77777"))
                .body("cources[0]",equalTo("ab"))
                .body("cources[1]",equalTo("cd"))
                //.header("Content-Type","application/JSON; charset=utf-8")
                .log().all();
    }



}
