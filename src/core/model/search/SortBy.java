package core.model.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SortBy implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&_sop=" + getKey();
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        for (Map.Entry<String, String> e : maps().entrySet()) {
            if (value.equals(e.getValue()))
                return e.getKey();
        }
        return "";
    }

    public SortBy() {

    }

    public SortBy(String value) {

        this.value = value;
    }

    private Map<String,String> maps(){
        Map<String,String> maps = new HashMap<>();
        maps.put("12","Best Match");
        maps.put("1","Time: ending soonest");
        maps.put("10","Time: newly listed");
        maps.put("15","Price + Shipping: lowest first");
        maps.put("16","Price + Shipping: highest first");
        maps.put("3","Price: highest first");
        return maps;
    }
}
