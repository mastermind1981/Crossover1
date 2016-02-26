package com.crossover.trial.properties.managers.properties;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoolenPropertyTest {

    @Test
    public void testParseBoolProperty() throws Exception {

        Property<Boolean> boolProp = new BooleanProperty("test");

        boolProp.parseValue("true");

        assertEquals("test", boolProp.getName());
        assertEquals(true, boolProp.getValue());
        assertEquals(true, boolProp.isValid());

        boolProp.reset();
        assertEquals(false, boolProp.isValid());
        assertEquals(null, boolProp.getValue());
    }

}