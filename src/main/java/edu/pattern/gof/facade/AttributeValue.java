package edu.pattern.gof.facade;

import org.apache.commons.collections4.KeyValue;

/**
 * Created by Eldar on 11/9/2015.
 */
public class AttributeValue implements KeyValue<String, String> {
    private String key;
    private String value;

    public AttributeValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
