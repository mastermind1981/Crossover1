package com.crossover.trial.properties.managers.properties;


public interface Property<T> {

    String getName();

    T getValue();

    Boolean parseValue(String value);

    default Boolean isValid(){
        return getValue()!=null;
    }

    Class getSupportedType();

    default void reset() {
        parseValue(null);
    }

}
