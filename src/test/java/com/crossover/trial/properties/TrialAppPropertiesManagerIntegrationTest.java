package com.crossover.trial.properties;

import com.crossover.trial.properties.managers.JsonParser;
import com.crossover.trial.properties.managers.PropertiesLoader;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TrialAppPropertiesManagerIntegrationTest {

    private JsonParser parser=new JsonParser();

    @Test
    public void testLoadClassPathPropertyFile(){
        TrialAppPropertiesManager manager=new TrialAppPropertiesManager(new PropertiesLoader(parser));

        AppProperties appProps = manager.loadProps(Arrays.asList("classpath:resources/jdbc.properties"));

        assertNotNull(appProps);
        assertEquals(17,appProps.getKnownProperties().size());
        assertEquals(12,appProps.getMissingProperties().size());

        manager.printProperties(appProps,System.out);
    }

    @Test
    public void testLoadClassPathFileUri() throws URISyntaxException {
        TrialAppPropertiesManager manager=new TrialAppPropertiesManager(new PropertiesLoader(parser));

        URI uri = this.getClass().getResource("/config.json").toURI();

        AppProperties appProps = manager.loadProps(Arrays.asList(uri.toString()));

        assertNotNull(appProps);
        assertEquals(17,appProps.getKnownProperties().size());
        System.out.println(appProps.getMissingProperties());
        assertEquals(12,appProps.getMissingProperties().size());

        manager.printProperties(appProps,System.out);
    }

}