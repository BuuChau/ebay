package core.model.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Category implements Serializable {

    String key;
    String value;

    @Override
    public String toString() {
        return "&_ex_kw=" + getKey();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Category() {

    }

    public String getKey() {
        for (Map.Entry<String, String> e : stringMap().entrySet()) {
            if (value.equals(e.getValue()))
                return e.getKey();
        }
        return "";
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Category(String value) {

        this.value = value;
    }

    public Map<String,String> stringMap(){
        Map<String,String> maps = new HashMap<>();
        maps.put("0","All Categories");
        maps.put("20081","Antiques");
        maps.put("550","Art");
        maps.put("2984","Baby");
        maps.put("267","Books");
        maps.put("12576","Business &amp; Industrial");
        maps.put("625","Cameras &amp; Photo");
        maps.put("15032","Cell Phones &amp; Accessories");
        maps.put("11450","Clothing, Shoes &amp; Accessories");
        maps.put("11116","Coins &amp; Paper Money");
        maps.put("1","Collectibles");
        maps.put("58058","Computers/Tablets &amp; Networking");
        maps.put("293","Consumer Electronics");
        maps.put("14339","Crafts");
        maps.put("237","Dolls &amp; Bears");
        maps.put("11232","DVDs &amp; Movies");
        maps.put("6000","eBay Motors");
        maps.put("45100","Entertainment Memorabilia");
        maps.put("172008","Gift Cards &amp; Coupons");
        maps.put("26395","Health &amp; Beauty");
        maps.put("11700","Home &amp; Garden");
        maps.put("281","Jewelry &amp; Watches");
        maps.put("11233","Music");
        maps.put("619","Musical Instruments &amp; Gear");
        maps.put("1281","Pet Supplies");
        maps.put("870","Pottery &amp; Glass");
        maps.put("10542","Real Estate");
        maps.put("316","Specialty Services");
        maps.put("888","Sporting Goods");
        maps.put("64482","Sports Mem, Cards &amp; Fan Shop");
        maps.put("260","Stamps");
        maps.put("1305","Tickets &amp; Experiences");
        maps.put("220","Toys &amp; Hobbies");
        maps.put("3252","Travel");
        maps.put("1249","Video Games &amp; Consoles");
        maps.put("99","Everything Else");
        return maps;
    }
}
