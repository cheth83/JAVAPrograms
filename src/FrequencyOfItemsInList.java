import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map<String, Integer> freq = new HashMap<>();
    // Anuj: Yes this will work, but this is old way of implementing this. Try to use methods provided in Collectors class.
    list.forEach(item -> {
      freq.put(item, (freq.get(item) == null)? 1 : (freq.get(item)+1));
    });


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
