package codeWars;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class CenturyFromYear {
  public static void main(String[] args) {

//    int year = c.FindCentury(1234);
//    int year = c.FindCentury(1705);
//    int year = c.FindCentury(1900);
    int year = c.FindCentury(1600);
//    int year = c.FindCentury(2000);
//    int year = c.FindCentury(89);
//    int year = c.FindCentury(100);



    System.out.println("Year: " + year);

    System.out.println("what: " + 1010 % 100 );

  }
}

class c {

  static public int FindCentury(int century) {

//    Double a = century/100.0;
//    if (a == a.intValue()) {
//      return a.intValue();
//    }
//    return (century/100)+1;

    return (century % 100) ==0 ? century /100 : (century /100) + 1;


  }
}


