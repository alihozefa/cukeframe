package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {

    private static FileInputStream fis;
    private static final Properties properties = new Properties();

    //private constructor to avoid project to use constructor
    private ProjectConfig() {

    }

    public static Properties getConfig() {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }


}
