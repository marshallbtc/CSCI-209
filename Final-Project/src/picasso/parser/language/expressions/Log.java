package picasso.parser.language.expressions;


import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Log function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class Log extends UnaryFunction {

	/**
	 * Create a floor expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Log(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the log of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(Math.abs(result.getRed()));
		double green = Math.log(Math.abs(result.getGreen()));
		double blue = Math.log(Math.abs(result.getBlue()));

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Log)) {
			
			return false;
			
		}
		Log f = (Log) obj;
		return param.equals(f.param);
	}

}
