import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfItemsInList {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("a1");
    list.add("a1");
    list.add("a2");
    list.add("a3");
    list.add("a1");
    list.add("a4");
    list.add("a4");
    list.add("a5");
    list.add("a2");

    Map<String, Long> freq = new HashMap<>();
    // Anuj: Yes this will work, but this is old way of implementing this. Try to use methods provided in Collectors class.
    //Chethan: i have implemented one from using Collectors class.
//    list.forEach(item -> {
//      freq.put(item, (freq.get(item) == null)? 1 : (freq.get(item)+1));
//    });

    //Map<String, Long>
        freq = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//      if(freq.containsKey(item)) {
//        freq.replace(item, freq.get(item)+1);
//      }
//      else {
//        freq.put(item, 1);
//      }
//    });

    System.out.println(freq);


  }
}
