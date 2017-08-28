package core.model.search;

import java.io.Serializable;

public class Shipping implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&LH_FS=" + value;
    }

    public String getValue() {
        return value;
    }

    public Shipping() {

    }

    public Shipping(String value) {

        this.value = value;
    }
}
