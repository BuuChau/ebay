package core.model.search;

import java.io.Serializable;

public class PriceFrom implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_udlo='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public PriceFrom() {

    }

    public PriceFrom(String value) {

        this.value = value;
    }
}
