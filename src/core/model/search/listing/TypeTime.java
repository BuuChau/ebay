package core.model.search.listing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TypeTime implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&_ftrt=" + getKey();
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        for (Map.Entry<String, String> e : maps().entrySet()) {
            if (value.equals(e.getValue()))
                return key;
        }
        return "";
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TypeTime() {

    }

    public TypeTime(String value) {

        this.value = value;
    }

    private Map<String,String> maps(){
        Map<String,String> map = new HashMap<>();
        map.put("901","Ending within");
        map.put("902","Ending in more than");
        map.put("903","Started within");
        return map;
    }
}
