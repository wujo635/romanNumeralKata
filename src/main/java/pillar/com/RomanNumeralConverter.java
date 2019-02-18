package pillar.com;

public class RomanNumeralConverter {

    public String convert(Integer i) {
        String output = new String();
        int fives = i / 5;
        int notFive = i % 5;
        for (int j = 0; j < fives; j++) {
            output += "V";
        }
        if (notFive == 4) {
            output = "IV";
        } else {
            for (int j = 0; j < notFive; j++) {
                output += "I";
            }
        }
        return output;
    }

}
