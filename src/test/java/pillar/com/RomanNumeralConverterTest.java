package pillar.com;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void shouldConvert1toI() {
        assertEquals("I", converter.convert(1));
    }

    @Test
    public void shouldConvert2toII() {
        assertEquals("II", converter.convert(2));
    }

    @Test
    public void shouldConvert5toV() {
        assertEquals("V", converter.convert(5));
    }

    @Test
    public void shouldConvert4toIV() {
        assertEquals("IV", converter.convert(4));
    }

    @Test
    public void shouldConvert10toX() {
        assertEquals("X", converter.convert(10));
    }

    @Test
    public void shouldConvert9toIX() {
        assertEquals("IX", converter.convert(9));
    }

    @Test
    public void shouldConvertMajorUnitsToSingleRomanNumeral() {
        assertEquals("I", converter.convert(1));
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
        assertEquals("L", converter.convert(50));
        assertEquals("C", converter.convert(100));
        assertEquals("D", converter.convert(500));
        assertEquals("M", converter.convert(1000));
    }

    @Test
    public void shouldReturnNullaWhenConvertingZero() {
        assertEquals("Nulla", converter.convert(0));
    }

    @Test
    public void shouldDisallowNegativeInput() {
        assertEquals("Failed to convert input.", converter.convert(-1));
    }

    @Test
    public void shouldDisallowInputGreaterThan3000() {
        assertEquals("Failed to convert input.", converter.convert(3001));
    }
}
