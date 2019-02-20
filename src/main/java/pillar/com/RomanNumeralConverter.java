package pillar.com;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    private static final Map<Integer, String> majorUnitsMap = new HashMap<Integer, String>();
    static {
        majorUnitsMap.put(1,"I");
        majorUnitsMap.put(5,"V");
        majorUnitsMap.put(10,"X");
        majorUnitsMap.put(50,"L");
        majorUnitsMap.put(100,"C");
        majorUnitsMap.put(500,"D");
        majorUnitsMap.put(1000,"M");
    }

    public String convert(Integer i) {
        if (majorUnitsMap.containsKey(i)) {
            return majorUnitsMap.get(i);
        }
        for (int key: majorUnitsMap.keySet()) {
            if (key == i + 1) {
                return "I" + majorUnitsMap.get(key);
            }
        }
        return new String(new char[i]).replace("\0","I");
    }

}
