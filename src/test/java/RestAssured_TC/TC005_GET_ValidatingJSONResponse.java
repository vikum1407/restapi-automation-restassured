package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.PanelUI;

public class TC005_GET_ValidatingJSONResponse {

    @Test
    public void validatingJsonResponse(){

        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body:"+responseBody);
        Assert.assertEquals(responseBody.contains("Retrieved"),true);
    }
}
