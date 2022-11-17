/**
 * 
 */
package picasso.model;

import java.util.Random;

/**
 * @author manayen23
 * Generates a random function from a given array of random functions
 */
public abstract class Expgenerator{
	
 
	//initialize the random, generated string and the randomlst
	private Random rand;
	private String generated;
	private String[] randomlst;
	
	
	
	
	/**
	 * @param random
	 * @param randomlst
	 * @return generated
	 */
	public Expgenerator(Random random, String[] randomlst) {
		//generate a random "function" from the set of functions in the randomlst
				
		rand = random;
		generated = randomlst[rand.nextInt(randomlst.length)];		
		
	}
	
	/**
	 * @return generated
	 * 
	 */
	public String toString() {
		
		return generated;
	}
	
}
	