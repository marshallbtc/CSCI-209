/**
 * Original program contains errors.
 * @author Marshall Jones
 *
 * Document (i.e., describe) the problems you found in comments.
 * Comment out the original and write the corrected code.  Add any
 * additional comments that help you explain what you did to fix the
 * code.
 * 
 * You may want to run this program with multiple command-line arguments, e.g., 
 *      java Assign2 cat dog bird
 *      java Assign2 cow
 */
import java.util.Arrays;
//Must import Arrays class in order to use sort function

public class Assign2 {

    public static void main(String[] args) {  
        //System.out.println("The length of command-line args is " + args.length() );
        //Compiler error. Length variable should be used instead of length() method
        //because args is an array, not a string object.
        System.out.println("The length of command-line args is " + args.length );

        if ( args.length > 2 ) {
            System.out.println("You have more than 2 arguments.");
        }

        //for( i=0; i < args.length; i++ ) {
        //Compiler error due to failure to identify i as an integer
        for(int i=0; i < args.length; i++ ) {
            //System.out.println("arg[" + i + "] is " + args[i] + " with length " + args.length );
            //Error in above line. Need to construct a string from the item of interest in the
            //array, then treat it like a string with the length() method.
            String s = args[i];
            System.out.println("arg[" + i + "] is " + args[i] + " with length " + s.length() );
        }

        Arrays.sort(args);
        //imported Arrays class at top of program

        System.out.println("The sorted command-line arguments are ");
        boolean hasACow = false;
        //Must initialize hasACow here so that the variable is available to the if statement
        //in line 63

        //for( i=0; i <= args.length; i++ ) {
        //Compiler error due to failure to identify i as an integer. Also should use < instead
        //of <= in the for loop because the index of the array starts with 0. Using = leads to
        //an out of bounds index.
        for(int i=0; i < args.length; i++ ) {
            System.out.println("\t" + args[i] );
            //if args[i] == "cow" : 
            //Compiler error: improper syntax in if statement
            //Needs parentheses around conditional statement and braces around the consequent
            if (args[i] == "cow") {
                hasACow = true;
                //Removed boolean from above line because already initialized before for loop
            }
        }

        System.out.print("You ");
        if( ! hasACow ) {
            System.out.print("don't ");
        }
        System.out.println("have a cow, man.");
    }

}
