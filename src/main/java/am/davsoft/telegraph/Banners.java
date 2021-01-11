package am.davsoft.telegraph;

import java.util.List;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 09, 2021
 * Time: 12:14 AM
 */
public class Banners {
    private static final List<String> BANNERS = List.of("\n"
          + "┌────────────────────────────────────────────────────────────────┐\n"
          + "│          INTERNATIONAL TELEGRAPH MESSAGE (EN/DE)CODER          │\n"
          + "├────────────────────────────────────────────────────────────────┤\n"
          + "│                    Author: David Shahbazyan                    │\n"
          + "│                       Date: Jan 09, 2021                       │\n"
          + "│             License: WTFPL (http://www.wtfpl.net/)             │\n"
          + "└────────────────────────────────────────────────────────────────┘\n"
    );

    public static String getRandom() {
        return BANNERS.get(((int) (Math.random() * BANNERS.size())));
    }
}
