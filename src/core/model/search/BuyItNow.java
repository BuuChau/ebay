package core.model.search;

import java.io.Serializable;

public class BuyItNow implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&LH_BIN='" + key + '}';
    }

    public String getValue() {
        return value;
    }

    public BuyItNow() {

    }

    public String getKey() {
        return key;
    }

    public BuyItNow(String key, String value) {

        this.key = key;
        this.value = value;
    }
}
