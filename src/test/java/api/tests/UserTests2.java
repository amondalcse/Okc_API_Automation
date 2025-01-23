package api.tests;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests2
{
    Faker faker;
    User userPayload;
    public Logger logger;
    @BeforeClass
    public void setUpData(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger = LogManager.getLogger(this.getClass());
    }
    @Test(priority = 1)
    public void testCreateUser()
    {
        logger.info("***************User Create api*****************");
        Response response = UserEndPoints2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***************User successfully Created*****************");

    }

    @Test(priority = 2)
    public void getUserByUserName(){
        logger.info("***************get User based on username*****************");
        Response response  = UserEndPoints2.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("***************successfully fetch the user*****************");
    }
    @Test(priority = 3)
    public void updateUserByUserName()
    {
        logger.debug("updating user user");
        //update the data based on your test cases
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        logger.debug("get the updated user ");
        Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        response.then().log().body().statusCode(200);
        Assert.assertEquals(response.getStatusCode(),200);


        //checking data after updation

        Response responseAfterUpdation  = UserEndPoints2.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(responseAfterUpdation.getStatusCode(),200);

    }

    @Test(priority = 4)
    public void deleteUser(){
        Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
