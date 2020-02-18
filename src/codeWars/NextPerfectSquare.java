package codeWars;

public class NextPerfectSquare {
  public static void main(String args[]) {

    long res = findNextSquare(9);

    System.out.println("res:" + res);
  }

  private static long findNextSquare(long sq) {

//    double sqNumInDouble = Math.sqrt(sq);
//    if ((sqNumInDouble % 1) == 0) {
//      long sqNumInLong = (long) sqNumInDouble;
//      return (sqNumInLong+1) * (sqNumInLong+1);
//    }
//    return -1;

    for (int i = 1; i*i <= sq; i++) {
      if((sq % i == 0) && (sq / i == i)) {
        return ((i+1)*(i+1));
      }
    }
    return -1;

  }
}

