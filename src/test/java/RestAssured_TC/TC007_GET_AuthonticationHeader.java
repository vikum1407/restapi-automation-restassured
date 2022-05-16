package RestAssured_TC;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class TC007_GET_AuthonticationHeader {

    @Test
    public void validateAuthonticationHeaders(){

        RestAssured.baseURI="http://34.139.97.35:9090/location/queries/location?address=tel:+94777777771&requestedAccuracy=1000";

        RequestSpecification httpRequest=RestAssured.given();
        httpRequest.header("Authorization","Bearer"+"eyJ4NXQiOiJOV1F3TmpnM04yRTNPREpqWmpBNU9HUTBZakl5TnpRMk1HUmxZamxqT1dSaE1EQmlZbU5qWm1ZMFpqWTBNemcxTkRZMll6VXlOVFEwTUdNek16QXhaQSIsImtpZCI6Ik5XUXdOamczTjJFM09ESmpaakE1T0dRMFlqSXlOelEyTUdSbFlqbGpPV1JoTURCaVltTmpabVkwWmpZME16ZzFORFkyWXpVeU5UUTBNR016TXpBeFpBX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiSWRWTTlRQzBBQjJlZURWSWtUN19mZjIwX2RJYSIsIm5iZiI6MTY1MTY0MDcxMywiYXpwIjoiSWRWTTlRQzBBQjJlZURWSWtUN19mZjIwX2RJYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9heG9uZWN0LndzbzJ0ZWxjby5jb206OTQ0NVwvb2F1dGgyXC90b2tlbiIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiaWF0IjoxNjUxNjQwNzEzLCJqdGkiOiI1NjQ0NTdlMy0wOWJkLTRlMzMtOTZiNC1hMmE2YzQ0YzQ4M2IifQ.g5SIfkIfdw6J7l5qGEVkpio9iexLB5xdNC197B-wxkVAlvlLyO-LNmEw-yqLWnj59dQ5vN1od62LaKLNOOwWHomnSWuJ3wv7DP1kS7r5xZYanHMX4_9e7vtlhKOgrF36RvgyY85STfrzRuTycPYXtiabrWzoXGhGmfHRCyNbaLMFH4rIXmo8wbKCNXlT2-DIvyMiNWX88E9EWwK-vLs2halGsY1XXxxzueq_Iv_3jSlEwgL7ta0sEUOmlQovgYvc-x-M3Mk2yno0VlhFjTegbOXmDfglqIHNMDSYwHfpKqPJsFJq6SugAfZIRQWM3hwgVLzV68caBOj7s86h6_Ac5A");


        Response response=httpRequest.request(Method.GET);
        String responseBody=response.getBody().asString();
        System.out.println("Payload Body:"+responseBody);
    }
}
