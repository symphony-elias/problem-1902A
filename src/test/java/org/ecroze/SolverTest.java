package org.ecroze;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolverTest {

  @Test
  void testEmptyString() {
    assertFalse(Main.Solver.isSolvable(""));
  }

  @Test
  void testInvalidString() {
    assertThrows(IllegalArgumentException.class, () -> Main.Solver.isSolvable("1040abc"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "11", "111"})
  void testStringWithOnlyOnes(String input) {
    assertFalse(Main.Solver.isSolvable(input));
  }
}
