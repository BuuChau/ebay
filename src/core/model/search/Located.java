package core.model.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Located implements Serializable {
    String key;
    String value;

    @Override
    public String toString() {
        return "&_salic=" + getKey();
    }

    public String getValue() {
        return value;
    }

    public Located() {

    }

    public String getKey() {
        for (Map.Entry<String, String> e : map().entrySet()) {
            if (value.equals(e.getValue()))
                return e.getKey();
        }
        return "";
    }

    public Located(String value) {

        this.value = value;
    }

    private Map<String,String> map(){
        Map<String,String> maps = new HashMap<>();
        maps.put("1","United States");
        maps.put("15","Australia");
        maps.put("2","Canada");
        maps.put("3","United Kingdom");
        maps.put("4","Afghanistan");
        maps.put("5","Albania");
        maps.put("6","Algeria");
        maps.put("7","American Samoa");
        maps.put("8","Andorra");
        maps.put("9","Angola");
        maps.put("10","Anguilla");
        maps.put("11","Antigua and Barbuda");
        maps.put("12","Argentina");
        maps.put("13","Armenia");
        maps.put("14","Aruba");
        maps.put("15","Australia");
        maps.put("16","Austria");
        maps.put("17","Azerbaijan Republic");
        maps.put("18","Bahamas");
        maps.put("19","Bahrain");
        maps.put("20","Bangladesh");
        maps.put("21","Barbados");
        maps.put("22","Belarus");
        maps.put("23","Belgium");
        maps.put("24","Belize");
        maps.put("25","Benin");
        maps.put("26","Bermuda");
        maps.put("27","Bhutan");
        maps.put("28","Bolivia");
        maps.put("29","Bosnia and Herzegovina");
        maps.put("30","Botswana");
        maps.put("31","Brazil");
        maps.put("32","British Virgin Islands");
        maps.put("33","Brunei Darussalam");
        maps.put("34","Bulgaria");
        maps.put("35","Burkina Faso");
        maps.put("36","Burma");
        maps.put("37","Burundi");
        maps.put("38","Cambodia");
        maps.put("39","Cameroon");
        maps.put("2","Canada");
        maps.put("40","Cape Verde Islands");
        maps.put("41","Cayman Islands");
        maps.put("42","Central African Republic");
        maps.put("43","Chad");
        maps.put("44","Chile");
        maps.put("45","China");
        maps.put("46","Colombia");
        maps.put("47","Comoros");
        maps.put("48","Congo, Democratic Republic of the");
        maps.put("49","Congo, Republic of the");
        maps.put("50","Cook Islands");
        maps.put("51","Costa Rica");
        maps.put("52","Cote d Ivoire (Ivory Coast)");
        maps.put("53","Croatia, Republic of");
        maps.put("55","Cyprus");
        maps.put("56","Czech Republic");
        maps.put("57","Denmark");
        maps.put("58","Djibouti");
        maps.put("59","Dominica");
        maps.put("60","Dominican Republic");
        maps.put("61","Ecuador");
        maps.put("62","Egypt");
        maps.put("63","El Salvador");
        maps.put("64","Equatorial Guinea");
        maps.put("65","Eritrea");
        maps.put("66","Estonia");
        maps.put("67","Ethiopia");
        maps.put("68","Falkland Islands (Islas Malvinas)");
        maps.put("69","Fiji");
        maps.put("70","Finland");
        maps.put("71","France");
        maps.put("72","French Guiana");
        maps.put("73","French Polynesia");
        maps.put("74","Gabon Republic");
        maps.put("75","Gambia");
        maps.put("76","Georgia");
        maps.put("77","Germany");
        maps.put("78","Ghana");
        maps.put("79","Gibraltar");
        maps.put("80","Greece");
        maps.put("81","Greenland");
        maps.put("82","Grenada");
        maps.put("83","Guadeloupe");
        maps.put("84","Guam");
        maps.put("85","Guatemala");
        maps.put("86","Guernsey");
        maps.put("87","Guinea");
        maps.put("88","Guinea-Bissau");
        maps.put("89","Guyana");
        maps.put("90","Haiti");
        maps.put("91","Honduras");
        maps.put("92","Hong Kong");
        maps.put("93","Hungary");
        maps.put("94","Iceland");
        maps.put("95","India");
        maps.put("96","Indonesia");
        maps.put("99","Ireland");
        maps.put("100","Israel");
        maps.put("101","Italy");
        maps.put("102","Jamaica");
        maps.put("104","Japan");
        maps.put("105","Jersey");
        maps.put("106","Jordan");
        maps.put("107","Kazakhstan");
        maps.put("108","Kenya");
        maps.put("109","Kiribati");
        maps.put("111","Korea, South");
        maps.put("112","Kuwait");
        maps.put("113","Kyrgyzstan");
        maps.put("114","Laos");
        maps.put("115","Latvia");
        maps.put("116","Lebanon");
        maps.put("120","Liechtenstein");
        maps.put("121","Lithuania");
        maps.put("122","Luxembourg");
        maps.put("123","Macau");
        maps.put("124","Macedonia");
        maps.put("125","Madagascar");
        maps.put("126","Malawi");
        maps.put("127","Malaysia");
        maps.put("128","Maldives");
        maps.put("129","Mali");
        maps.put("130","Malta");
        maps.put("131","Marshall Islands");
        maps.put("132","Martinique");
        maps.put("133","Mauritania");
        maps.put("134","Mauritius");
        maps.put("135","Mayotte");
        maps.put("136","Mexico");
        maps.put("226","Micronesia");
        maps.put("137","Moldova");
        maps.put("138","Monaco");
        maps.put("139","Mongolia");
        maps.put("228","Montenegro");
        maps.put("140","Montserrat");
        maps.put("141","Morocco");
        maps.put("142","Mozambique");
        maps.put("143","Namibia");
        maps.put("144","Nauru");
        maps.put("145","Nepal");
        maps.put("146","Netherlands");
        maps.put("147","Netherlands Antilles");
        maps.put("148","New Caledonia");
        maps.put("149","New Zealand");
        maps.put("150","Nicaragua");
        maps.put("151","Niger");
        maps.put("152","Nigeria");
        maps.put("153","Niue");
        maps.put("154","Norway");
        maps.put("155","Oman");
        maps.put("156","Pakistan");
        maps.put("157","Palau");
        maps.put("158","Panama");
        maps.put("159","Papua New Guinea");
        maps.put("160","Paraguay");
        maps.put("161","Peru");
        maps.put("162","Philippines");
        maps.put("163","Poland");
        maps.put("164","Portugal");
        maps.put("165","Puerto Rico");
        maps.put("166","Qatar");
        maps.put("227","Reunion");
        maps.put("167","Romania");
        maps.put("168","Russian Federation");
        maps.put("169","Rwanda");
        maps.put("170","Saint Helena");
        maps.put("171","Saint Kitts-Nevis");
        maps.put("172","Saint Lucia");
        maps.put("173","Saint Pierre and Miquelon");
        maps.put("174","Saint Vincent and the Grenadines");
        maps.put("175","San Marino");
        maps.put("176","Saudi Arabia");
        maps.put("177","Senegal");
        maps.put("229","Serbia");
        maps.put("178","Seychelles");
        maps.put("179","Sierra Leone");
        maps.put("180","Singapore");
        maps.put("181","Slovakia");
        maps.put("182","Slovenia");
        maps.put("183","Solomon Islands");
        maps.put("184","Somalia");
        maps.put("185","South Africa");
        maps.put("186","Spain");
        maps.put("187","Sri Lanka");
        maps.put("189","Suriname");
        maps.put("191","Swaziland");
        maps.put("192","Sweden");
        maps.put("193","Switzerland");
        maps.put("196","Taiwan");
        maps.put("197","Tajikistan");
        maps.put("198","Tanzania");
        maps.put("199","Thailand");
        maps.put("200","Togo");
        maps.put("201","Tonga");
        maps.put("202","Trinidad and Tobago");
        maps.put("203","Tunisia");
        maps.put("204","Turkey");
        maps.put("205","Turkmenistan");
        maps.put("206","Turks and Caicos Islands");
        maps.put("207","Tuvalu");
        maps.put("208","Uganda");
        maps.put("209","Ukraine");
        maps.put("210","United Arab Emirates");
        maps.put("3","United Kingdom");
        maps.put("211","Uruguay");
        maps.put("212","Uzbekistan");
        maps.put("213","Vanuatu");
        maps.put("214","Vatican City State");
        maps.put("215","Venezuela");
        maps.put("216","Vietnam");
        maps.put("217","Virgin Islands (U.S)");
        maps.put("218","Wallis and Futuna");
        maps.put("219","Western Sahara");
        maps.put("220","Western Samoa");
        maps.put("221","Yemen");
        maps.put("223","Zambia");
        maps.put("224","Zimbabwe");
        return maps;
    }
}
