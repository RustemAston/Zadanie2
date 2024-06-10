package simple_rest.Util;

import java.io.InputStream;
import java.util.Properties;

public class propertiesFile {
    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTIES_FILE = "database.properties";

    public propertiesFile() {
    }

    static {
        getProperties();
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void getProperties() {
        try (InputStream inFile = propertiesFile.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            PROPERTIES.load(inFile);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}