package pillar.com;

public class RomanNumeralConverter {

    public String convert(Integer i) {
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
