package com.promineotech;

import java.util.Random;

public class TestDemo {

  /*
   *  addPositive method: takes two positive integers as parameters and returns the sum. 
   *  If either is negative, an exception is thrown.
   */
  
  public int addPositive(int a, int b) {
    if (a > 0 && b > 0) {
      return a + b;
    } else {
      throw new IllegalArgumentException("Both parameters must be positive!");
    }
  }
  
  /*
   *  productLessThan1000 method: takes two integers are parameters and returns the product.
   *  If the product of the two integers are more than 1000,an exception is thrown. 
   */
  
  public int productLessThan1000(int num1, int num2) {
    if ((num1 * num2) <= 1000) {
      return (num1 * num2);
    } else {
      throw new IllegalArgumentException("Product of two numbers must be less than 1000");
    }
  }

  /*
   *  getRandomInt method: takes no parameters, generates a random integer between 1 and 10 using the java.util.Random.
   *  returns the random generated integer. 
   */
  int getRandomInt() {

    Random random = new Random();
    return random.nextInt(10) + 1;
 }

  /*
   *  randomNumberSquared method: takes no parameter. The random generated integer from getRandomInt method is stored 
   *  as numToSquare. This method return the square of integer numToSquare.
   */
  
  int randomNumberSquared() {

    int numToSquare = getRandomInt();
    return numToSquare * numToSquare;
  }
  
  /*
   * Practice method letterGrade: This method returns a letter grade for respective numGrade. 
   * If the numGrade in less than zero, an exception is thrown. 
   */
  
  public char letterGrade (int numGrade) {
    if (numGrade < 0) {
      throw new IllegalArgumentException("Number grade cannot be less than 0");
    }
    if (numGrade < 60) {
      return  'F';
    }
    if (numGrade < 70) {
      return 'D';
    }
    if (numGrade < 80) {
      return 'C';
    }
    if (numGrade < 90) {
      return 'B';
    }
    else {
      return 'A';
    } 
  }
}
