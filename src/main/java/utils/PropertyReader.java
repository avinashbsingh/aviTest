package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String confiFilePath = System.getProperty("user.dir") + "/config/configuration.properties";

    public static String readConfig(String Key) {
        String value = "";
        InputStream inputconfigFile = null;
        Properties prop = new Properties();
        try {
            inputconfigFile = new FileInputStream(confiFilePath);
            prop.load(inputconfigFile);
            value = prop.getProperty(Key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputconfigFile != null) {
                try {
                    inputconfigFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
