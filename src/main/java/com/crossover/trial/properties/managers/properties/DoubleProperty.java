package com.crossover.trial.properties.managers.properties;

/**
 * Created by alex on 1/17/2016.
 */
public class DoubleProperty extends BaseProperty implements Property<Double> {

    private Double value;


    public DoubleProperty(String name) {
        super(name, Double.class, Double::parseDouble);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public Boolean parseValue(String val) {
        this.value = (Double) super.parseValue(val);
        return isValid();
    }
}
