package am.davsoft.telegraph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 2:24 AM
 */
class EncoderTest {

    @Test
    void encode() {
        assertThat(Encoder.encode("TEST")).isNotEmpty().isEqualToIgnoringWhitespace("11*111,00*001,10*000,10*100,00*001");
        assertThat(Encoder.encode("TEST 123")).isNotEmpty().isEqualToIgnoringWhitespace("11*111,00*001,10*000,10*100,00*001,00*100,11*011,11*101,11*001,10*000");
    }
}