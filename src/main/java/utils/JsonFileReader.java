package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonFileReader {

    //Variables
    String filePath;

    //Constructor
    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }

    //Method to get JsonFile and convert it to JsonObject
    private JSONObject getJsonFile() throws IOException, ParseException {
        //pass the path of test data json file
        File filename = new File(filePath);
        //convert the json file to string
        String jsonString = FileUtils.readFileToString(filename, "UTF8");
        //parse the json string into object (Deserialization)
        Object obj = new JSONParser().parse(jsonString);
        //return the object as Json Object
        return (JSONObject) obj;
    }

    //Method to Get JsonData by Input
    public String getTestData(String key) throws IOException, ParseException {
        String[] arrofSTG = key.split("\\.");
        Object object = getJsonFile().get(arrofSTG[0]);
        if (arrofSTG.length==2) {
            object = ((JSONObject) object).get(arrofSTG[1]);
        }
        if (arrofSTG.length==3) {
            object = ((JSONObject) object).get(arrofSTG[2]);
        }
        return (String) object;
    }

    //Method to Set JsonData by Input
    public void setTestData(String key, String value) throws IOException, ParseException {
        String[] arrofSTG = key.split("\\.");
        Object object = getJsonFile();
        Object object2;
        if (arrofSTG.length==1) {
            ((JSONObject)object).put(arrofSTG[0],value);
        }
        else if (arrofSTG.length==2) {
            object2 = ((JSONObject)object).get(arrofSTG[0]);
            ((JSONObject) object2).put(arrofSTG[1], value);
        }
        else if (arrofSTG.length==3) {
            object2 = ((JSONObject)object).get(arrofSTG[0]);
            Object object3= ((JSONObject)object2).get(arrofSTG[1]);
            ((JSONObject) object3).put(arrofSTG[2], value);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formattedJson = gson.toJson(object);
        JsonFileWriter.createJsonFile(formattedJson,filePath);
    }
}


