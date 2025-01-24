package api.endpoints;
import io.restassured.response.Response;
import api.payloads.RequresUsers;

import static io.restassured.RestAssured.given;

public class RequresUserEndPoints
{

    public static Response createUser(RequresUsers payload)
    {
      Response response =  given()
        .contentType("application/JSON")
                .accept("application/JSON")
                .body(payload)
              .when()
              .post(Routes.createUser);

        return response;
    }
    public static Response updateUser(RequresUsers payload){
        Response response = given()
                .contentType("application/JSON")
                .accept("application/JSON")
                .body(payload)
                .when()
                .put(Routes.updateUser);

        return response;
    }

    public static Response deleteUser() {
        Response response = given()
                .contentType("application/JSON")
                .accept("application/JSON")
                .when()
                .delete(Routes.deleteuser);
        return response;
    }
    public static Response listOfUser(){
        Response response = given()
                .contentType("application/JSON")
                .accept("content/JSON")
                .queryParams("page",2)
                .log().all()
                .when()
                .get(Routes.listOfUser);
        return response;
    }


}
