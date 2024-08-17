package testCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static utils.APIsManager.*;
import utils.JsonFileManager;

import java.util.HashMap;
import java.util.Map;

import static utils.PropertiesFileManager.getPropertiesValue;

@Listeners(utils.TestNGListners.class)
public class End2EndAPIScenario {

    @BeforeMethod
    public void setUpProperties() {
        RestAssured.baseURI = getPropertiesValue("baseUrlAPI");
    }

    @Test
    public void createThenUpdateThenDeleteBooking()
    {
        //Variables
        String contentType = "application/json";
        String LoginEndpoint = "auth/";
        String RequestEndpoint = "booking/";
        int bookingID;
        String token;
        Response response;

        Map loginBody = new HashMap<>();
        loginBody.put("username","admin");
        loginBody.put("password","password123");

        Map createBody = new HashMap();
        Map subCreateBody = new HashMap();
        subCreateBody.put("checkin", "2018-01-01");
        subCreateBody.put("checkout", "2020-01-01");
        createBody.put("firstname","yehia");
        createBody.put("lastname","metwally");
        createBody.put("totalprice",111);
        createBody.put("depositpaid",true);
        createBody.put("bookingdates", subCreateBody);
        createBody.put("additionalneeds","test");

        //Send Login API and Get Token from Response
        response = MakeRequest("Post",LoginEndpoint, loginBody,contentType);
        logResponseBody(response);
        token = getJsonStringValuefromResponse(response,"token");

        //Send Post Request to Create new Booking and get the Booking ID from Response
        response = MakeRequest("Post", RequestEndpoint, createBody,contentType);
        logResponseBody(response);
        bookingID = getJsonIntValueFromResponse(response,"bookingid");

        //Check the Response Body of Creating new Booking
        JSONObject object1 = JsonFileManager.convertMaptoJsonObject(createBody);
        JSONObject object2 = getJsonObjectfromResponse(response,"booking");
        Assert.assertEquals(object2.toString(),object1.toString());
        //Check the Response Status & Content Type of Creating new Booking
        verifyResponseCode(response,200);
        verifyResponseContentType(response,"application/json");

        //Send Put Request to Update the Booking details and pass the token
        createBody.replace("firstname","Sayed");
        createBody.replace("lastname","Mohamed");

        response = MakeAuthRequest("Put", RequestEndpoint +bookingID, createBody,contentType,
                "CookieAuth",null,null,token);
        logResponseBody(response);

        //Check the Response Body of Updating the Booking details
        String actualFirstName = getJsonStringValuefromResponse(response,"firstname");
        String actualLastName = getJsonStringValuefromResponse(response,"lastname");
        Assert.assertEquals(actualFirstName,"Sayed");
        Assert.assertEquals(actualLastName,"Mohamed");
        //Check the Response Status & Content Type f Updating the Booking details
        verifyResponseCode(response,200);
        verifyResponseContentType(response,"application/json");

        //Send Delete Request to Delete the created Booking and pass the token
        response = MakeAuthRequest("Delete", RequestEndpoint +bookingID,null,null,
                "CookieAuth",null,null,token);
        logResponseBody(response);

        //Check the Response Body of Deleting the created Booking
        Assert.assertEquals(getResponseBody(response),"Created");
        //Check the Response Status of Deleting the created Booking
        verifyResponseCode(response,201);

        //Check the Deleted Booking cannot be returned by Getting the booking details by ID
        response= GetRequest(RequestEndpoint +bookingID,null);
        logResponseBody(response);
        Assert.assertEquals(getResponseBody(response),"Not Found");

    }
}
