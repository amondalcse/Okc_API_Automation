package api.tests;

import api.endpoints.RequresUserEndPoints;
import api.payloads.RequresUsers;


import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReqresUserTest
{
    Faker faker;
    RequresUsers requser;
    @BeforeClass

    public void setupdata(){
        faker = new Faker();
        requser = new RequresUsers();

        requser.setName(faker.name().firstName());
        requser.setJob(faker.funnyName().name());


    }

    @Test(priority = 0,enabled = false)
    public void createUser(){
        Response response = RequresUserEndPoints.createUser(requser);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
        String id = response.jsonPath().get("id");
        String job = response.jsonPath().get("job");
        System.out.println(job);

    }
    @Test(priority = 1,enabled = false)
    public void updateUser(){
        requser = new RequresUsers();
        requser.setName(faker.name().fullName());
        requser.setJob(faker.name().title());
        Response response = RequresUserEndPoints.updateUser(requser);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        String job = response.jsonPath().get("job");
        System.out.println(job);

    }
    @Test(priority = 2,enabled = false)
    public void deleteUser(){

        Response response = RequresUserEndPoints.deleteUser();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),204);


    }

    @Test(priority = 3)
    public void  listOfUser(){
       Response response  = RequresUserEndPoints.listOfUser();
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);
       int total = response.jsonPath().get("total");
       System.out.println(total);
       String firstName = response.jsonPath().getString("data[1].first_name");
       System.out.println(firstName);

    }

}
