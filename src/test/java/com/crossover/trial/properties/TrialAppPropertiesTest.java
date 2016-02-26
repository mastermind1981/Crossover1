package com.crossover.trial.properties;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrialAppPropertiesTest {

    private static String jpa_showsql_prop_name = "JPA_SHOWSQL";
    private static String jpa_showsql_prop_name_withDot = "JPA.SHOWSQL";
    Map<String, String> data;
    private TrialAppProperties appProperties;

    @Before
    public void setUp() throws Exception {

        data = new HashMap<>();
        data.put(jpa_showsql_prop_name, "true");
        data.put("score_factor", "2.4");

        appProperties = new TrialAppProperties(data);
    }

    @Test
    public void testInitializeWithWrongValue() {
        data.put(jpa_showsql_prop_name, "false");

        appProperties = new TrialAppProperties(data);

        assertNull(appProperties.get(jpa_showsql_prop_name));
        assertEquals(16, appProperties.getMissingProperties().size());
    }

    @Test
    public void testPropertyAccessor() {
        assertEquals(true, appProperties.get(jpa_showsql_prop_name));
        assertEquals(true, appProperties.get(jpa_showsql_prop_name.toLowerCase()));
        assertEquals(true, appProperties.get(jpa_showsql_prop_name_withDot));
        assertEquals(true, appProperties.get(jpa_showsql_prop_name_withDot.toLowerCase()));

        assertEquals((double) 2.4, appProperties.get("score_factor"));
    }

    @Test
    public void testReset() {
        assertEquals(15, appProperties.getMissingProperties().size());
        appProperties.clear();
        assertEquals(17, appProperties.getMissingProperties().size());
    }
}