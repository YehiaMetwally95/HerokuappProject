package utils;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    public static void createJsonFile(String jsonString , String jsonFilePath) throws IOException {
        FileWriter file = new FileWriter(jsonFilePath);
        file.write(jsonString);
        file.close();
    }
}
