/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author marshalljones
 *
 */
public class Negate extends UnaryOperator {

	/**
	 * Create a Negation operator that returns the negated value of the given parameter
	 * 
	 * @param param
	 */
	public Negate(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		double negate = -1.0;
		RGBColor result = param.evaluate(x, y);
		double red = negate*(result.getRed());
		double green = negate*(result.getGreen());
		double blue = negate*(result.getBlue());

		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperator() {
		return "!";
	}

}
