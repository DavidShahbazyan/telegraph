package am.davsoft.telegraph.alphabet;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 1:10 AM
 */
public interface Symbol {
    String getCode();

    default String getSymbol() {
        return "";
    }
}
