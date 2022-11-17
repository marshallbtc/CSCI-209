/**
 * Original program contains errors.
 * @author Marshall Jones
 *
 * Document the problems you found in comments, i.e., describe what
 * caused the problem in comments.  Make clear that you understand the
 * issues and.  Comment out the original and write the corrected code.
 * 
 * Make as few changes to the code as necessary to make the code work.
 */
public class Assign4 {

    // instance variable
    //public int oneVar;
    //It's better to use the private access modifier here because
    //the Assign4 class is the only class that needs to access it.
    private int oneVar;

    // constructor
    //public Assign( param ) {
    //Error: constructor method must have same name as class
    //Error: parameter must have specified type
    public Assign4(int param) {
        //oneVar = param;
        //return this;
        //Error3: constructor should not return anything. Must use
        //'this' for the constructed object when assigning it a value.
        this.oneVar = param;
    }

    // an accessor method
    //public getOneVar() {
        //return oneVar;
    //Compiler error. Need a return type in method 
    //declaration and 'this' keyword because it refers to 
    //the class object.
    public int getOneVar() {
        return this.oneVar;
    }

    // a mutator method
    //public int increment() {
    //Error: mutator method should use void as parameter because 
    //there is no returned value.
    public void increment() {
        oneVar++;
    }
    
    public static void main(String[] args) {
        //Assign4 assign4Var = Assign4(8);
        //Error: must include keyword 'new' when invoking an instance
        //of an object
        Assign4 assign4Var = new Assign4(8);

        //System.out.println("assign4Var's oneVar is " + assign4Var.getOneVar);
        //Error: getOneVar is a method. Must include parentheses when calling it.
        System.out.println("assign4Var's oneVar is " + assign4Var.getOneVar());

	//assign4Var.increment();
    //Error: must be indented into the main method's block
        assign4Var.increment();
	
        int actualValue = assign4Var.getOneVar();
        int expectedValue = 9;

	//System.out.println("assign4Var's incremented oneVar is " + actualValue);
    //Error: must be indented into the main method's block
        System.out.println("assign4Var's incremented oneVar is " + actualValue);

	
        if( actualValue != expectedValue ) {
            System.out.println("Error incrementing oneVar!");   
        }
    }

}
