package json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> result = new LinkedHashMap();

        result.put("san", 1);
        result.put("adb", 2);
        result.put("zdre", 3);
        result.put("ban", 4);

        for(String key : result.keySet()){
            System.out.println(result.get(key));
        }

        System.out.println("------------");

        result.forEach((e, v) -> System.out.println(e +"," +v));
    }
}
