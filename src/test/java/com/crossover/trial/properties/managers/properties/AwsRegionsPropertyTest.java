package com.crossover.trial.properties.managers.properties;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AwsRegionsPropertyTest {

    @Test
    public void testParseAwsRegionsProperty() {

        AwsRegionsProperty prop = new AwsRegionsProperty("awsRegion");

        assertEquals("awsRegion", prop.getName());

        for (String val : Arrays.asList("us-gov-west-1", "us-east-1", "us-west-1", "us-west-2", "eu-west-1", "eu-central-1", "ap-southeast-1", "ap-southeast-2", "ap-northeast-1", "ap-northeast-2", "sa-east-1", "cn-north-1")) {
            Boolean isValid = prop.parseValue(val);
            assertEquals(true, isValid);
        }

        assertEquals(false, prop.parseValue("N/A"));
    }

}