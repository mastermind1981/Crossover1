package com.crossover.trial.properties.managers.properties;

import com.amazonaws.regions.Regions;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EnumPropertyTest {

    private EnumProperty enumParser = new EnumProperty("enumProp", Regions.class);
    private AwsRegionsProperty awsRegionParser = new AwsRegionsProperty("awsProp");


    @Test
    public void testParseExistingEnumMemberQ() {
        assertTrue(enumParser.parseValue("AP_NORTHEAST_2"));
        //assertEquals(Regions.class, enumParser.());
    }

    @Test
    public void testParseExistingEnumMember() {
        assertTrue(awsRegionParser.isValidValue("us-gov-west-1"));
        assertTrue(awsRegionParser.isValidValue("us-east-1"));
        assertTrue(awsRegionParser.isValidValue("us-west-1"));
        assertTrue(awsRegionParser.isValidValue("us-west-2"));
        assertTrue(awsRegionParser.isValidValue("eu-west-1"));
        assertTrue(awsRegionParser.isValidValue("eu-central-1"));
        assertTrue(awsRegionParser.isValidValue("ap-southeast-1"));
        assertTrue(awsRegionParser.isValidValue("ap-southeast-2"));
        assertTrue(awsRegionParser.isValidValue("ap-northeast-1"));
        assertTrue(awsRegionParser.isValidValue("ap-northeast-2"));
        assertTrue(awsRegionParser.isValidValue("sa-east-1"));
        assertTrue(awsRegionParser.isValidValue("cn-north-1"));

        // assertEquals(Regions.class, awsRegionParser.ge());
    }
}