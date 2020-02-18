package codeWars.sixKyu;

public class LongestCommonSubsequence {

  public static void main(String args[]) {

    String output = lcs("132535365", "123456789");
//    String output = lcs("abdsfcdedfdf", "abcdefsdfsdf");
//    String output = lcs("anothertest", "notatest");
//    String output = lcs("123456789", "132535365");
    System.out.println("Outpt: " + output);
  }
  public static String lcs(String x, String y) {

    int xPosition = 0;
    int yPosition = 0;
    String str = "";

    while (xPosition < x.length() && yPosition < y.length()) {
      for (int j = xPosition; j < x.length() && yPosition < y.length(); j++) {
        if (x.charAt(j) == y.charAt(yPosition)) {
          str = str.concat(String.valueOf(y.charAt(yPosition)));
          xPosition = j+1;
          yPosition++;
        }
      }
      yPosition++;
    }
    return str;
  }
}
