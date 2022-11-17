/**
 * Original program contains errors.
 * Add your name to this comment.
 *
 * Document the errors you found in comments.  You should find at
 * least 4 errors.  Some errors are compiler errors and some are
 * logic errors that you'll find by executing/testing the program.
 * 
 * Comment out the original code and write the corrected code.  In
 * comments, explain the error and what you did to fix the error.
 */
//public class Assign
/** 2 compiler errors in the above line. A bracket was missing, 
 * and the class name did not match the file name.
 */
public class Assign0 {
    //static void main(String[] args) {
    /** Syntax error in the above line. Must specify the method as 
     * public so that the class can access it.
     */
    public static void main(String[] args) {
        
        //System.out.println("When you add " + 1 + " and  + 2); 
        /** Compiler error "Unclosed string literal" in the above 
         * line. A quotation was missing. 
         */
        System.out.println("When you add " + 1 + " and " + 2); 

        System.out.println("You get: " + (1 + 2));
                           
    }
}
