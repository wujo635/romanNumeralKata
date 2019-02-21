package pillar.com;

public class RomanNumeralConverter {

    private static final char[] symbols = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static final int[] values = new int[]{1000, 500, 100, 50, 10, 5, 1};

    public String convert(Integer i) {
        if (i == 0) {
            return "Nulla";
        }
        if (isOutOfRange(i)) {
            return "Failed to convert input.";
        }
        String baseString = buildBaseString(i);
        baseString = applySubtraction(baseString);
        baseString = condenseString(baseString);
        return baseString;
    }

    private String condenseString(String baseString) {
        for (int j = 0; j < symbols.length; j++) {
            if (j % 2 == 1) {
                String twoOfNumeral = new String(new char[2]).replace("\0", Character.toString(symbols[j]));
                if (baseString.contains(twoOfNumeral) && j != symbols.length - 1) {
                    int pos1 = baseString.indexOf(symbols[j]);
                    baseString = baseString.substring(0, pos1) + symbols[j - 1] + baseString.substring(pos1);
                    baseString = baseString.replace(twoOfNumeral, "");
                }
            }
        }
        return baseString;
    }

    private String applySubtraction(String baseString) {
        for (int j = 0; j < symbols.length; j++) {
            String fourOfNumeral = new String(new char[4]).replace("\0", Character.toString(symbols[j]));
            if (baseString.contains(fourOfNumeral)) {
                int pos1 = baseString.indexOf(symbols[j]);
                baseString = symbols[j] + baseString.substring(0, pos1) + symbols[j - 1] + baseString.substring(pos1);
                baseString = baseString.replace(fourOfNumeral, "");
            }
        }
        return baseString;
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
