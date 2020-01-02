package set2;

import java.util.HashMap;
import java.util.Map;

public class LargestChainInMap {

  public static void main(String[] args) {

    Map<String, String> maps = new HashMap<>();
    maps.put("A", "B");
    maps.put("B", "Y");
    maps.put("C", "D");
    maps.put("D", "E");
    maps.put("E", "F");
    maps.put("F", "U");
    maps.put("Y", "Z");
    maps.put("T", "N");
    maps.put("H", "N");
    maps.put("N", "K");
    maps.put("K", "L");
    maps.put("L", "M");
    maps.put("M", "I");
    maps.put("I", "P");

    Map<String, String> chainList = new HashMap<>();

    maps.keySet().stream()
        .forEach(item -> {
          String makeChain = "";
          makeChain = makeChain.concat(item.toString());
          makeChain = chain(maps, item, makeChain);
          chainList.put(item, makeChain);
        });

    System.out.println("All possible chains:");
    chainList.entrySet().stream()
        .forEach(System.out::println);

    System.out.println("Longest chain:");
    chainList.values().stream()
        .reduce((value1, value2) -> value1.length() > value2.length() ? value1 : value2)
        .ifPresent(System.out::println);
  }

  public static String chain(Map<String, String> maps, String item, String makeChain) {
    if (maps.get(item) != null) {
      makeChain = makeChain.concat(maps.get(item));
      makeChain = chain(maps, maps.get(item), makeChain);
    }
    return makeChain;
  }
}
