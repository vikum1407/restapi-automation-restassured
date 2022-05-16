package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TC002_POST_Request {

    @Test
    public void postPaymentChargeDetails(){

        //Specify the URI
        RestAssured.baseURI="http://34.139.97.35:9090/";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject requestParam = new JSONObject();

        requestParam.put("FirstName","Vikum");
        requestParam.put("MidleName","Vijayantha");
        requestParam.put("LastName","Sugathadasa");

        httpRequest.header("Content-Type","application/json");
        httpRequest.header("Cache-Control","no-cache");

        httpRequest.body(requestParam.toJSONString()); //Attached above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/oneKBPayload");

        //Print the response
        String responseBody = response.getBody().asString();
        System.out.println("Location Response"+responseBody);

        //Validate the status code
        int statusCode = response.statusCode();
        System.out.println("Status Code:"+statusCode);
        Assert.assertEquals(statusCode,200);

        //serviceType validation
        String serviceType = response.jsonPath().get("outputSDResp.serviceType");
        Assert.assertEquals("CNVRGTPrepaid",serviceType);
    }
}
