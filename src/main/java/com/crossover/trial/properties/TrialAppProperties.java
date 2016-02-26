package com.crossover.trial.properties;

import com.crossover.trial.properties.managers.properties.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A dummy implementation of TrialAppProperties, this clearly doesn't work. Candidates SHOULD change
 * this class to add their implementation. You are also free to create additional classes
 * <p>
 * note: a default constructor is required.
 *
 * @author code test administrator
 */
public class TrialAppProperties implements AppProperties {

    private final Set<Property> knownProperties;

    public TrialAppProperties() {
        this(new HashMap<>());
    }

    public TrialAppProperties(Map<String, String> data) {
        knownProperties = new HashSet<>();

        knownProperties.add(new StringProperty("jdbc_driver"));
        knownProperties.add(new StringProperty("jdbc_url"));
        knownProperties.add(new StringProperty("jdbc_username"));
        knownProperties.add(new StringProperty("jdbc_password"));
        knownProperties.add(new BooleanProperty("hibernate_generate_statistics"));
        knownProperties.add(new BooleanProperty("hibernate_show_sql"));
        knownProperties.add(new BooleanProperty("jpa_showsql"));

        knownProperties.add(new StringProperty("aws_access_key"));
        knownProperties.add(new StringProperty("aws_secret_key"));
        knownProperties.add(new IntegerProperty("aws_account_id"));//10
        knownProperties.add(new StringProperty("aws_region_id"));

        knownProperties.add(new UriProperty("auth_endpoint_uri"));
        knownProperties.add(new IntegerProperty("job_timeout"));
        knownProperties.add(new IntegerProperty("job_maxretry"));
        knownProperties.add(new StringProperty("sns_broadcast_topic_name")); //15
        knownProperties.add(new IntegerProperty("sns_broadcast_visibility_timeout"));
        knownProperties.add(new DoubleProperty("score_factor"));


        for (String propertyName : data.keySet()) {
            Optional<Property> propOption = findByName(propertyName);
            if (propOption.isPresent()) {
                final String value = data.get(propertyName);
                propOption.get().parseValue(value);
            }
        }
    }

    private Optional<Property> findByName(String propertyName) {
        String normalizedName = StringUtils.trim(propertyName).toLowerCase().replace('.', '_');
        return knownProperties.stream().filter(p -> StringUtils.equalsIgnoreCase(normalizedName, p.getName())).findFirst();
    }

    @Override
    public List<String> getMissingProperties() {
        return knownProperties.stream().filter(p -> !p.isValid()).map(Property::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getKnownProperties() {
        return knownProperties.stream().map(Property::getName).collect(Collectors.toList());
    }

    @Override
    public boolean isValid() {
        Optional<Property> notValidProp = knownProperties.stream().filter(p -> !p.isValid()).findFirst();
        return !notValidProp.isPresent();
    }

    @Override
    public void clear() {
        knownProperties.forEach(com.crossover.trial.properties.managers.properties.Property::reset);
    }

    @Override
    public Object get(String key) {
        Optional<Property> prop = findByName(key);
        if (prop.isPresent()) {
            return prop.get().getValue();
        }

        return null;
    }

    @Override
    public String toString() {
        List<Property> sortedProps = knownProperties.stream().sorted((x, y) -> String.CASE_INSENSITIVE_ORDER.compare(x.getName(), y.getName())).collect(Collectors.toList());

        StringBuilder sb=new StringBuilder();
        for(Property p:sortedProps){
            sb.append(String.format("%s, %s, %s\n", p.getName(), p.getSupportedType().getName(), p.getValue()));
        }

        return sb.toString();
    }
}

