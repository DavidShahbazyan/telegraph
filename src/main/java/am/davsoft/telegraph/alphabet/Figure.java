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
public enum Figure implements Symbol {
    ZERO              ("01*101", "0"),
    ONE               ("11*101", "1"),
    TWO               ("11*001", "2"),
    THREE             ("10*000", "3"),
    FOUR              ("01*010", "4"),
    FIVE              ("00*001", "5"),
    SIX               ("10*101", "6"),
    SEVEN             ("11*100", "7"),
    EIGHT             ("01*100", "8"),
    NINE              ("00*011", "9"),
    QUESTION_MARK     ("10*011", "?"),
    COMMA             ("00*110", ","),
    FULL_STOP         ("00*111", "."),
    COLON             ("01*110", ":"),
    APOSTROPHE        ("10*100", "'"),
    LEFT_PARENTHESIS  ("11*110", "("),
    RIGHT_PARENTHESIS ("01*001", ")"),
    DASH              ("11*000", "-"),
    PLUS_SIGN         ("10*001", "+"),
    EQUALS_SIGN       ("01*111", "="),
    PERCENT           ("10*110", "%"),
    AT                ("01*011", "@"),
    SOLIDUS           ("10*111", "/"),
    POUND             ("00*101", "£"),
    BELL              ("11*010", "{BELL}"),
    WHO_ARE_YOU       ("10*010", "{WHO ARE YOU}");

    private static final Map<String, Figure> _code_values_ = Stream.of(values())
            .collect(Collectors.toMap(Figure::getCode, Function.identity()));

    private static final Map<String, Figure> _symbol_values_ = Stream.of(values())
            .collect(Collectors.toMap(Figure::getSymbol, Function.identity()));

    private final String code;
    private final String symbol;

    Figure(final String code, final String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "code='" + code + '\'' +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static Figure forCode(final String code) {
        return _code_values_.get(code);
    }

    public static Figure forSymbol(final String symbol) {
        return _symbol_values_.get(symbol);
    }
}
