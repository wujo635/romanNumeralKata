package pillar.com;

public class RomanNumeralConverter {

    public String convert(Integer i) {
        String output = new String();
        if (i == 5){
            return "V";
        }
        for (int j = 0; j < i; j++) {
            output += "I";
        }
        return output;
    }

}
