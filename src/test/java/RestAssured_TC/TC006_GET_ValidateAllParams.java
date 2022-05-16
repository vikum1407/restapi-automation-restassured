package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class TC006_GET_ValidateAllParams {

    @Test
    public void validateAllParamValues(){

        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);

        String responseBody=response.getBody().asString();
        System.out.println("Payload Body:"+responseBody);
        Assert.assertEquals(responseBody.contains("Retrieved"),true);

        //Get the complete json response
        JsonPath jsonPath=response.jsonPath();
        String addressValue=jsonPath.get("terminalLocationList.terminalLocation.address");
        System.out.println(addressValue);
    }
}
