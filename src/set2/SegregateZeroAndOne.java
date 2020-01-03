//WAP to do the following:
//Input: {0,1,0,0,1,0,1,0,0,0,1,1,0}
//Output: {0,0,0,0,0,0,0,0,1,1,1,1}

package set2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SegregateZeroAndOne {

  public static void main(String[] args) {

    List<Integer> input = Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0);

    SegregateZeroAndOneClass obj = new SegregateZeroAndOneClass();
//    obj.convert(input);
    obj.convert2(input); //implemented in a different way
  }
}


class SegregateZeroAndOneClass {

  int zerosCount;
  int onesCount;

  public void convert(List<Integer> input) {
    long zeros = input.stream()
        .filter(element -> element == 0)
        .count();

    long ones = input.stream()
        .filter(element -> element == 1)
        .count();

    List<Integer> output = new ArrayList<>();
    for (int i = 0; i < zeros; i++) {
      output.add(0);
    }
    for (int i = 0; i < ones; i++) {
      output.add(1);
    }

    System.out.println("input: " + input);
    System.out.println("output: " + output);
    System.out.println("Zeros count: " + zeros);
    System.out.println("Ones count: " + ones);
  }


  public void convert2(List<Integer> input) {

    input.stream()
        .forEach(element -> {
              long tempVar = element.equals(0) ? zerosCount++ : onesCount++;
            }
//            {
//              if (element == 0) {
//                z++;
//              } else {
//                o++;
//              }
//            }
        );

    List<Integer> output = new ArrayList<>();
    IntStream.range(0, zerosCount).forEach(i -> output.add(0));
    IntStream.range(0, onesCount).forEach(i -> output.add(1));

    System.out.println("input: " + input);
    System.out.println("output: " + output);
    System.out.println("Zero's count: " + zerosCount);
    System.out.println("One's count: " + onesCount);
  }
}