package org.ecroze;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @ParameterizedTest
  @ValueSource(strings = {"0", "000", "01010", "11000"})
  void testStringWithAlreadyEnoughZeroes(String input) {
    assertTrue(Main.Solver.isSolvable(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"11111011111", "0111111", "1111110"})
  void testStringWithOneZero(String input) {
    assertTrue(Main.Solver.isSolvable(input));
  }

  @Test
  void testStringWithSeveralZeroes() {
    assertTrue(Main.Solver.isSolvable("11011101111"));
  }
}
