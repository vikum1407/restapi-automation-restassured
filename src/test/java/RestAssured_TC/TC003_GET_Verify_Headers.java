package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class TC003_GET_Verify_Headers {

    @Test
    public void verifyGETHeaders(){

        //Specify the URI
        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET);

        //Print response
        String responseBody=response.getBody().asString();
        System.out.println("Response Body:"+responseBody);

        //Capture the headers from response
        String contentType = response.header("content-type");
        System.out.println("Content Type:"+contentType);
        Assert.assertEquals("application/json; charset=UTF8",contentType);

        String contentLength=response.header("content-length");
        System.out.println("Content Length:"+contentLength);
        Assert.assertEquals("345",contentLength);
    }
}
