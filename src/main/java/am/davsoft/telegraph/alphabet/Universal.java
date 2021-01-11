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
public enum Universal implements Symbol {
    CARRIAGE_RETURN   ("00*010", "\n"),
    LINE_FEED         ("01*000", ""),
    SPACE             ("00*100", " ");

    private static final Map<String, Universal> _code_values_ = Stream.of(values())
            .collect(Collectors.toMap(Universal::getCode, Function.identity()));

    private static final Map<String, Universal> _symbol_values_ = Stream.of(values())
            .collect(Collectors.toMap(Universal::getSymbol, Function.identity()));

    private final String code;
    private final String symbol;

    Universal(final String code, final String symbol) {
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
        return "Universal{" +
                "code='" + code + '\'' +
                "symbol='" + symbol + '\'' +
                '}';
    }

    public static Universal forCode(final String code) {
        return _code_values_.get(code);
    }

    public static Universal forSymbol(final String symbol) {
        return _symbol_values_.get(symbol);
    }
}
