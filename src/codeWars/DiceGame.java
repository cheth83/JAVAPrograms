package codeWars;

import java.util.stream.IntStream;

public class DiceGame {
  public static void main(String args[]) {

    //    int res = greedy(new int[] {5,1,3,4,1});
    //    int res = greedy(new int[] {1,1,1,3,1});
//    int res = greedy(new int[] {2, 4, 4, 5, 4});
    int res = greedy(new int[] {3, 2, 3, 3, 3});
    System.out.println("points: " + res);
  }

  public static int greedy(int[] dice) {

    Points p = new Points();
    int totalPoints = 0;

    long diceOne = IntStream.of(dice).filter(diceNumber -> diceNumber == 1).count();
    totalPoints += p.calculatePoints(1, (int) diceOne);

    long diceTwo = IntStream.of(dice).filter(diceNumber -> diceNumber == 2).count();
    totalPoints += p.calculatePoints(2, (int) diceTwo);

    long diceThree = IntStream.of(dice).filter(diceNumber -> diceNumber == 3).count();
    totalPoints += p.calculatePoints(3, (int) diceThree);

    long diceFour = IntStream.of(dice).filter(diceNumber -> diceNumber == 4).count();
    totalPoints += p.calculatePoints(4, (int) diceFour);

    long diceFIve = IntStream.of(dice).filter(diceNumber -> diceNumber == 5).count();
    totalPoints += p.calculatePoints(5, (int) diceFIve);

    long diceSix = IntStream.of(dice).filter(diceNumber -> diceNumber == 6).count();
    totalPoints += p.calculatePoints(6, (int) diceSix);

    return totalPoints;
  }
}

class Points {
  //    rules
  //    Three 1's => 1000 points
  //    Three 6's =>  600 points
  //    Three 5's =>  500 points
  //    Three 4's =>  400 points
  //    Three 3's =>  300 points
  //    Three 2's =>  200 points
  //    One   1   =>  100 points
  //    One   5   =>   50 point

  private int diceNumber;
  private int diceOccurence;

  public int calculatePoints(int diceNumber, int diceOccurence) {

    switch (diceNumber) {
      case 1:
        switch (diceOccurence) {
          case 1:
            return 100;
          case 2:
            return 200;
          case 3:
            return 1000;
          case 4:
            return 1100;
          case 5:
            return 1200;
        }
        break;
      case 2:
        switch (diceOccurence) {
          case 3:
          case 4:
          case 5:
            return 200;
        }
        break;
      case 3:
        switch (diceOccurence) {
          case 3:
          case 4:
          case 5:
            return 300;
        }
        break;
      case 4:
        switch (diceOccurence) {
          case 3:
          case 4:
          case 5:
            return 400;
        }
        break;
      case 5:
        switch (diceOccurence) {
          case 1:
            return 50;
          case 2:
            return 100;
          case 3:
            return 500;
          case 4:
            return 550;
          case 5:
            return 600;
        }
        break;
      case 6:
        switch (diceOccurence) {
          case 3:
          case 4:
          case 5:
            return 600;
        }
        break;
    }
    return 0;
  }
}
//  int[] a1 = new int[] {1, 2, 3};
//  int[][] a2 = new int[][] {{1, 2,31,45,66}, {2, 3}};
//  int[][][] a3 = new int[][][] {{{1, 2, 3},{4,5,6}}, {{11, 12, 13}}};
//  int[][][] a3a = new int[][][] {{{111, 112, 113}}};
//
//    System.out.println("a1: " + Arrays.toString(a1));
//        System.out.println("a2: " + Arrays.toString(a2[0]) + Arrays.toString(a2[1]));
//        System.out.println("a21: " + a2[0][2]);
//        System.out.println("a3a: " + a3a[0][0][2]);
//        System.out.println("a3: " + Arrays.toString(a3[0][0]));
//
//
//        int[][][] rules = new int[][][] {
//        {{1,3,1000}},
//        };
