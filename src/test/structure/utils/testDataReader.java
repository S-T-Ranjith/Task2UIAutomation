package src.test.structure.utils;


import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class testDataReader {
    public static JSONObject testData() {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/test/structure/objects/testApi.json")));
            JSONObject json = new JSONObject(jsonData);
            return json;
        } catch (Exception e) {
            System.out.println("Exception testData "+ e);
            e.printStackTrace();
        }
        return null;
    }


}




