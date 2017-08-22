package core.model.search;

import java.io.Serializable;

public class ExcludeWords implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_ex_kw='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public ExcludeWords() {

    }

    public ExcludeWords(String value) {

        this.value = value;
    }
}
