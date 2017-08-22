package core.model.search;

import java.io.Serializable;

public class SortBy implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_sop='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public SortBy() {

    }

    public SortBy(String value) {

        this.value = value;
    }
}
