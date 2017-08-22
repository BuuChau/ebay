package core.model.search;

import java.io.Serializable;

public class Category implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_ex_kw='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public Category() {

    }

    public Category(String value) {

        this.value = value;
    }
}
