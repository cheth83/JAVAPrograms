//Given a complex array: [1,2,[3,4,5,[6,7,8,9,[10,11]]]] , write a program to unnest it: [1,2,3,4,5,6,7,8,9,10,11].
// Try to come up with a generic solution

package set2;

import java.util.ArrayList;
import java.util.List;

public class UnNestArray {

  public static void main(String[] args) {

//  Chethan: I didn't get idea to implement this, got pieces of code from internet

    Object[] nestedArray = new Object[]{1, 2,
        new Object[]{3, 4, 5,
            new Object[]{6, 7, 8, 9,
                new Object[]{10, 11
                }
            }
        }
    };

    List<Integer> flattenList = flatten(nestedArray);

    System.out.println(flattenList);
  }

  public static List<Integer> flatten(Object[] nestedArray) {

    List<Integer> flattenList = new ArrayList<>();

    for (int i = 0; i < nestedArray.length; i++) {
      if (nestedArray[i] instanceof Object[]) {
        flattenList.addAll(flatten((Object[]) nestedArray[i]));
      } else {
        flattenList.add((Integer) nestedArray[i]);
      }
    }
    return flattenList;
  }


}
