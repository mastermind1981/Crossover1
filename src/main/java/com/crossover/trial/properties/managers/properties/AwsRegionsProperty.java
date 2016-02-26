package com.crossover.trial.properties.managers.properties;

import com.amazonaws.regions.Regions;

public class AwsRegionsProperty extends BaseProperty implements Property<Regions> {

    private Regions propValue;

    public AwsRegionsProperty(String name) {
        super(name, Regions.class, Regions::fromName);
    }

    @Override
    public Boolean parseValue(String value) {
        propValue = (Regions) super.parseValue(value);
        return isValid();
    }

    @Override
    public Regions getValue() {
        return propValue;
    }

}
