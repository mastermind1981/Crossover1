package com.crossover.trial.properties.managers.properties;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by alex on 1/14/2016.
 */
public class EnumProperty extends BaseProperty implements Property<Enum> {

    private final Class<? extends Enum> enumType;
    private final Map<Enum, String> enumMembers;

    private Enum propValue;
    private String  originalValue;

    public EnumProperty(String name, Class<? extends Enum> enumType) {
        super(name, enumType, (value)->{return false;});
        this.enumType = enumType;

        enumMembers = new TreeMap<>();
        for (Enum member : enumType.getEnumConstants()) {
            enumMembers.put(member, member.name());
        }
    }

    private   boolean isValidName(String value) {
        Enum parsed = findEnumMemberByName(value);

        return parsed != null;
    }

    @Override
    public Enum getValue() {
        return propValue;
    }

    @Override
    public Boolean parseValue(String value) {

        originalValue=value;
        if(isValidName(originalValue)){
            propValue= findEnumMemberByName(value);
            return true;
        }
        else {
            propValue=null;
            return false;
        }
    }

    @Override
    public Boolean isValid() {
        return isValidName(originalValue);
    }


    private Enum findEnumMemberByName(String name) {
        for (Enum member : enumMembers.keySet()) {
            String memberName = enumMembers.get(member);
            if (StringUtils.equalsIgnoreCase(memberName, name)) {
                return member;
            }
        }
        return null;
    }



}
