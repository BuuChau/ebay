package core.model.search;

import java.io.Serializable;

public class Sold implements Serializable {

    String value;

    public String getValue() {
        return value;
    }

    public Sold() {

    }

    public Sold(String value) {

        this.value = value;
    }
}
