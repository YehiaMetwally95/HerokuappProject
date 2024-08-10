package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

    public static void setJsonFileFromDB(String dbUrl,String dbUser,String dbPass,
                                         String query,String jsonFilePath,String[] jsonKeys) throws SQLException, IOException {
        //Register Driver Classs for the Database
        DriverManager.registerDriver(new Driver());
        //Create Connection with the Database
        Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        //Execute the Select Query on the Database and retrieve the query results in Result Set
        ResultSet rs = connection.createStatement().executeQuery(query);

        //Create JSON Objects and JSON Array that represent the Json File Format
        JSONArray array = new JSONArray();
        JSONObject record;

        //Outer Looping on each record/row on Database table
        while(rs.next()) {
            record = new JSONObject();

            //Inner Looping on each column in a specific row of Database table
            for (int i = 0 ;i< rs.getMetaData().getColumnCount() ;i++)
            {   //Fill the Json Object with the column value of a specific row
                record.put(jsonKeys[i],
                        rs.getString(rs.getMetaData().getColumnName(i+1)));
            }
            //Fill the  Json Array of each object hat represent a certain row on Table
            array.add(record);
        }

        //Convert the Format of Parent JSON Array to a pretty format
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formattedJson = gson.toJson(array);
        //Write the Pretty Format of Parent JSON Array into the JSON File
        JsonFileWriter.createJsonFile(formattedJson,jsonFilePath);
    }

    public static void setJsonFileFromDB(String dbUrl,String dbUser,String dbPass,
                                         String query,String jsonFilePath,
                                         String[] jsonKeys,String[] jsonMainKeys) throws SQLException, IOException {
        //Register Driver Classs for the Database
        DriverManager.registerDriver(new Driver());
        //Create Connection with the Database
        Connection connection = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        //Execute the Select Query on the Database and retrieve the query results in Result Set
        ResultSet rs = connection.createStatement().executeQuery(query);

        //Create Parent & Child JSON Objects that represent the Json File Format
        JSONObject mainRecord = new JSONObject();
        JSONObject record;

        //Outer Looping on each record/row on Database table
        while((rs.next())) {
            //Inner Looping on each column in a specific row of Database table
            record = new JSONObject();
            for (int i = 0 ; i <rs.getMetaData().getColumnCount(); i++)
            {
                //Fill the child Json Object with the column value of a specific row
                record.put(jsonKeys[i],
                        rs.getString(rs.getMetaData().getColumnName(i+1)));
            }
            //Fill the Parent Json Object with main keys and the corresponding child object of each key
            mainRecord.put(jsonMainKeys[ rs.getRow()-1 ], record);
            }

        //Convert the Format of Parent JSON Object to a pretty format
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formattedJson = gson.toJson(mainRecord);

        //Write the Pretty Format of Parent JSON object into the JSON File
        JsonFileWriter.createJsonFile(formattedJson,jsonFilePath);
    }
}
