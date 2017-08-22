package core.model.search.listing;

import java.io.Serializable;

public class ListHour implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_ftrt='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public ListHour() {

    }

    public ListHour(String value) {

        this.value = value;
    }
}
