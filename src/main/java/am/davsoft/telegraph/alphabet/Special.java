package am.davsoft.telegraph.alphabet;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 08, 2021
 * Time: 11:23 PM
 */
public enum Special implements Symbol {
    CHANGE_TO_LETTERS ("11*111"),
    CHANGE_TO_FIGURES ("11*011"),
    ALL_SPACE_NOT_IN_USE ("00*000");

    private static final Map<String, Special> _code_values_ = Stream.of(values())
            .collect(Collectors.toMap(Special::getCode, Function.identity()));

    private final String code;

    Special(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Special{" +
                "code='" + code + '\'' +
                '}';
    }

    public static Special forCode(final String code) {
        return _code_values_.get(code);
    }
}
