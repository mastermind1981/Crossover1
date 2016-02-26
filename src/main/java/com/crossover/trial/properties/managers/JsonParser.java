package com.crossover.trial.properties.managers;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import org.apache.commons.io.IOUtils;

import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    public Map<String, String> parse(InputStream ins) throws IOException, ScriptException, JSONException {

        String text = IOUtils.toString(ins);
        JSONObject jso = new JSONObject(text);

        HashMap<String, String> map = new HashMap<>();

        for (int index = 0; index < jso.length(); index++) {
            String key = jso.names().getString(index);
            String value = jso.getString(key);
            map.put(key, value);
        }
        return map;
    }
}
