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
}
