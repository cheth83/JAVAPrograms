package codeWars.sixKyu;

public class NumberOfTrailingZerosOfNFactorial {

  public static void main(String args[]) {

    System.out.println("o:" + 3/10);

  }

  public static int zeros(int n) {


    if(n<5) {
      return 0;
    }
    if (n<10) {
      return 1;
    }
    return n/10+1;
  }
}
