package core.model.search;

import java.io.Serializable;

public class PageSize implements Serializable {

    String value;

    @Override
    public String toString() {
        return "&_ipg=" + value;
    }

    public String getValue() {
        return value;
    }

    public PageSize() {

    }

    public PageSize(String value) {

        this.value = value;
    }
}
