package storeApi;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetInventory
{
    int id=0;
    @Test(priority = 0)
    public void getInventorydetails() {
        given()
                .contentType("application/JSON")
                .log().all()
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test(priority = 1)
    public void placeOrder(){
        Faker faker = new Faker();
        HashMap data = new HashMap();
        data.put("id",faker.number().numberBetween(1,10));
        data.put("quantity","1");
        data.put("shipDate","2024-07-30T13:10:06.795+0000");
        data.put("status","true");
        data.put("complete","true");
               Response res =  given()
                        .contentType("application/JSON")
                        .body(data)
                        .log().all()
                .when()
                        .post("https://petstore.swagger.io/v2/store/order");

               Assert.assertEquals(res.getStatusCode(),200);
               id = res.jsonPath().get("id");
               System.out.println(id);
        //System.out.println(res.jsonPath());

    }

    //https://petstore.swagger.io/v2/store/order/2
    @Test(priority = 2)
    public void getOrderByID(){
                Response res = given()
                        .contentType("application/JSON")
                        .pathParam("id",id)
                        .log().all()
                .when()
                        .get("https://petstore.swagger.io/v2/store/order/{id}");

                        Assert.assertEquals(res.statusCode(),200);
                        int id1 = res.jsonPath().get("id");
                        Assert.assertEquals(id1,id);
                        String status = res.jsonPath().get("status").toString();
                        Assert.assertEquals(status,"true");
                        String complete = res.jsonPath().get("complete").toString();
                        System.out.println("print the complete status--->"+complete);
                        Assert.assertEquals(complete,"true");

    }

    @Test(priority = 3)
    public void deleteByID()
    {
        //https://petstore.swagger.io/v2/store/order/2
                given()
                        .contentType("apllication/JSON")
                        .pathParam("id",id)
                        .log().all()
                .when()
                        .delete("https://petstore.swagger.io/v2/store/order/{id}")
                .then()
                        .statusCode(200);
    }
}
