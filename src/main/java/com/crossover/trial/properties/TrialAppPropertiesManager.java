package com.crossover.trial.properties;

import com.crossover.trial.properties.managers.loaders.BaseLoader;
import com.crossover.trial.properties.managers.loaders.LoaderFactory;

import java.io.PrintStream;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

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

    public AppProperties loadProps(List<String> propUris) {

        List<Properties> properties = propUris.stream()
                .map(LoaderFactory::getLoader)
                .map(BaseLoader::loadProperties)
                .collect(Collectors.toList());
        return new TrialAppProperties(null);
    }

    public void printProperties(AppProperties props, PrintStream sync) {
        sync.println(props);
    }
}
