import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IntegerList {

  public static void main(String[] args) {

    Integer search = 31;

    List<Integer> listOfInt = new ArrayList<Integer>();
    listOfInt.add(1);
    listOfInt.add(2);
    listOfInt.add(3);
    listOfInt.add(4);
//     listOfInt.add(2);
//    listOfInt.add(2);

//    List<Integer> listOfInt = new LinkedList<Integer>();
//      for(int i=1; i<=100; i++) {
//        listOfInt.add(i);
//      }

    // if(listOfInt.contains(11)) {
    //     System.out.println("found");
    // }
    // else {
    //     System.out.println("not found");
    // }

    //System.out.println(listOfInt.contains(2)? "found" : "not found");

    // boolean res = listOfInt.stream().anyMatch( a -> a.equals(search));
    // System.out.println("found = " + res);

    // Anuj:: why do you use findAny at this place and not findFirst?
    // Chethan: as my requirement is to find any element in the stream without considering any order, i used findany
    Optional<Integer> res = listOfInt.stream()
        .filter(element -> element.equals(search))
        .findAny();

    // Anuj:: we should try to avoid if elses when donig functional programming unless absolutely needed.
    // Chethan: ok. but in this case, i didn't get any other way to evaluate result without using if else.
    if(res.isPresent()) {
      System.out.println("found");
    } else {
      System.out.println("not found");
    }

    // Chethan: i could write below but i don't know how to print a message if element isn't found
    listOfInt.stream()
        .filter(element -> element.equals(search))
        .findFirst().ifPresent(g -> System.out.println("found"));




    System.out.println("End of IntegerList");

  }
}
