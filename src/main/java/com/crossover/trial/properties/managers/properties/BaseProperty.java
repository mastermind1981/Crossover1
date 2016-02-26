package com.crossover.trial.properties.managers.properties;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.function.Function;

public abstract  class BaseProperty {

    private final String name;
    private final Class supportedType;
    private final Function<String,Object> parseFunction;

    private String stringValue;

    public BaseProperty(String name, Class supportedType, Function<String, Object> parseFunction) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(supportedType);
        Preconditions.checkNotNull(parseFunction);

        this.name = name;
        this.supportedType = supportedType;
        this.parseFunction = parseFunction;
    }


    public String getName() {
        return name;
    }

    public Class getSupportedType() {
        return supportedType;
    }

    public abstract Object getValue();

    public boolean isValidValue(String value){
        try{
            value=StringUtils.trim(value);
            parseFunction.apply(value);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public Object parseValue(String val) {
        val=StringUtils.trim(val);

        stringValue = val;
        if (isValidValue(val)) {
            return parseFunction.apply(stringValue);
        } else {
            return null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BooleanProperty)) return false;

        BooleanProperty that = (BooleanProperty) o;

        return new EqualsBuilder()
                .append(getSupportedType(), that.getSupportedType())
                .append(getName(), that.getName())
                .append(getValue(), that.getValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSupportedType())
                .append(getName())
                .toHashCode();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
        //return String.format("%s, %s, %s",getName(),supportedType.getName(),getValue());
    }


}
