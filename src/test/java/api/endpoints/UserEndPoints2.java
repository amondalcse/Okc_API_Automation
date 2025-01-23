package api.endpoints;
import api.payloads.User;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
//UserEndPoints.java
//why we create this class to perform Create, Read, Update, delete request the User API(CRUD operation)

public class UserEndPoints2
{
    static ResourceBundle getUrl(){
        ResourceBundle routes = ResourceBundle.getBundle("routes");//load properties file
        return routes;
    }


    public static Response createUser(User payload) {
        String createUser = getUrl().getString("createUserPostRequest");

        Response response = given()
                .contentType("application/JSON")
                .accept("application/JSON")
                .body(payload)
                .log().all()
                .when()
                .post(createUser);
        return response;

    }

    public static Response getUser(String userName)
        {
            String getUser = getUrl().getString("getUserGetRequest");
            Response response = given()
                    .pathParam("userName", userName)
                    .when()
                    .log().all()
                .get(getUser);
            return response;
        }


    public static Response updateUser(String userName, User payload) {
        String updateUser = getUrl().getString("updateUserPutRequest");
                Response response = given()
                        .contentType("application/JSON")
                        .accept("application/JSON")
                        .pathParam("userName", userName)
                        .body(payload)
                        .when()
                        .log().all()
                        .put(updateUser);
                return response;
    }

    public static Response deleteUser(String userName){
        String deleteUser = getUrl().getString("deleteUserDeleteRequest");
                 Response response = given()
                         .pathParam("userName",userName)
                         .log().all()
                .when()
                         .delete(deleteUser);
                 return response;

    }
    {

    }

}
