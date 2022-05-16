package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DDT_AddNewUser_HardcordPassing {

    @Test
    public void addNewUser(){
        RestAssured.baseURI="http://34.139.97.35:9090/oneKBPayload";

        RequestSpecification httpRequest=RestAssured.given();

        //Here we created data which we can send along with the post request
        JSONObject requestParams=new JSONObject();
        requestParams.put("name","Vikum");
        requestParams.put("age","30");
        requestParams.put("salary","75000");

        //Add a header starting the request body is a JSON
        httpRequest.header("Content-Type","application/json");
        httpRequest.header("Cache-Control","no-cache");

        //Add the json to the body of the request
        httpRequest.body(requestParams.toJSONString());

        //POST Request
        Response response=httpRequest.request(Method.POST);

        //Capture response body
        String responseBody=response.getBody().asString();
        System.out.println("Response Body:"+responseBody);
        Assert.assertEquals(responseBody.contains("1-20RW-144"),true);

    }

}
