package codeWars;

public class ReversedStrings {

  public static void main(String args[]) {
    System.out.println("revStr: " + solution("world"));
  }

  public static String solution(String str) {

    String revStr = "";
    for (int i = str.length()-1; i >= 0; i--) {
      revStr = revStr + str.charAt(i);
    }
    return revStr;
  }

}
