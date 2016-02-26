package com.crossover.trial.properties.managers.properties;

/**
 * Created by alex on 1/16/2016.
 */
public interface Property<T> {

    String getName();

    T getValue();

    Boolean parseValue(String value);

    default Boolean isValid(){
        return getValue()!=null;
    }

    public Class getSupportedType();

    default void reset() {
        parseValue(null);
    }

}
