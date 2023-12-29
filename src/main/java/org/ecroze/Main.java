package org.ecroze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  public static class Solver {
    private static final Pattern VALID_STRING = Pattern.compile("[0-1]*");

    public static boolean isSolvable(String s) {
      if (!VALID_STRING.matcher(s).matches()) {
        throw new IllegalArgumentException("String must contain characters 0 and 1 only");
      }
      return false;
    }
  }

  public static void main(String[] args) {
    List<String> strings = parseStrings();
    for (String string : strings) {
      if (Solver.isSolvable(string)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  public static List<String> parseStrings() {
    List<String> strings = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    int numberOfTests = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < numberOfTests; i++) {
      int stringLength = scanner.nextInt();
      scanner.nextLine();

      // We ignore chars after stringLength
      String s = scanner.nextLine().substring(0, stringLength);
      strings.add(s);
    }
    return strings;
  }
}
