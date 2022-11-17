//import java.lang.String;
import java.lang.StringBuilder;
import java.util.Scanner;


/**
 * Prompts user for a phrase and determines if the given phrase is a
 * palindrome.
 * 
 * @author Marshall Jones
 */
public class StringUtilities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String string = sc.nextLine();
        sc.close();
        
        if (isPalindrome(string)) {
            System.out.println("Your phrase is a palindrome!");
        } else {
            System.out.println("Your phrase is not a palindrome.");
        }
    }

    /**
    * Reverses the given string.
    * @param string the String to reverse
    * @return the string backwards; e.g., "stars" --> "srats"
    */
    public static String reverseString(String string) {
        StringBuilder str = new StringBuilder();
        str.append(string);
        StringBuilder newStr = str.reverse();
        return newStr.toString();
    }

    /**
    * Tests if a string is a palindrome.  A palindrome is a word
    * that is the same forwards and backwards (ignoring spaces and casing).
    * Some palindromes: 
    * "kayak"
    * "A man A plan A canal Panama"
    *
    * You should consider upper and lower case letters as the same.
    * 
    * However, you don't need to consider punctuation as special cases,
    * i.e., "A man. A plan. A canal. Panama." will return false.
    *
    * @param s the String to test if it's a palindrome
    * @return true if the String is a palindrome
    * @see http://www.palindromelist.com
    */
    public static boolean isPalindrome(String string) {
        string = string.toLowerCase();
        string = string.replaceAll(" ", "");
        //return string.equals(reverseString(string)); //more concise
        if (string.equals(reverseString(string))) {
            return true;
        } else {
            return false;
        }
    }


}
