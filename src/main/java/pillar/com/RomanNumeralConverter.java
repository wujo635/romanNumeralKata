package pillar.com;

public class RomanNumeralConverter {

    public String convert(Integer i) {
        String output = new String();
        for (int j = 0; j < i; j++) {
            output += "I";
        }
        return output;
    }

}
