package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {

    //Variables
    String filePath;

    //Constructor
    public JsonFileReader (String filePath)
    {
        this.filePath = filePath;
    }

    //Method to get JsonFile and convert it to JsonObject
    private JSONObject getJsonFile() throws IOException, ParseException {
        //pass the path of test data json file
        File filename = new File(filePath);
        //convert the json file to string
        String jsonString = FileUtils.readFileToString(filename,"UTF8");
        //parse the json string into object
        Object obj = new JSONParser().parse(jsonString);
        //return the object as Json Object
        return (JSONObject) obj;
    }

    //Method to get JsonData by Input
    public String getTestData (String input) throws IOException, ParseException {
        Object object = getJsonFile().get(input);
        return (String)object;
    }

    //Method to get JsonData by Input and Sub Input
    public String getTestData (String input,String SubInput) throws IOException, ParseException {
        Object object = getJsonFile().get(input);
        object = ((JSONObject)object).get(SubInput);
        return (String)object;
    }
}

