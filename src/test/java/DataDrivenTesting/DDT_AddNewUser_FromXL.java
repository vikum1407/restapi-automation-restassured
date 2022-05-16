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

import static DataDrivenTesting.XLUtils.getCellCount;

public class DDT_AddNewUser_FromXL {

 //   @Test(@DataProvider="empDataProvider")
    public void addNewUser(String ename, String eage, String esal){
        RestAssured.baseURI="http://34.139.97.35:9090/oneKBPayload";

        RequestSpecification httpRequest=RestAssured.given();

        //Here we created data which we can send along with the post request
        JSONObject requestParams=new JSONObject();
        requestParams.put("name",ename);
        requestParams.put("age",eage);
        requestParams.put("salary",esal);

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

    //Data provider method
    @DataProvider(name="empDataProvider")
    Object[][] getEmpData() throws IOException {

        //XL file path
        String path=System.getProperty("user.dir")+"/src/test/java/DataDrivenTesting/Data_Driven.xlsx";

        //Read data from XL file
        int rowCount= XLUtils.getRowCount(path,"Sheet1");
        int colCount= XLUtils.getCellCount(path,"Sheet1",1);

        String empData[][]=new String[rowCount][colCount];
        for(int i=1; i<=rowCount; i++){
            for(int j=0; j<colCount; j++){
                empData[i-1][j]=XLUtils.getCellData(path,"Sheet",i,j);
            }
        }


      //String empData[][]={{"vikum","23","30000"}, {"pasindu","24","20000"}, {"namel","26","10000"}};
        return(empData);
    }
}
