/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author marshalljones
 * 
 * This class represents the binary operator for exponentiation.
 * It evaluates left^right, where left and right are leaves of an expression tree.
 */

public class Exponentiation extends BinaryOperator {

	/**
	 * //@param first
	 * //@param second
	 */

	public Exponentiation(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
	}

	/**
	 * This method is the binary operator variation of exponentiate
	 * It evaluates left^right instead of e^parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double red = Math.pow(left.getRed(), right.getRed());
		double green = Math.pow(left.getGreen(), right.getGreen());
		double blue = Math.pow(left.getBlue(), right.getBlue());

		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperator() {
		return "^";
	}
}