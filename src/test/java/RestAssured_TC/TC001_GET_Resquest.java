package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;

public class TC001_GET_Resquest {

    @Test
    public void getLocationDetails(){

        //Specify URI
        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";

        //Request  object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET);

        //Print response in cosole window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body:"+responseBody);

        //Validate the status code
        int statusCode = response.statusCode();
        System.out.println("Status Code: "+statusCode);
        Assert.assertEquals(statusCode,200);

        //Validate StatusLine
        String StatusLine = response.statusLine();
        Assert.assertEquals(StatusLine,"HTTP/1.1 200 OK");
    }
}
