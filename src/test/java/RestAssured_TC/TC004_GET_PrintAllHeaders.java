package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class TC004_GET_PrintAllHeaders {

    @Test
    public void printAllHeaderGET(){

        //Specify URI
        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET);

        //Print response
        System.out.println("Response Body: "+response.getBody().asString());

        //Print All Headers
        Headers allHeaders=response.headers();
        //System.out.println("All Headers: "+ allHeaders);
        for (Header header:allHeaders){
            System.out.println(header.getName()+" ->  "+header.getValue());
        }
    }
}
