// import IntStream to make summing integers in an array easy
import java.util.stream.IntStream;

/**
 * A Java class that inherits Birthday.java and
 * represents the Birthday Paradox.
 */
public class BirthdayParadox {

    // ------ Instance Variables ------
    /* the number of people in a trial */
    private int nPeople;

    /* the number of times to run the test */
    private int nTrials;

    /* the array of birthdays in a trial */
    private String[] birthdayArray;

    // ------ Class Variables ------

    /**
     * Create a new BirthdayParadox object with the characteristics
     * as specied by the parameters.
     * @param nPeople the number of people to include in a trial
     * @param nTrials the number of times to run the test on a set of people
     */
    public BirthdayParadox(int nPeople, int nTrials) {
        this.nPeople = nPeople;
        this.nTrials = nTrials;
        this.birthdayArray = new String[nPeople];
    }
    
    // ------ Accessor Methods ------
    /**
     * Returns the Birthday Paradox nPeople, as an integer
     * 
     * @return the number of people in the object's trial
     */
    public int getNPeople() {
        return this.nPeople;
    }

    /**
     * Returns the Birthday Paradox nTrials, as an integer
     * 
     * @return the number of times the test is run
     */
    public int getNTrials() {
        return this.nTrials;
    }
    
    // ------ Mutator Methods ------
    /**
     * Runs a Birthday Paradox trial, filling the birthdayArray
     * with results
     */
    public void runTrial() {
        for ( int i = 0; i < birthdayArray.length; i++ ) {
            Birthday birthday = new Birthday();
            birthdayArray[i] = birthday.toString();
        }
    }

    // ------ Setter Methods ------
    /**
     * Sets the number of people in a trial
     * 
     * @param p the number of people in a trial, as an integer
     */
    public void setNPeople(int p) {
        nPeople = p;
    }

    /**
     * Sets the number of trials to run
     * 
     * @param t the number of trials to run, as an integer
     */
    public void setNTrials(int t) {
        nTrials = t;
    }

    public static void main(String[] args) {
        int nTrials = 30;
        if (args.length > 0) { nTrials = Integer.parseInt(args[0]); }
        int nSets = 20;
        int increment = 5;

        /* the array of results in all the trial sets */
        int[] setArray = new int[nSets];

        /* print the output table heading */
        String headingFormat = "%8s   %8s   %10s   %10s";
        String headings = String.format(headingFormat, "# People", "# Trials", "# Positive", "% Positive");
        String lines = String.format(headingFormat, "--------", "--------", "----------", "----------");
        System.out.println(headings);
        System.out.println(lines);

        /* loop through nSets (20) trial sets */
        for ( int count = nSets; count >=1; count-- ) {
            /* Initialize a BirthdayParadox object that starts with 5 people. 
            Increment by 5 every set. */
            BirthdayParadox paradox = new BirthdayParadox((21-count)*increment, nTrials);

            /* the array of results in a round of trial sets */
            int[] trialArray = new int[nTrials];
            
            /* one trial set contains nTrials (30) trials */
            for ( int trialSet = nTrials; trialSet >= 1; trialSet-- ) {
                
                paradox.runTrial();
                /* nested for loop determines if the trial had any matches */
                for ( int i = 0; i < paradox.birthdayArray.length; i++ ) {
                    for ( int j = i+1; j < paradox.birthdayArray.length; j++ ) {
                        // if two birthdays are the same,
                        if ( paradox.birthdayArray[i].equals(paradox.birthdayArray[j]) ) {
                            // set the trial's location in trialArray equal to 1.
                            trialArray[nTrials-trialSet] = 1;
                        }
                    }
                }
            }
            /* add the sum of positive trials to the setArray array */
            int posTrials = IntStream.of(trialArray).sum();
            double percentPos = ((double) posTrials/paradox.nTrials)*100;
            setArray[nSets-count] = posTrials;
            System.out.printf("%8d %10d %12d", paradox.nPeople, paradox.nTrials, posTrials);
            System.out.printf("%12.1f%%\n", percentPos);
        }
    }
}