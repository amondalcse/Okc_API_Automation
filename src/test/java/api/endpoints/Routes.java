package api.endpoints;


/*
User API:https://petstore.swagger.io/v2
Create user: https://petstore.swagger.io/v2/user/createUsersWithListInput
Get User:https://petstore.swagger.io/v2/user/{userName}
Update user:https://petstore.swagger.io/v2/user/{updateUser}
Delete User:https://petstore.swagger.io/v2/user/{deleteUser}
 */
public class Routes
{
    public static String base_url ="https://petstore.swagger.io/v2";

    //User Module end points:
     public static String createUserPostRequest=base_url+"/user";
     public static String getUserGetRequest=base_url+"/user/{userName}";
     public static String updateUserPutRequest=base_url+"/user/{userName}";
     public static String deleteUserDeleteRequest=base_url+"/user/{userName}";

     //Inventory Module



    //Store Module

}
