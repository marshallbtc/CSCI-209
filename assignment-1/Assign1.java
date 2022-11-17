/**
 * Original program contains errors.
 * Add your name to this comment.
 *
 * Document the errors you found in comments.  You should find at
 * least 5 errors.  Some errors are compiler errors and some are
 * logic errors that you'll find by executing/testing the program.
 * 
 * Comment out the original code and write the corrected code.  In
 * comments, explain what you did to fix the error.
 */
public class Assign1 {

    public static void main(String[] args) {
        int firstI, secondI;
        //double firstD; secondD;
        //Compiler error in above line due to use of semicolon 
        //instead of a comma.
        double firstD, secondD;

        //int firstI = 5;
        //Compiler error in above line because firstI was already
        //defined as an integer. Declaring "int" again is unneeded.
        firstI = 5;
        secondI = 10;
        System.out.println("When you add " + firstI + " and " + secondI); 
        //System.out.println("You get: " + (firstD + secondI));
        //Non-initialized variable compiler error led to discovery of
        //mistake in addition. Should be adding firstI and secondI.
        System.out.println("You get: " + (firstI + secondI));
     
        firstD = 3.12;

        //System.out.println("When you add " + firstD + " and " + secondD);
        //Compiler error due to attempt to print a variable before it was
        //assigned a value. Line needs to go below assignment of secondD.

        secondD = 7.4;  

        System.out.println("When you add " + firstD + " and " + secondD);

        //System.out.println("You get: " + firstD + secondD);
        //Syntax error. The compiler interprets firstD and secondD as 
        //strings unless enclosed in parentheses.
        System.out.println("You get: " + (firstD + secondD));

	String original = "walrus";
	char first = original.charAt(0);
	char second = original.charAt(2);
	char third = original.charAt(4);

	System.out.println( first + second + third );
    /**
     * Professor Sprenkle, I see that the above line will print out wlu.
     * I did not change the code to do so because I don't see instructions
     * to do so.
     */
	
    }
}
