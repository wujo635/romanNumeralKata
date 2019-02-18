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
        String output = new String();
        int countdown = i;
        while (countdown >= 9) {
            if (countdown == 9) {
                output += "IX";
                countdown -= 9;
            } else {
                output += "X";
                countdown -= 10;
            }
        }
        while (countdown >= 4) {
            if (countdown == 4) {
                output += "IV";
                countdown -= 4;
            } else {
                output += "V";
                countdown -= 5;
            }
        }
        while (countdown > 0) {
            output += "I";
            countdown--;
        }
        return output;
    }

}
