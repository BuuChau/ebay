package core.common;

import java.io.Serializable;

/**
 * Created by phuoclt on 8/29/17.
 */
public class InitSearchUrl implements Serializable {

    public static String url = null;

    public static void reset(){
        url = null;
    }

    public static String searchWithUrl(String located){
        StringBuffer buffer = new StringBuffer();

        String[] strings = url.split("&");
        if (url.contains("&_salic=")) {
            for (String str : strings){
                if (str.contains("&_salic="))
                    buffer.append(located);
                else if (str.equals(strings[0]))
                    buffer.append(str);
                else
                    buffer.append("&"+str);
            }
        }
        else
            buffer.append(url).append(located);
        return buffer.toString();
    }
}
