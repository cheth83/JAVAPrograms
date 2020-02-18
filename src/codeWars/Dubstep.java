package codeWars;

public class Dubstep {

  public static void main(String[] args) {

    String s = originalSong("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB");
//    String s = originalSong("RWUBWUBWUBLWUB");


  }

  private static String originalSong(String str) {

    str = str.replaceAll("WUB+", " ").trim();
//    str = str.replaceAll("\\s+", " ");
    System.out.println("replaced:" + str);

    String[] splitString =  str.split(" ");
    for (int i = 0; i <splitString.length; i++) {
      System.out.println("i:" + i + ":" + splitString[i] + ":");
    }

    String newString = new String();

    for (int i = 0; i <splitString.length; i++) {
      if (splitString[i].equals("")) {
        continue;
      }
      newString = newString.concat(splitString[i] + " ");
    }

//    for (int i = 0; i < str.length();) {
//
//      if(glueWord.equals(str.substring(i, i+glueWordLen))) {
//        i = i + glueWordLen;
//        continue;
//      }
//      str.
//    }
    System.out.println("new:" + newString.trim() + ":end");
    return "newString";
  }

}
