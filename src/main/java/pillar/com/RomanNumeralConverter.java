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
        String romanString = buildBaseString(i);
        romanString = applySubtraction(romanString);
        romanString = condenseString(romanString);
        return romanString;
    }

    private String condenseString(String romanString) {
        for (int j = 0; j < symbols.length; j++) {
            if (j % 2 == 1) {
                String twoOfNumeral = new String(new char[2]).replace("\0", Character.toString(symbols[j]));
                if (romanString.contains(twoOfNumeral) && j != symbols.length - 1) {
                    int pos1 = romanString.indexOf(symbols[j]);
                    romanString = romanString.substring(0, pos1) + symbols[j - 1] + romanString.substring(pos1);
                    romanString = romanString.replace(twoOfNumeral, "");
                }
            }
        }
        return romanString;
    }

    private String applySubtraction(String romanString) {
        for (int j = 0; j < symbols.length; j++) {
            String fourOfNumeral = new String(new char[4]).replace("\0", Character.toString(symbols[j]));
            if (romanString.contains(fourOfNumeral)) {
                int pos1 = romanString.indexOf(symbols[j]);
                romanString = romanString.substring(0, pos1) + symbols[j] + symbols[j - 1] + romanString.substring(pos1);
                romanString = romanString.replace(fourOfNumeral, "");
            }
        }
        return rearrange(romanString);
    }

    private String rearrange(String romanString) {
        for (int j = 0; j < romanString.length() - 2; j++) {
            if (romanString.charAt(j) == romanString.charAt(j + 2)) {
                char c = romanString.charAt(j);
                char d = romanString.charAt(j+1);
                romanString = romanString.substring(0,j) + d + c + romanString.substring(j+2);
            }
        }
        return romanString;
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
