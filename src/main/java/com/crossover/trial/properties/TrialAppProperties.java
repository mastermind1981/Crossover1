package com.crossover.trial.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A dummy implementation of TrialAppProperties, this clearly doesn't work. Candidates SHOULD change
 * this class to add their implementation. You are also free to create additional classes
 * <p>
 * note: a default constructor is required.
 *
 * @author code test administrator
 */
public class TrialAppProperties implements AppProperties {

    private final Map<String, String> defaultProperties = new HashMap<>();
    private String[] keysProperties = new String[]{"jdbc_driver", "jdbc_url", "jdbc_username", "jdbc_password", "hibernate_generate_statistics",
            "hibernate_show_sql", "jpa_showsql", "aws_access_key", "aws_secret_key", "aws_account_id", "aws_region_id", "auth_endpoint_uri",
            "job_timeout", "job_maxretr", "sns_broadcast_topic_name", "sns_broadcast_visibility_timeout", "score_factor"};

    public TrialAppProperties(Map<String, String> data) {
        Stream.of(keysProperties).forEach(s -> {
            setDefaultProperty(s, data);
        });
    }

    private void setDefaultProperty(String propertyName, Map<String, String> data) {
        defaultProperties.put(propertyName, data.get(propertyName));
    }

    @Override
    public List<String> getMissingProperties() {
        return defaultProperties.entrySet().stream().filter(entry -> entry.getValue() == null).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Override
    public List<String> getKnownProperties() {
        return defaultProperties.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Override
    public boolean isValid() {
        return defaultProperties.entrySet().stream().noneMatch(entry -> entry.getValue() == null);
    }

    @Override
    public void clear() {
        defaultProperties.entrySet().forEach(entry -> entry.setValue(null));
    }

    @Override
    public Object get(String key) {
        //todo
       /* Optional<Property> prop = setDefaultProperty(key);
        if (prop.isPresent()) {
            return prop.get().getValue();
        }

        */
        return null;
    }

    @Override
    public String toString() {
        Set<Map.Entry<String, String>> sortedProps = defaultProperties.entrySet()
                .stream().sorted((x, y) -> String.CASE_INSENSITIVE_ORDER.compare(x.getKey(), y.getKey())).collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> stringStringEntry : sortedProps) {
            sb.append(String.format("%s, %s\n", stringStringEntry.getKey(), stringStringEntry.getValue()));
        }

        return sb.toString();
    }
}

