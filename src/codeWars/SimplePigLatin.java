package codeWars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimplePigLatin {

  public static void main(String args[]) {

//    String output = pigIt("Pig latin is cool");
        String output = pigIt("Hello  world ?");
    System.out.println("output: " + output);

  }

  public static String pigIt(String str) {

//    String[] strArray = str.trim().split(" ");
    return Arrays.stream(str.trim().split("\\s+"))
        .map(element -> {
          return element.equals("!")? "!" : element.equals("?")? "?" : element.substring(1) + element.charAt(0) + "ay";
        }).collect(Collectors.joining(" "));



//    return "";
  }

}
