package core.model.search;

import java.io.Serializable;

public class Keywords implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_nkw=" + value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Keywords() {
    }

    public Keywords(String value) {

        this.value = value;
    }
}
