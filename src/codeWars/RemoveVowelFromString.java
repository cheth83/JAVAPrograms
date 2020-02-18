package codeWars;

public class RemoveVowelFromString {
  public static void main(String[] args) {

    Vowel v = new Vowel();

    String str = "asnfsdn dbxvoiadkj,z. casfkcjnzopcln, sdxc ";
    String strWithOutVowels = v.removeVowel1(str);

    System.out.println("old string: " + str);
    System.out.println("new string: " + strWithOutVowels);


  }
}

class Vowel {

  public String removeVowel1(String str) {
    return str.replaceAll("(?i)[aeiou]", "" );
  }

  public String removeVowel(String str) {
    String newStr = new String();
    for (int i = 0; i <str.length(); i++) {
      switch (str.charAt(i)) {
        case 'A' : case 'a' :
        case 'E' : case 'e' :
        case 'I' : case 'i' :
        case 'O' : case 'o' :
        case 'U' : case 'u' :
          break;
        default:
          newStr = newStr.concat(Character.toString(str.charAt(i)));
          break;
      }
    }
    return newStr;
  }
}