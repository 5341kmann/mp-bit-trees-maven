package edu.grinnell.csc207.main;

import static edu.grinnell.csc207.util.BrailleAsciiTables.toBraille;
import static edu.grinnell.csc207.util.BrailleAsciiTables.toAscii;
import static edu.grinnell.csc207.util.BrailleAsciiTables.toUnicode;


import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Braille BitTree conversions Executable class.
 *
 * @author Grant Sackmann
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Set of acceptable commands.
   */
  private static final Set<String> COMMANDS = new HashSet<>(
      Arrays.asList("unicode", "braille", "ascii"));

  /**
   * Main method.
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println("invalid number of arguments");
      return;
    } // if

    String command = args[0].toLowerCase();
    String input = args[1];

    if (!COMMANDS.contains(command)) {
      pen.printf("invalid command: %s\n", command);
      return;
    } // if

    if (!command.equals("ascii")) {
      for (char c : input.toCharArray()) {
        String brailleChar = toBraille(c);
        if (command.equals("braille")) {
          pen.print(brailleChar);
        } else {
          String uniChar = toUnicode(brailleChar);
          pen.print(uniChar);
        } // if-else
      } // for
    } else {
      for (int i = 0; i < input.length(); i += 6) {
        try {
          pen.println(toAscii(input.substring(i, i + 6)));
        } catch (RuntimeException e) {
          throw new RuntimeException("Invalid Input");
        } // try-catch
      } // for
    } // if-else

    pen.close();
  } // main(String[]

} // class BrailleASCII
