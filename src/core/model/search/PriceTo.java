package core.model.search;

import java.io.Serializable;

public class PriceTo implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_udhi=" + value;
    }

    public String getValue() {
        return value;
    }

    public PriceTo() {

    }

    public PriceTo(String value) {

        this.value = value;
    }
}
