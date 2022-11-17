package picasso.model;

import java.util.Random;

public class RandomExpgenerator {
	
	private final Random rand = new Random();
	private String[] randomlst;
	
	public RandomExpgenerator(String[] Randomlst) {
		
		
		
			this.randomlst = Randomlst;
		
		
	}
	


	public  String getExpression() {
		
		
		return randomlst[rand.nextInt(randomlst.length)];
		
		
	}
	

}
