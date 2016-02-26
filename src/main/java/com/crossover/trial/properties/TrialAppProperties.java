package com.crossover.trial.properties;

import java.util.Collections;
import java.util.List;

/**
 * A dummy implementation of TrialAppProperties, this clearly doesn't work. Candidates SHOULD change
 * this class to add their implementation. You are also free to create additional classes
 * <p>
 * note: a default constructor is required.
 *
 * @author code test administrator
 */
public class TrialAppProperties implements AppProperties {

    private List<String> propertiesList;

    public TrialAppProperties(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }

    public List<String> getMissingProperties() {
        return Collections.emptyList();
    }

    public List<String> getKnownProperties() {
        return Collections.emptyList();
    }

    public boolean isValid() {
        return true;
    }

    public void clear() {
        propertiesList.clear();
    }

    public Object get(String key) {
        return "dummy";
    }
}

