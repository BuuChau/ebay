package core.model.search;

import java.io.Serializable;

public class Condition implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&LH_ItemCondition='" + key + '}';
    }

    public String getValue() {
        return value;
    }

    public Condition() {

    }

    public String getKey() {
        return key;
    }

    public Condition(String key, String value) {

        this.key = key;
        this.value = value;
    }
}
