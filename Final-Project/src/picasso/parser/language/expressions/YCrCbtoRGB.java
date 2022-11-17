/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class YCrCbtoRGB extends UnaryFunction {

	/**
	 * @param param
	 */
	public YCrCbtoRGB(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the absolute
	 * value of the function's parameter.
	 * 
	 * @return the color from evaluating the absolute value of the expression's
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() + result.getBlue() * 1.4022;
		double green = result.getRed() + result.getGreen() * -0.3456 + result.getBlue() * -0.7145;
		double blue = result.getRed() + result.getGreen() * 1.7710;
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
		if (!(obj instanceof YCrCbtoRGB)) {
			return false;
		}
		YCrCbtoRGB a = (YCrCbtoRGB) obj;
		return param.equals(a.param);
	}



}
