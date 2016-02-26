package com.crossover.trial.properties.managers.properties;

import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by alex on 1/16/2016.
 */
public class BooleanProperty extends BaseProperty implements Property<Boolean> {

    private Boolean value;


    public BooleanProperty(String name) {
        super(name, Boolean.class, BooleanUtils::toBooleanObject);
    }

    @Override
    public Boolean parseValue(String val) {
        value= (Boolean) super.parseValue(val);
        return isValid();
    }


    @Override
    public Boolean getValue() {
        return value;
    }


}
