package org.ecroze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  public static class Solver {
    private static final Pattern VALID_STRING = Pattern.compile("[0-1]*");

    public static boolean isSolvable(String input) {
      if (!VALID_STRING.matcher(input).matches()) {
        throw new IllegalArgumentException("String must contain characters 0 and 1 only");
      }

      // If we only have ones, we cannot add any zero because '11' gives '111' after insertion (-> NO answer)
      // If we have at least one 0, either we only have zeroes (-> YES answer)
      // Or we have the substring '10' or '01' somewhere in the string
      // '10' gives '100' which means we can repeat the insertion as many times until we have a majority of zeroes.
      // '01' gives '001' which means we can repeat the insertion as many times until we have a majority of zeroes.

      // So the test is: we check we have at least one zero somewhere in the string.
      return input.indexOf('0') >= 0;
    }

    private static long getNumberOfZeroes(String input) {
      return input.chars().filter(c -> c == '0').count();
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
