package pillar.com;

public class RomanNumeralConverter {

    private static final String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String convert(Integer i) {
        if (i == 0) {
            return "Nulla";
        }
        if (isOutOfRange(i)) {
            return "Failed to convert input.";
        }
        return buildBaseString(i);
    }


    private String buildBaseString(int i) {
        String output = new String();
        while (i != 0) {
            for (int j = 0; j < values.length; j++) {
                if (i >= values[j]) {
                    output += symbols[j];
                    i -= values[j];
                    break;
                }
            }
        }
        return output;
    }

    private boolean isOutOfRange(Integer i) {
        return (i < 0 || i > 3000);
    }

}
