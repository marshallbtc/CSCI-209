import java.util.Random;

/**
 * A Java class that represents a birthday. The state of the
 * birthday is its month and day.
 * 
 * @author Marshall Jones
 */

public class Birthday {

    // ------ Instance variables ------
    /* the month of the birthday */
    private int month;

    /* the day of the birthday month */
    private int day;

    // ------ Class Variables ------
    /* the number of days in each month, January - December */
    public static final int[] monthArray = new int[]{ 31,29,31,30,31,30,31,31,30,31,30,31 };

    /* the random generator */
    private static final Random rand = new Random();

    /**
     * Create a new birthday object with the characteristics as
     * specified by the parameters.
     * 
     * @param month the month of the birthday
     * @param day the day of the month
     */
    public Birthday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    /**
     * Default birthday object is generated randomly. No 
     * parameters.
     */
    public Birthday() {
        this.month = rand.nextInt(11) + 1;
        this.day = rand.nextInt(monthArray[month - 1]) + 1;
    }
    
    // ------ Accessor Methods ------
    /**
     * Returns the birthday month, as an integer
     * 
     * @return the month of the birthday, as an integer
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Returns the day of the birthday month, as an integer
     * 
     * @return the day of the birthday month, as an integer
     */
    public int getDay() {
        return this.day;
    }
    // ------ Mutator Methods ------

    // ------ Setter Methods ------
    /**
     * Sets the month of the birthday
     * 
     * @param m the month of the birthday, as an integer
     */
    public void setMonth(int m) {
        month = m;
    }

    /**
     * Sets the day of the birthday month
     * 
     * @param d the day of the birthday month, as an integer
     */
    public void setDay(int d) {
        day = d;
    }

    /**
     * Returns a string representation of the birthday.
     * Format:
     * <br/>Birthday: &lt;month/day&gt;
     * <p>The date's month and day are each displayed with two digits
     * @return a string representation of this birthday
     */
    @Override
    public String toString() {
        StringBuilder rep = new StringBuilder("Birthday: ");
        rep.append(String.format("%02d",month));
        rep.append("/");
        rep.append(String.format("%02d",day));
        return rep.toString();
    }

    /**
     * Determines if the Object o is equivalent to this Birthday, 
     * based on its month and day.
     * @param o the object to compare
     * @return true if this object is the same as the o argument (by month and day).  Otherwise, returns false. 
     */
    @Override
    public boolean equals(Object o) {
        // Follows the _Effective Java_ process
        if( o == this ) {
            return true;
        }

        if( ! ( o instanceof Birthday ) ) {
            return false;
        }

        Birthday other = (Birthday) o;

        if( other.getMonth() != this.getMonth() ) {
            return false;
        }

        if( other.getDay() != this.getDay() ) {
            return false;
        }

        return true;
    }

    /**
     * @param args
     *            the command-line arguments
     */
    public static void main(String[] args) {
        int april = 4;
        Birthday birthday = new Birthday(april, 16);

        System.out.println(birthday);

        if ( birthday.getMonth() != april ) {
            System.err.println("Problem likely in constructor setting month");
        }

        String expectedRep = "Birthday: 04/16";
        String actualRep = birthday.toString();

        // Test the toString method
        if ( ! actualRep.equals(expectedRep) ) {
            System.err.println("Problem with toString method");
            System.err.println("\tActual: " + actualRep);
            System.err.println("\tExpected: " + expectedRep);
        } else {
            System.out.println("Great syntax!");
        }

        Birthday trivialMatch = birthday;

        // Test the equals method
        if ( ! birthday.equals(trivialMatch) ) {
            System.err.println("Problem in equals");
            System.err.println("\tActual: " + birthday.equals(trivialMatch) );
            System.err.println("\tExpected: " + true);
        } else {
            System.out.println("Looks like the equals method works!");
        }

        System.out.println("\nNow testing the Birthday class without parameters");
        Birthday randomBirthday = new Birthday();

        System.out.println(randomBirthday);

        // No need to test the toString method again

        Birthday randomMatch = randomBirthday;

        // Test the equals method again for good measure
        if ( ! randomBirthday.equals(randomMatch) ) {
            System.err.println("Problem in equals");
            System.err.println("\tActual: " + randomBirthday.equals(randomMatch) );
            System.err.println("\tExpected: " + true);
        } else {
            System.out.println("Looks like the equals method works!");
        }
    
    }
}