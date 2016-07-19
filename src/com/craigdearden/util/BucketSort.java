/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.util;

import java.util.Arrays;

public class BucketSort {

  /**
   * Sorts integers using the bucket sort method.
   * 
   * @param array An array of positive integers.
   * @return A sorted array of integers.
   * @throws IllegalArgumentException if integers in the array are negative.
   */
  public static int[] sort(int[] array) throws IllegalArgumentException {
    if(Arrays.stream(array).filter(num -> num < 0).count()> 0)
      throw new IllegalArgumentException("Integers must be positive.");
    
    int largest = 0;
    for (int num : array) {
      if (largest < num) {
        largest = num;
      }
    }
    // Determines the number of digits in the largest number in the array.
    int maxDigits = String.valueOf(largest).length();

    int[] indexes = new int[10];
    int[][] bucket = new int[10][array.length];

    for (int digits = 1; digits <= maxDigits; digits++) {
      for (int num : array) {
        /*
         * This logic is not super apparent, but if digits is 1 
         * (if we are looking at the ones place) then it determines 
         * the value of the digit in the ones place and so on.
         */ 
        int digit = (int) ((num % Math.pow(10, digits)) / Math.pow(10, digits - 1));
        bucket[digit][indexes[digit]] = num;
        indexes[digit]++;
      }
      
      int i = 0;
      for (int row = 0; row < 10; row++) {
        for (int column = 0; column < indexes[row]; column++) {
          array[i] = bucket[row][column];
          i++;
        }
      }
      
      for(int j = 0; j < 10; j++) {
        indexes[j] = 0;
      }
    }

    return array;
  }
}
