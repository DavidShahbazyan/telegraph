package am.davsoft.telegraph;

import am.davsoft.telegraph.alphabet.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 12:44 AM
 */
public class Encoder {
    public static String encode(final String str) {
        final String[] chars = str.split("(?!^)");
        List<Symbol> symbols = new ArrayList<>();
        if (chars.length > 0) {
            SymbolType previousSymbolType = null;
            SymbolType currentSymbolType = null;
            for (String aChar : chars) {
                aChar = aChar.toUpperCase();
                Symbol symbol = Universal.forSymbol(aChar);
                if (symbol == null) {
                    symbol = Figure.forSymbol(aChar);
                }
                if (symbol == null) {
                    symbol = Letter.forSymbol(aChar);
                }
                if (symbol != null) {
                    if (symbol instanceof Figure) {
                        currentSymbolType = SymbolType.FIGURES;
                    } else if (symbol instanceof Letter) {
                        currentSymbolType = SymbolType.LETTERS;
                    } else {
                        currentSymbolType = SymbolType.UNIVERSAL;
                    }
                    if (SymbolType.UNIVERSAL != currentSymbolType) {
                        if (previousSymbolType == null || previousSymbolType != currentSymbolType) {
                            symbols.add(currentSymbolType == SymbolType.FIGURES ? Special.CHANGE_TO_FIGURES : Special.CHANGE_TO_LETTERS);
                            previousSymbolType = currentSymbolType;
                        }
                    }
                    symbols.add(symbol);
                }
            }
        } else {
            throw new IllegalArgumentException("The provided string was empty, there is nothing to encode.");
        }
        return symbols.stream().map(Symbol::getCode).collect(Collectors.joining(" , "));
    }
}
