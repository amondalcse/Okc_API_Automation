package api.endpoints;
import api.payloads.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
//UserEndPoints.java
//why we create this class to perform Create, Read, Update, delete request the User API(CRUD operation)

public class UserEndPoints
{

    public static Response createUser(User payload) {

        Response response = given()
                .contentType("application/JSON")
                .accept("application/JSON")
                .body(payload)
                .log().all()
                .when()
                .post(Routes.createUserPostRequest);
        return response;
    }

    public static Response getUser(String userName)
        {
            Response response = given()
                    .pathParam("userName", userName)
                    .when()
                    .log().all()
                .get(Routes.getUserGetRequest);
            return response;
        }


    public static Response updateUser(String userName, User payload) {

                Response response = given()
                        .contentType("application/JSON")
                        .accept("application/JSON")
                        .pathParam("userName", userName)
                        .body(payload)
                        .when()
                        .log().all()
                        .put(Routes.updateUserPutRequest);
                return response;
    }

    public static Response deleteUser(String userName){
                 Response response = given()
                         .pathParam("userName",userName)
                         .log().all()
                .when()
                         .delete(Routes.deleteUserDeleteRequest);
                 return response;

    }
    {

    }

}
