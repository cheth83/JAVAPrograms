package codeWars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeightForWeight {

  public static void main(String args[]) {

//    String input = "2000 103 123 4444 99";
//    String input = "11 11 2000 10003 22 123 1234000 44444444 9999";
    String input = " 56    65 74 100 99 68      86 180 90";


    String output = orderWeight(input);



//    System.out.println("expected: 103 123 4444 99 2000");
//    System.out.println("expected: 2000 10003 1234000 44444444 9999 11 11 22 123");
    System.out.println("input: " + input);
    System.out.println("expected: 100 180 90 56 65 74 68 86 99");
    System.out.println("actual: " + output);
  }

  public static String orderWeight(String strng) {
    return
        Arrays.stream(strng.split(" "))
            .sorted(Comparator
                .comparing(WeightForWeight::sumDigits)
                .thenComparing(String::compareTo))
            .collect(Collectors.joining(" "));

  }

  private static Integer sumDigits(String s) {
    return s.chars().map(c -> c - 48).sum();
  }


  public static String orderWeight2(String strng) {

    String[] s = strng.trim().split("\\D+");
    return Arrays.stream(s)
        .sorted(
            (x, y) -> {
              int a = 0;
              int b = 0;
                for(int i = 0; i < x.length(); i++){
                  a += Integer.parseInt(Character.toString(x.charAt(i)));
                }

              for(int i = 0; i < y.length(); i++){
                b += Integer.parseInt(Character.toString(y.charAt(i)));
              }
              if (a < b) {
                return -1;
              } else if (a > b) {
                return 1;
              } else {
                return x.compareTo(y);
              }
            }).collect(Collectors.joining(" "));
  }

}