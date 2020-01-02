package set2;

public class CountCharacters {

  public static void main(String[] args) {

    String str = "wweedsewwwwwwsssd";
    String convertedString = "";

    if (str.isEmpty() == true) {
      System.out.println("String is empty");
      return;
    }
    System.out.println("Original string: " + str);

    for (int i = 0; i < str.length(); i++) {
      convertedString = convertedString.concat(Character.toString(str.charAt(i)));
      Integer count = 1;
      while (i < (str.length() - 1) && str.charAt(i) == str.charAt(i + 1)) {
        i++;
        count++;
      }
      convertedString = convertedString.concat(count.toString());
    }
    System.out.println("Converted string: " + convertedString);

//    Chethan: I tried to use character stream but couldn't get how to solve this problem
//    char[] charArray = str.toCharArray();
//    Stream<Character> charStream =
//    str.chars()
//    .mapToObj(ch -> (char) ch)
//    .forEach( i -> {
//      String cs = "";
//      cs = cs.concat(Character.toString(i));
//    });

    String convertToOriginalString = "";
    for (int i = 1; i <= convertedString.length(); i++) {
      if (i % 2 != 0) {
        convertToOriginalString = convertToOriginalString
            .concat(Character.toString(convertedString.charAt(i - 1)));
      } else {
        int len = Integer.parseInt(Character.toString(convertedString.charAt(i - 1)));
        for (int j = 1; j < len; j++) {
          convertToOriginalString = convertToOriginalString
              .concat(Character.toString(convertedString.charAt(i - 2)));
        }
      }
    }
    System.out.println("Converted to original string: " + convertToOriginalString);

    System.out.println(
        "Original & converted strings are " + (str.equals(convertToOriginalString) == true ? "matching"
            : "not matching"));


  }
}
