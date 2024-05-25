package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

  private TestDemo testDemo;

  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
        
  }

  // Test for addPositive method
  
  @ParameterizedTest
  @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
      boolean expectException) {

    if (!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    } else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }

  static Stream<Arguments> argumentsForAddPositive() {
    return Stream.of(
        arguments(2, 4, 6, false),
        arguments(0, 0, 5, true),
        arguments(4, -5, -1, true)
        );
  }
  
  @Test
  void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
    assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
  }
 
  // Test for productLessThan1000 method
  
  @ParameterizedTest
  @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForProductLessThan1000")
  
  void assertThatProductOfTwoNumbersAreLessThan1000(int num1, int num2, int product, boolean expectException) {

    if (!expectException) {
      assertThat(testDemo.productLessThan1000(num1, num2)).isEqualTo(product);
      } else {
      assertThatThrownBy(() -> testDemo.productLessThan1000(num1, num2))
          .isInstanceOf(IllegalArgumentException.class);
    }
  }
  
  static Stream<Arguments> argumentsForProductLessThan1000() {
    return Stream.of(
        arguments(5, 5, 25, false), // test case passes, since product is less than 1000 and no exception is expected.
        arguments(100, 200, 20000, true) // test case passes, since product is more than 1000 and exception is expected.
        );
  }
  
  @Test
  void assertThatProductOfTwoNumbersAreLessThan1000() {
    assertThat(testDemo.productLessThan1000(9, 10)).isEqualTo(90);
    assertThat(testDemo.productLessThan1000(500, 1)).isEqualTo(500);
  }
  
  //Test for randomNumberSquared method
  
  @Test
  void assertThatNumberSquaredIsCorrect() {
    TestDemo mockDemo = spy(testDemo); //Using spy method to mock the TestDemo class.
    
    doReturn(5).when(mockDemo).getRandomInt();
    int fiveSquared = mockDemo.randomNumberSquared();
    assertThat(fiveSquared).isEqualTo(25);
  }
  
//Test for letterGrade method
  
  @Test
  void testsForNumGradeAndLetterGrade() {
    assertEquals('F', testDemo.letterGrade(59)); // This test case passed since the numGrade is less than 60, the letterGrade is F.
    assertEquals('A', testDemo.letterGrade(91)); // This test case passed since the numGrade is more than 91, the letterGrade is A. 
    assertEquals('F', testDemo.letterGrade(0));  // This test case passed since the numGrade is less than 60 and not negative, 
                                                 // the letter grade is F.    
   }
  
  @Test
  void testForNegativeNumGrade () {
    assertThatThrownBy(() -> testDemo.letterGrade(-1))
        .isInstanceOf(IllegalArgumentException.class); // This test case passed, since negative letter grade is 
                                                       // expected to throw Illegal Argument Exception.
  }
}

