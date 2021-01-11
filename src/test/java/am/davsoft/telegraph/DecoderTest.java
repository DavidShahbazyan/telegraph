package am.davsoft.telegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 1:58 AM
 */
class DecoderTest {

    @Test
    void decode_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Decoder.decode("00*001,10*000,10*100,00*001"));
        assertThrows(IllegalArgumentException.class, () -> Decoder.decode("11**11"));
    }

    @Test
    void decode_NoIssues() {
        assertThat(Decoder.decode("11*111,00*001,10*000,10*100,00*001")).isNotEmpty().isEqualTo("TEST");
        assertThat(Decoder.decode("11*111,00*001,10*000,10*100,00*001,00*100,11*011,11*101,11*001,10*000")).isNotEmpty().isEqualTo("TEST 123");
    }
}