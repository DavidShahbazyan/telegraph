package am.davsoft.telegraph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 2:28 AM
 */
public class EncodeDecodeTest {
    @Test
    void shouldWorkWithoutAnyIssues() {
        String expectedString = "TEST 123 - HURAY";
        final String encodedString = Encoder.encode(expectedString);
        final String decodedString = Decoder.decode(encodedString);
        assertThat(decodedString).isNotEmpty().isEqualTo(expectedString);
    }
}
