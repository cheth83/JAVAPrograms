package codeWars.sixKyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class RecoverASecretStringFromRandomTriplets {
  public static void main(String args[]) {

//    char[][] triplets = {
//        {'t','s','f'},
//        {'a','s','u'},
//        {'m','a','f'},
//        {'a','i','n'},
//        {'s','u','n'},
//        {'m','f','u'},
//        {'a','t','h'},
//        {'t','h','i'},
//        {'h','i','f'},
//        {'m','h','f'},
//        {'a','u','n'},
//        {'m','a','t'},
//        {'f','u','n'},
//        {'h','s','n'},
//        {'a','i','s'},
//        {'m','s','n'},
//        {'m','s','u'}
//    };
    char[][] triplets = {
        {'t','u','p'},
        {'w','h','i'},
        {'t','s','u'},
        {'a','t','s'},
        {'h','a','p'},
        {'t','i','s'},
        {'w','h','s'}
    };

    System.out.println(recoverSecret(triplets));
  }

  public static String recoverSecret(char[][] triplets) {
    List<Character> wordList = new LinkedList<>();
    for (char[] triplet : triplets) {
      int pIndex = -1;
      for (int i = 0; i < 3; i++) {
        int cIndex = wordList.indexOf(triplet[i]);
        if (cIndex != -1) {
          if (pIndex > cIndex) {
            Character removed = wordList.remove(cIndex);
            wordList.add(pIndex, removed);
            cIndex = pIndex;
          }
          pIndex = cIndex;
        } else if (pIndex != -1) {
          pIndex += 1;
          wordList.add(pIndex, triplet[i]);
        } else {
          wordList.add(0, triplet[i]);
          pIndex = 0;
        }
      }
    }
    return wordList.stream().map(ch -> ch.toString()).reduce((p,n) -> p + n).get();
  }


  public static String recoverSecret2(char[][] triplets) {
    List<String> combinations = new LinkedList<>();
    Stack<Character> stack = new Stack<>();
    List<List<Character>> charGrid = getListofLists(triplets);
    String ref = charGrid.get(0).stream().map(ch -> String.valueOf(ch)).collect(Collectors.joining(""));
    combinations.add(ref);
    Character postMatchedChar = null;
    Character preChar = null;
    Character postChar = null;
    for(int i = 1; i < charGrid.size(); i++){
      List<Character> currentList = charGrid.get(i);
      for(int j = 0; j < currentList.size(); j++){
        if(j > 0){
          preChar = currentList.get(j-1);
        }
        if(j < currentList.size()-1){
          postChar = currentList.get(j+1);
        }
        if(j == currentList.size()-1){
          postChar = null;
        }

        if(combinationsContainsChar(combinations,currentList.get(j))){
          if(preChar != null && postChar != null){
            if (combinationsContainsChar(combinations,postChar)) {
              combinations = validateCombinations(combinations, currentList.get(j), postChar, 1);
            }
            else{
              combinations = generateCombinations(combinations,currentList.get(j),postChar,1);
            }
            if (combinationsContainsChar(combinations,preChar)) {
              combinations = validateCombinations(combinations, currentList.get(j), preChar, 0);
            }
            else{
              combinations = generateCombinations(combinations,currentList.get(j),preChar,0);
            }
          }
          else if(preChar != null && postChar == null){
            if (combinationsContainsChar(combinations,preChar)) {
              combinations = validateCombinations(combinations, currentList.get(j), preChar, 0);
            }
            else{
              combinations = generateCombinations(combinations,currentList.get(j),preChar,0);
            }
          }
          else if(preChar == null && postChar != null){ //1

            if (combinationsContainsChar(combinations,postChar)) {
              combinations = validateCombinations(combinations, currentList.get(j), postChar, 1);
            } else {
              combinations = generateCombinations(combinations, currentList.get(j),postChar, 1);
            }

          }
        }
      }
      preChar = null;
      postChar = null;
    }
    return combinations.get(0);
  }

  private static boolean combinationsContainsChar(List<String> combinations, Character postChar) {
    return combinations.stream().anyMatch(c -> c.contains(String.valueOf(postChar)));
  }

  private static List<String> validateCombinations(List<String> combinations, Character refChar, Character verifyChar, int postFix) {
      List<String> copyList = new ArrayList<>(combinations);

    combinations.forEach(str -> {
      if(postFix == 0){
        if(str.indexOf(refChar) < str.indexOf(verifyChar)){
          copyList.remove(str);
        }
      }
      else{
        if(str.indexOf(refChar) > str.indexOf(verifyChar)){
          copyList.remove(str);
        }
      }
    });

    combinations = copyList;
    return combinations;
  }

  private static List<String> generateCombinations(List<String> combinations, Character refChar, Character insertChar, int postFix) {
    List<String> newCombination = new ArrayList<>();
    for (String combination : combinations) {
      int position = combination.indexOf(refChar);
      if (postFix == 1) {
        for (int i = position; i < combination.length(); i++) {
          String str =
              combination.substring(0, i + 1)
                  + insertChar
                  + combination.substring(i + 1, combination.length());
          newCombination.add(str);
        }
      }
      else {
        for (int i = position; i >= 0; i--) {
          String str =
              combination.substring(0, i)
                  + insertChar
                  + combination.substring(i, combination.length());
          newCombination.add(str);
        }
      }
    }
    combinations.removeAll(combinations);
    combinations.addAll(newCombination);
    return combinations;
  }


  private static List<List<Character>> getListofLists(char[][] triplets) {
    List<List<Character>> characterGrid = new ArrayList<>();
    for (int i = 0; i < triplets.length; i++){
      List<Character> list = new ArrayList<>();
      for(int j= 0; j < 3; j++){
        list.add(triplets[i][j]);
      }
      characterGrid.add(list);
    }
    System.out.println(characterGrid);
    return characterGrid;
  }


  public static String recoverSecret1(char[][] triplets) {

    String str = "";
    int first = 0;

    for (char[] triplet : triplets) {
      System.out.println("triplets: " + String.valueOf(triplet));
      }

    for (char[] triplet : triplets) {

      if (first == 0) {
        str = str.concat(String.valueOf(triplet));
        first=1;
      }
      else if(str.matches("^.*["+triplet[0]+"].*$")) {
        if(str.matches(".*["+triplet[1]+"].*")) {
          if(str.matches(".*["+triplet[2]+"].*")) {
            continue;
          }
          else {
            str = str.concat(String.valueOf(triplet[2]));
          }
        }
        else if (str.matches(".*["+triplet[2]+"].*")){
          str = str.substring(0,str.indexOf(triplet[0])+1) + triplet[1] + str.substring(str.indexOf(triplet[0])+1, str.length());
        }
        else {
          str = str + triplet[1] + triplet[2];
//          str = str.substring(0,str.indexOf(triplet[0])+1) + str + triplet[1] + triplet[2];
        }
      }
      else if(str.matches(".*["+triplet[1]+"].*")) {
        str = triplet[0] + str;
        if(str.matches(".*["+triplet[2]+"].*")) {
//          if (str.indexOf(triplet[1]) == 0) {
//            str = str + triplet[2];
//          str = triplet[0] + str;
//          } else {
//                      str = str.substring(0,str.indexOf(triplet[0])+1) + triplet[0] +
//             str.substring(str.indexOf(triplet[0])+1, str.length());
//          }
        }
        else {
//          str = str.substring(0,str.indexOf(triplet[2])+1) + triplet[2] + str.substring(str.indexOf(triplet[2])+1, str.length());
          str = str + triplet[2];

        }
      }
      else if(str.matches(".*["+triplet[2]+"].*")) {
//        if (str.indexOf(triplet[2]) == 0) {
          str = triplet[0] + triplet[1] + str;
//        } else {
//                  str = str.substring(0,str.indexOf(triplet[2])+1) + triplet[0] + triplet[1] +
//           str.substring(str.indexOf(triplet[2])+1, str.length());
//        }
      }
    }
    System.out.println(str);

    return str;
  }


  public static String recoverSecret3(final char[][] triplets) {
    final Set<Character> characters = new HashSet<>();
    final Map<Character, Set<Character>> partialOrder = new HashMap<>();
    for (final char[] triplet : triplets) {
      for (int i = 0; i < triplet.length; i++) {
        final char c = triplet[i];
        characters.add(c);
        Set<Character> after = partialOrder.get(c);
        if (after == null) {
          after = new HashSet<>();
          partialOrder.put(c, after);
        }
        for (int j = i + 1; j < triplet.length; j++) {
          after.add(triplet[j]);
        }
      }
    }
    transitiveClosure(partialOrder);
    final int length = characters.size();
    final char[] secret = new char[length];
    for (final Map.Entry<Character, Set<Character>> entry : partialOrder.entrySet()) {
      secret[length - entry.getValue().size() - 1] = entry.getKey();
    }
    return String.valueOf(secret);
  }

  private static  <E> void transitiveClosure(final Map<E, Set<E>> partialOrder) {
    boolean changed = false;
    for (final Set<E> oldValues : partialOrder.values()) {
      final Set<E> newValues = new HashSet<>();
      for (final E oldValue : oldValues) {
        newValues.addAll(partialOrder.get(oldValue));
      }
      changed |= oldValues.addAll(newValues);
    }
    if (changed) {
      transitiveClosure(partialOrder);
    }
  }






}



