package am.davsoft.telegraph;

import am.davsoft.telegraph.alphabet.*;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 1:41 AM
 */
public class Decoder {
    public static String decode(final String str) {
        final String[] codes = str.trim().split(",");
        SymbolType currentSymbolType = null;
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            code = code.trim();
            Symbol currentSymbol = Special.forCode(code);
            if (currentSymbol == null && currentSymbolType == null) {
                throw new IllegalArgumentException("Unknown starting symbol");
            } else if (currentSymbol != null) {
                switch (((Special) currentSymbol)) {
                    case CHANGE_TO_FIGURES:
                        currentSymbolType = SymbolType.FIGURES;
                        break;
                    case CHANGE_TO_LETTERS:
                        currentSymbolType = SymbolType.LETTERS;
                        break;
                    case ALL_SPACE_NOT_IN_USE:
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown starting symbol");
                }
            } else {
                switch (currentSymbolType) {
                    case FIGURES:
                        currentSymbol = Figure.forCode(code);
                        break;
                    case LETTERS:
                        currentSymbol = Letter.forCode(code);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown symbol type");
                }
                if (currentSymbol == null) {
                    currentSymbol = Universal.forCode(code);
                }
                if (currentSymbol == null) {
                    throw new IllegalArgumentException("Unknown symbol");
                }
                sb.append(currentSymbol.getSymbol());
            }
        }

        return sb.toString();
    }
}
