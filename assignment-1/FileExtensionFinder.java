import java.util.Scanner;

/**
 *
 */
public class FileExtensionFinder {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter your filename: ");
      String filename = sc.nextLine();
      sc.close();
      int i = filename.lastIndexOf('.');
      String ext = filename.substring(i+1);
      System.out.println("Your file is a(n) " + ext + " file.");
    }
  
  /* TODO: When you're ready to get user input, 
  put these next four lines of code (uncommented) in your main method. */ 
  // Scanner sc = new Scanner(System.in);
  // System.out.print("Enter your filename: ");
  // String filename = sc.nextLine();
  // sc.close();

}
