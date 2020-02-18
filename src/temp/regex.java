package temp;

public class regex {

  public static void main(String[] args) {

    String str = "askjndvb";
    int index = str.indexOf("s");
    System.out.println("index: " + index);
//    str = str.substring(0,index+1)+ "z"  + str.substring(index+1, str.length());


//    str = "bcv";

//    String str1 = str.split(0, index-1);

    System.out.println("res: " + str);


//    boolean res = containsTrue("astrue");
//    System.out.println("res: " + res);




  }

  public static boolean containsTrue(String s){
    return s.matches(".*true");
  }

}
