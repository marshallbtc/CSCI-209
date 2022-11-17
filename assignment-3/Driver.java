import java.util.Scanner;

/**
 * Prompts user for a phrase and determines if the given phrase is a
 * palindrome.
 * 
 * @author Marshall Jones
 */
public class Driver {

    public static void main( String args[] ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This program determines if a word or phrase is a palindrome.\n");
        System.out.print("What is the potential palindrome? ");
        String pal = sc.nextLine();
        sc.close();

        if (StringUtilities.isPalindrome(pal)) {
            System.out.println(pal + " is a palindrome.");
        } else {
            System.out.println(pal + " is not a palindrome.");
        }
    }


}
