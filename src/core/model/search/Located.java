package core.model.search;

import java.io.Serializable;

public class Located implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_salic='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public Located() {

    }

    public Located(String value) {

        this.value = value;
    }
}
