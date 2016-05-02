package edu.pattern.gof.facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Eldar on 11/9/2015.
 */
public class MessageHeader {
    private Map<String, String> properties = new HashMap<>();

    public void setFrom(String from){
        properties.put("from", from);
    }

    public void setTo(String to){
        properties.put("to", to);
    }

    public void setSubject(String subject){
        properties.put("subject", subject);
    }

    public void setProperty(String name, String value){
        properties.put(name, value);
    }
    public String getProperty(String name){
        return properties.get(name);
    }

    @Override
    public String toString() {
        return "MessageHeader{" +
                "properties=" + properties +
                '}';
    }
}
