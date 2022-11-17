package picasso.parser.language.expressions;

public class MathHelp {
	public static double wrapvalue(double test) {
		
		double result = 0;
		if (test > 1) {
			while (test > 1) {
				test -= 2;
			}

			
			result = (test);
		}
		if (test < -1) {
			while (test < -1) {
				test += 2;
			}
			
			
			result = ((test));
		} else {
			result = test;
		}
		return result;
	}
	
	public static double clampvalue(double test) {
		
		double result = 0;
		if (test > 1) {
			test = 1;
			result = (test);
		} else if (test < -1) {
			test = -1;
			result = (test);
		} else {
			result = test;
		}
		return result;
		
	}

}

