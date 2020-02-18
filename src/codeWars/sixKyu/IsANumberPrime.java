package codeWars.sixKyu;

public class IsANumberPrime {

  public static void main(String args[]) {
  System.out.println("Prime: " + isPrime(19));
  }

  public static boolean isPrime(int num) {

    if(num < 2) return false;
    if(num % 2 == 0) return false;

    for (int i = 3; i <= num/2; i +=2) {
      if(num % i == 0) {
        return false;
      }
    }
    return true;

  }

}
