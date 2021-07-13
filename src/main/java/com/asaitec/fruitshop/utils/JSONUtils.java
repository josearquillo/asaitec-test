package com.asaitec.fruitshop.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

    public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get("src", "main", "resources", filename)));
        return new JSONObject(content);
    }
    
    public static void writeJSONToFile(JSONObject obj, String filename) throws IOException {
    	final FileWriter outputFile = new FileWriter(filename);
    	outputFile.write(obj.toString());
        outputFile.close();
        
    }
}
