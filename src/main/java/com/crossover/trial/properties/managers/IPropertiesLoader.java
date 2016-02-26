package com.crossover.trial.properties.managers;

import java.util.Properties;

public interface IPropertiesLoader {

    /**
     * Load resource by URI or classpath:/ path
     *
     * @param resource
     * @return
     */
    Properties loadResource(String resource);
}
