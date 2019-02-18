package pillar.com;

import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void shouldConvert1toI() {
        assertEquals("I", converter.convert(1));
    }
}
