package com.crossover.trial.properties;

import com.crossover.trial.properties.managers.IPropertiesLoader;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * A simple main method to load and print properties. You should feel free to change this class
 * or to create additional class. You may add addtional methods, but must implement the
 * AppPropertiesManager API contract.
 * <p>
 * Note: a default constructor is required
 *
 * @author code test administrator
 */
public class TrialAppPropertiesManager implements AppPropertiesManager {

    private final IPropertiesLoader loader;

    public TrialAppPropertiesManager(IPropertiesLoader loader) {
        this.loader = loader;
    }

    @Override
    public AppProperties loadProps(List<String> propUris) {
        HashMap<String, String> map = new HashMap<>();
        for (String uri : propUris) {
            Properties props = loader.loadResource(uri);
            getMapOfValues(map, props);
        }

        return new TrialAppProperties(map);
    }

    @Override
    public void printProperties(AppProperties props, PrintStream sync) {
        sync.println(props);
    }


    /* private methods */

    private void getMapOfValues(HashMap<String, String> map, Properties props) {
        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);
            map.put(key, value);
        }
    }
}
