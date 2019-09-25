import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    try {
      FileInputStream file = new FileInputStream("C:\\Users\\ty121\\desktop\\test.txt");
      StringBuilder sB = new StringBuilder();
      Scanner scanner = new Scanner(file);
      while (scanner.hasNext()) {
      sB.append(scanner.nextLine());
      }
      String str = sB.toString();
      String str1 = "public class Test {public static void main(String[] Args) {System.out.println(Hello World!); }}";
      String str2 = "(sum + 47) / total";
      Lex(str);
    } catch (Exception e) {
      System.out.println("error: File not found");
    }
  }
  public static void Lex(String s) {
    char nextChar;
    char cChar;
    String newSub;
    int lastParse = 0;

    for(int i = 0; i < s.length(); i++) {
      if (i < s.length() - 1){
        nextChar = s.charAt(i+1);
      } else {
        nextChar = s.charAt(i);
      }
      cChar = s.charAt(i);
      if (isAlpha(cChar) && !(isAlpha(nextChar)) && !(isNum(nextChar))) {
        newSub = s.substring(lastParse, i+1);
        System.out.printf("The next token is: IDENT, the next lexeme is %s%n", newSub);
        lastParse = i+1;
      } else if(isNum(cChar) && !(isAlpha(nextChar)) && !(isNum(nextChar))) {
        newSub = s.substring(lastParse, i+1);
        System.out.printf("The next token is: INT_LIT, the next lexeme is %s%n", newSub);
        lastParse = i+1;
      } else if (cChar == ' ') {
        lastParse = i+1;
      } else if (isSymb(cChar)) {
        newSub = s.substring(lastParse, i+1);
        System.out.printf("The next token is %s, the next lexeme is %s%n ", symbSearch(cChar),newSub); 
        lastParse = i+1;
      } else {
        System.out.print("");
      } 
    }
  }   
    //   }else if (!isSymb(cChar))
    //     System.out.println("error: Lexeme unknown");
    // }

  
  public static boolean isAlpha(char c) {
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k', 'l','m','n', 'o', 'p','q','r','s','t','u','v', 'w', 'x','y','z'};
    for (char i: alphabet) {
      if (c == i) return true;
    }
    return false;
  }
  public static boolean isNum(char c) {
    char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9'};
    for (char i : digits) {
      if (c == i) return true;
    }
    return false;
  }
  public static boolean isSymb(char c) {
    switch (c){
      case '(':
        return true;
      case ')':
        return true;
      case '+':
        return true;
      case '-':
        return true;
      case '*':
        return true;
      case '/':
        return true;
      case ' ':
        return true;
      default:
        return false;
    }
  }
  public static String symbSearch(char c) {
    String nextToken;
    switch (c){
      case '(':
      nextToken = "LEFT_PAREN";
      break;
      case ')':
      nextToken = "RIGHT_PAREN";
      break;
      case '+':
      nextToken = "ADD_OP";
      break;
      case '-':
      nextToken = "SUB_OP";
      break;
      case '*':
      nextToken = "MULT_OP";
      break;
      case '/':
      nextToken = "DIV_OP";
      break;
      case '[':
      nextToken = "LEFT_BRACKET";
      break;
      case ']':
      nextToken = "RIGHT_BRACKET";
      break;
      default:
      nextToken = " ";
      break;
    }
    return nextToken;
  }
}