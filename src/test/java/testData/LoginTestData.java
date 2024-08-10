package testData;

import org.json.simple.JSONObject;

public class LoginTestData {
    public JSONObject json = new JSONObject();

    private void setTestData()
    {
        json.put("ValidUserName","");
        json.put("ValidPassword","");

        json.put("InvalidUsername","");
        json.put("InvalidPassword","");
    }

}
