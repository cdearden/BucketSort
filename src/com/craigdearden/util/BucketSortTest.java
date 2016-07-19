/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.craigdearden.util;


public class BucketSortTest {

  
  public static void main(String[] args) {
    int[] intArr = {2, 7, 73, 43, 9, 26, 32, 41, 55, 36, 68, 37, 83, 96, 128, 11334, 21, 1, 5};
    
    BucketSort.sort(intArr);

    for(int num : intArr) {
      System.out.printf("%d ",num);
    }
  }
  
}
