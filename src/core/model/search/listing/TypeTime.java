package core.model.search.listing;

import java.io.Serializable;

public class TypeTime implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_ftrt='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public TypeTime() {

    }

    public TypeTime(String value) {

        this.value = value;
    }
}
