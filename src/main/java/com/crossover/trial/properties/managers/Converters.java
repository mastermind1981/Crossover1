package com.crossover.trial.properties.managers;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class Converters {

    public static final String PROPERTIES = "properties";
    public static final String JSON = "json";

    private static Properties convertJsonStringToProperties(String json) {
        //todo
        return null;//new JSONObject(json);
    }

    private static Properties convertStringToProperties(String properties) throws IOException {
        final Properties p = new Properties();
        p.load(new StringReader(properties));
        return p;
    }

    public static Properties convertToProperties(String text) {
        if (text.endsWith(PROPERTIES)) {
            try {
                return convertStringToProperties(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (text.endsWith(JSON)) {
            return convertJsonStringToProperties(text);
        } else {
            throw new RuntimeException("unsupported file");
        }
    }
}
