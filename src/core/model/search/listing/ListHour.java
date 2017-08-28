package core.model.search.listing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ListHour implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&_ftrv=" + getKey();
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

    public ListHour() {

    }

    public ListHour(String value) {

        this.value = value;
    }
    private Map<String,String> maps(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1 hour");
        map.put("2","2 hours");
        map.put("3","3 hours");
        map.put("4","4 hours");
        map.put("5","5 hours");
        map.put("12","12 hours");
        map.put("24","24 hours");
        map.put("48","2 days");
        map.put("72","3 days");
        map.put("96","4 days");
        map.put("120","5 days");
        map.put("144","6 days");
        map.put("168","7 days");
        return map;
    }
}
