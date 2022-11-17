/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class RgbToYCrCb extends UnaryFunction {

	/**
	 * @param param
	 */
	public RgbToYCrCb(ExpressionTreeNode param) {
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
	
		
		double red = result.getRed() * 0.2989 + result.getGreen() * 0.5866 + result.getBlue() * 0.1145;
		double green = result.getRed() * -0.1687 + result.getGreen() * -0.3312 + result.getBlue() * 0.5;
		double blue = result.getRed() * 0.5000 + result.getGreen() * -0.4183 + result.getBlue() * -0.0816;
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
		if (!(obj instanceof RgbToYCrCb)) {
			return false;
		}
		RgbToYCrCb a = (RgbToYCrCb) obj;
		return param.equals(a.param);
	}


}
