package set1;

import java.util.HashMap;
import java.util.Map;

public class SortMap {
  public static void main(String[] args) {

    Map<String, Integer> maps = new HashMap<>();
    maps.put("D", 1);
    maps.put("A", 3);
    maps.put("C", 6);
    maps.put("B", 2);
    maps.put("Z", 12);


    //sort by key
//    List<String> sortedMapsByKey = maps.keySet().stream().sorted().collect(Collectors.toList());
//    maps.keySet().stream().sorted().forEach(item -> System.out.println(item.en));
    //Anuj:: looks crisp, but try to remember this
    //Chethan: ok
    //sort by value
    maps.entrySet().stream()
//        .sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
        .sorted(Map.Entry.comparingByValue())
        .forEach(item -> System.out.println(item));



  }

}
