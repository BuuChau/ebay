package core.model.search;

public class KeywordOptions {

    String value;

    @Override
    public String toString() {
        return "&_in_kw='" + value + '}';
    }

    public String getValue() {
        return value;
    }

    public KeywordOptions() {

    }

    public KeywordOptions(String value) {

        this.value = value;
    }
}
