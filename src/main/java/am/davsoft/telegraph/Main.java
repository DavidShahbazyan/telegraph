package am.davsoft.telegraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 08, 2021
 * Time: 11:22 PM
 */
public class Main {
    private static AppMode appMode = null;
    private static boolean enableGraphicalRepresentation = false;

    public static void main(String[] args) {
        printBanner();
        for (String arg : args) {
            arg = arg.trim();

            if (arg.equals("-h") || arg.equals("--help")) {
                printHelp();
                System.exit(0);
            }

            if (arg.equals("-d") || arg.equals("--decode")) {
                appMode = AppMode.DECODE_MODE;
            }

            if (arg.equals("-e") || arg.equals("--encode") || arg.equals("-eg")) {
                appMode = AppMode.ENCODE_MODE;
            }

            if (arg.equals("-g") || arg.equals("--graphical") || arg.equals("-eg")) {
                enableGraphicalRepresentation = true;
            }
        }
        if (appMode == null) {
            printHelp();
            System.exit(0);
        } else if (appMode == AppMode.DECODE_MODE && enableGraphicalRepresentation) {
            System.out.println(" [ WARN ] Graphical Mode will be ignored in case of Debug Mode");
        }
        startProcess();
    }

    private static void printBanner() {
        System.out.println(Banners.getRandom());
    }

    private static void printHelp() {
        String help_message = new StringBuilder('\n')
                .append(" -d | --decode      Start the app in decode mode").append("\n")
                .append("                    In Decode Mode you will need to provide each symbol according to the rules below:").append("\n")
                .append("                       ● -> 1").append("\n")
                .append("                       ○ -> 0").append("\n")
                .append("                       • -> *").append("\n")
                .append("                    Example:").append("\n")
                .append("                                            ●").append("\n")
                .append("                                            ●").append("\n")
                .append("                       For a letter \"A\" ->  •  -> you should write: 11*000").append("\n")
                .append("                                            ○").append("\n")
                .append("                                            ○").append("\n")
                .append("                                            ○").append("\n")
                .append("                    Each letter should be separated by comma").append("\n")
                .append("\n")
                .append(" -e | --encode      Start the app in encode mode")
                .append("\n")
                .append(" -g | --graphical   Display graphical representation (Only for Encode Mode)")
                .append("\n")
                .append(" -h | --help        Print this message and exit")
                .append("\n")
                .toString();
        System.out.println(help_message);
    }

    private static void startProcess() {
        System.out.printf("Please, insert the string to %s:%n", appMode == AppMode.DECODE_MODE ? "decode" : "encode");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (appMode == AppMode.DECODE_MODE) {
            System.out.println(Decoder.decode(line));
        } else {
            final String encodedString = Encoder.encode(line);
            System.out.println(encodedString + '\n');
            if (enableGraphicalRepresentation) {
                visualizeEncodedString(encodedString);
            }
        }
    }

    private static void visualizeEncodedString(final String string) {
        final Map<String, String> ENCODE_SYMBOLS = Map.of(
                "1", "●",
                "0", "○",
                "*", "•"
        );
        final int MATRIX_HEIGHT = 6;
        final String[] strings = string.split(",");

        String[][] matrix = new String[MATRIX_HEIGHT][strings.length];
        for (int col = 0; col < strings.length; col++) {
            final String[] symbols = strings[col].trim().split("(?!^)");
            for (int row = 0; row < symbols.length; row++) {
                matrix[row][col] = ENCODE_SYMBOLS.get(symbols[row]);
            }
        }

        System.out.println(Arrays.stream(matrix)
                .map(row -> String.join(" ", row))
                .collect(Collectors.joining("\n"))
        );
    }
}
