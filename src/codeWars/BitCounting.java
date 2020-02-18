package codeWars;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BitCounting {

  public static void main(String args[]) {

//    int res = countBits(1234);

    String a = "12341111";
    long count = a.chars()//.forEach(i -> System.out.println("a:" + i));
    .filter(i -> i=='1')
        .count();


//    IntStream.range(1,10).forEach(i -> System.out.println("e:" + i));


    System.out.println("res:" + count);
  }

  public static int countBits(int n){

    //1 solution
//    return Integer.bitCount(n);

    return (int) Integer.toBinaryString(n).chars()
        .filter(i -> i ==1)
        .count();

  }


}
