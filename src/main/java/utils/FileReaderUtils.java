package utils;

import org.bson.BsonDocument;

import java.io.File;
import java.io.FileInputStream;

public class FileReaderUtils {

    public BsonDocument readJson(String filePath) {
        String str = "";
        try {
            //Read JSON file
            File jsonFile = new File(filePath);
            FileInputStream fis = new FileInputStream(jsonFile);
            byte[] data = new byte[(int) jsonFile.length()];
            fis.read(data);
            fis.close();
            str = new String(data, "UTF-8");
        } catch (Exception e) {
            SeleniumDriver.log.info(e.getMessage());
        }
        return BsonDocument.parse(str);
    }
}
