package core.model.search;

import java.io.Serializable;

public class Auction implements Serializable {

    String key;
    String value;
    @Override
    public String toString() {
        return "&LH_Auction='" + key + '}';
    }

    public String getValue() {
        return value;
    }

    public Auction() {

    }

    public String getKey() {
        return key;
    }

    public Auction(String key, String value) {

        this.key = key;
        this.value = value;
    }
}
