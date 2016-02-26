package com.crossover.trial.properties.managers.properties;


public class IntegerProperty extends BaseProperty implements Property<Integer> {

    private Integer value;

    public IntegerProperty(String name) {
        super(name, Integer.class, Integer::parseInt);
    }

    @Override
    public Integer getValue() {
        return value;
    }


    @Override
    public Boolean parseValue(String val) {

        this.value = (Integer) super.parseValue(val);
        return isValid();

    }


}
