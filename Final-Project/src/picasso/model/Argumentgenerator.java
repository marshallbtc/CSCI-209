/**
 * Author: Nobel
 * 
 * Generates a random expression using RandomExpgenerator and recursive algorthims
 */

package picasso.model;

import java.util.Random;

/*
 * Creates a class that generates a random expression
 */
public class Argumentgenerator {

	
	//Initialize desired functions, identifiers, operations for exp generation
	private final static char[] Identifier = {'x','y'};
	private static Random rand = new Random();
	private final static String[] unarylst = {"sin","cos","log","abs","ceil","floor","atan","wrap","RgbToYCrCb","YCrCbtoRGB"};
	private final static String[] Multilst = {"perlinColor","perlinBw"};
	private static char[] Operandarr = {'+','-','*','^'};
	
	
	//Initialize the unary and multifunction expression generators
	private static RandomExpgenerator unary = new RandomExpgenerator(unarylst);
	private static RandomExpgenerator Multifunc = new RandomExpgenerator(Multilst);
	
	public Argumentgenerator() {
		
	
		
	}
	
	/**
	 * @param:recursed,depth
	 * @return: random expression 
	 */
	public static String generateUnaryexpression(int depth, boolean recursed) {



	//the below 2 lines are not necessary, but helpful for quickly changing bounds if necessary
	int lowerBound = 2;
	int upperBound = 10;
	int path1 = rand.nextInt(upperBound-lowerBound);
	path1 = path1 + lowerBound;


	if (path1==9) {

		
		return "x";
		
	}
	
	
	//If the depth is more than one, then there is still room to recurse, so do the recursive functions
	if (depth >1) {


	//for each of the paths, recurse but with decreased depth to control expression size

	if(path1==4||path1 ==3||path1 ==2){

		
		
		return unary.getExpression() + "(" +Argumentgenerator.generateUnaryexpression(depth-1,true) +")";
	}
	
	if(path1==5||path1==6||path1==7&&recursed) {
		
		
		return unary.getExpression() + "(" + Argumentgenerator.generateUnaryexpression(depth-1,true)+ ")" + Operandarr[rand.nextInt(Operandarr.length)] +  Argumentgenerator.generateUnaryexpression(depth-1,true); 
		
	}

	if(path1==6||path1==7 && !recursed) {

		
		
		return Argumentgenerator.generateMultiexpression(3);
		
	}
	
	
	}
	
	
	return "y";
	}

	

	
	
	
	public static String generateMultiexpression(int depth) {


		//the below 2 lines are not necessary, but helpful for quickly changing bounds if necessary
		int lowerBound = 1;
		int upperBound = 6;
		int path2 = rand.nextInt(upperBound-lowerBound);
		path2 = path2 + lowerBound;


		//same structure for multi, except we don't want to recurse
		if (depth >1) {

		
		if(path2==4||path2 ==3||path2 ==2){
			
			
			return Multifunc.getExpression() + "(" +Identifier[rand.nextInt(Identifier.length)] +','+Identifier[rand.nextInt(Identifier.length)]+ ')';
		}
		if(path2==5) {
			
			
			return Multifunc.getExpression() + "(" +Identifier[rand.nextInt(Identifier.length)] +','+Identifier[rand.nextInt(Identifier.length)]+ ')'+ Operandarr[rand.nextInt(Operandarr.length)]+Argumentgenerator.generateMultiexpression(depth-1);
			
		}
		
		

		}
		
		
		return Multifunc.getExpression() + "(" +Identifier[rand.nextInt(Identifier.length)] +','+Identifier[rand.nextInt(Identifier.length)]+ ')' ;
		
		
	
	}
	
	
	
	
	

}

