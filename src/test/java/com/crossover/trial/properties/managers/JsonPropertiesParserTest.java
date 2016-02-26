package com.crossover.trial.properties.managers;

import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonPropertiesParserTest {

    @Test
    public void testParse() throws Exception {
        InputStream ins = this.getClass().getResourceAsStream("/config.json");

        JsonParser parser=new JsonParser();
        Map<String, String> pairs = parser.parse(ins);

        assertNotNull(pairs);
        assertTrue(pairs.containsKey("auth.endpoint.uri"));
        assertTrue(pairs.containsKey("job.timeout"));
        assertTrue(pairs.containsKey("sns.broadcast.topic_name"));
        assertTrue(pairs.containsKey("score.factor"));
        assertTrue(pairs.containsKey("jpa.showSql"));
    }
}