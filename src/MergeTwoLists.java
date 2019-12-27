import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeTwoLists {
  public void method() {
    List<Integer> list1 = new ArrayList<>();
    // java 1.1
    for(int i=1; i<=10; i++) {
      list1.add(i);
    }

    //java 1.5
    for(Integer item: list1){
      System.out.print(item);
    }
    // will not do if list is empty
    list1.stream().forEach(item -> list1.add(item));
    // int stream : boxed will convert to Integer stream
    IntStream.range(0,10).boxed().map(index -> list1.add(index));
    // directly generating Integers
    Stream.iterate(0, i -> i+1).limit(10).map(index -> list1.add(index));

    List<Integer> collect = list1.stream().filter(i -> i > 5).collect(Collectors.toList());

    Integer sum = list1.stream().reduce(0, (x, y) -> x + y);
    int sum1 = list1.stream().mapToInt(x -> x).sum();

    IntStream.range(0,10).sum();

    List<Integer> list2 = new ArrayList<>();
    for (int i=20; i<=30; i++) {
      list2.add(i);
    }

    List<Integer> list3 = new ArrayList<>();
    list3.addAll(list2);
    list3.addAll(list1);

//    for (int i: list3) {
//      System.out.println("i= " + i);
//    }

    list3.stream()
        .forEach(i -> System.out.println("i=" + i));

    System.out.println("total items in list: " + list3.stream().count());

    List<Integer> sortedList3 = list3.stream()
        .sorted()
        .collect(Collectors.toList());
    sortedList3
        .forEach( i -> System.out.println("sorted i= "+i));

    Stream<Integer> a = list3.stream()
        .sorted();
    a.forEach(i-> System.out.println("In steam:"+i));


    System.out.println("End of MergeTwoLists");
  }
}
