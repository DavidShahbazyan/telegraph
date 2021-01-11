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
public enum Letter implements Symbol {
    A                    ("11*000", "A"),
    B                    ("10*011", "B"),
    C                    ("01*110", "C"),
    D                    ("10*010", "D"),
    E                    ("10*000", "E"),
    F                    ("10*110", "F"),
    G                    ("01*011", "G"),
    H                    ("00*101", "H"),
    I                    ("01*100", "I"),
    J                    ("11*010", "J"),
    K                    ("11*110", "K"),
    L                    ("01*001", "L"),
    M                    ("00*111", "M"),
    N                    ("00*110", "N"),
    O                    ("00*011", "O"),
    P                    ("01*101", "P"),
    Q                    ("11*101", "Q"),
    R                    ("01*010", "R"),
    S                    ("10*100", "S"),
    T                    ("00*001", "T"),
    U                    ("11*100", "U"),
    V                    ("01*111", "V"),
    W                    ("11*001", "W"),
    X                    ("10*111", "X"),
    Y                    ("10*101", "Y"),
    Z                    ("10*001", "Z");

    private static final Map<String, Letter> _code_values_ = Stream.of(values())
            .collect(Collectors.toMap(Letter::getCode, Function.identity()));

    private static final Map<String, Letter> _symbol_values_ = Stream.of(values())
            .collect(Collectors.toMap(Letter::getSymbol, Function.identity()));

    private final String code;
    private final String symbol;

    Letter(final String code, final String symbol) {
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
        return "Letter{" +
                "code='" + code + '\'' +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static Letter forCode(final String code) {
        return _code_values_.get(code);
    }

    public static Letter forSymbol(final String symbol) {
        return _symbol_values_.get(symbol);
    }
}
