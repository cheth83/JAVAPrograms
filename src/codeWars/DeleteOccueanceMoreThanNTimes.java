package codeWars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DeleteOccueanceMoreThanNTimes {

  public static void main(String[] args) {

//    List<Integer> result = find.DeleteOc(Arrays.asList(1,2,4,1,2,3,3,5,6,7,5,4,10,1,1,3,4,11,12,10,10,10), 2);
//    int[] result = find.DeleteOc(Arrays.asList(1,2,4,1,2,3,3,5,6,7,5,4,10,1,1,3,4,11,12,10,10,10), 2);
//    int[] input = {1,2,1,2,4,1,2,3,3,5,6,7,5,4,10,1,1,3,4,11,12,10,10,10};
//    int[] input = {1,1,1,1,1};
    int[] input = {1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1};

    int[] result = find.DeleteOc(input, 3);

    System.out.println("res:");
    IntStream.of(result).forEach(i-> System.out.println(i));
  }
}

class find {
  public static int[] DeleteOc(int[] elements, int maxOccurrences) {

    int[] resInInt;
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> occ = new HashMap<>();

//    IntStream.of(elements)
//        .forEach( element -> {
//          if(occ.containsKey(element) ==  true) {
//            if( occ.get(element) < maxOccurrences ) {
//              res.add(element);
////              resInInt[].
//              occ.put(element, occ.get(element) + 1);
//            }
//          }
//          else {
//            occ.put(element, 1);
//            res.add(element);
//          }
//        });

      for (Integer i : elements) {
        Integer v = occ.put(i, occ.getOrDefault(i,0) + 1);
        if( v == null || v< maxOccurrences) res.add(i);
      }


    int[] resInArray = res.stream()
        .mapToInt(Integer::intValue)
        .toArray();

    return resInArray;
  }
    }
