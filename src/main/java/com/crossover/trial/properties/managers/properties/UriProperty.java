package com.crossover.trial.properties.managers.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * Created by alex on 1/17/2016.
 */
public class UriProperty  extends BaseProperty implements Property<URI> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UriProperty.class);

    private URI propValue;

    public UriProperty(String name) {
        super(name, URI.class, URI::create);
    }

    @Override
    public URI getValue() {
        return propValue;
    }

    @Override
    public Boolean parseValue(String value) {
        propValue=(URI)super.parseValue(value);
        return isValid();
    }

}
