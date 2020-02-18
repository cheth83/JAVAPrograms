package temp;

import java.util.ArrayList;
import java.util.List;

public class Temp {

  public static void main(String[] args) {

    Generics1 obj = new Generics1();
    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    obj.count(intList, 3);

    List<Double> doubleList = new ArrayList<>();
    doubleList.add(1.0);
    obj.count(doubleList, 1.0);


    Generics2<Integer> obj2 = new Generics2<>();
    obj2.count(intList, 2);


    }
  }


class Generics1 {

  public <T extends Number & Comparable> long count(List<T> items, T item) {
    return items.stream().filter(i -> i.compareTo(item) > 1).count();
  }

//  public <? extends Number> long count2(List<?> items, ? item) {
//    return items.stream().filter(i -> i.compareTo(item) > 1).count();
//  }


}

class Generics2<T extends Number & Comparable> {

  public long count(List<T> items, T item) {
    return items.stream().filter(i -> i.compareTo(item) > 1).count();
  }


}
