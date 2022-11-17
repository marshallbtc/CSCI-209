/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author marshalljones
 *
 */
public class Modulus extends BinaryOperator {

	/**
	 * @param first
	 * @param second
	 */
	public Modulus(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		
		double red = 0;
		double green = 0;
		double blue = 0;
		
		try {
			red = left.getRed() % right.getRed();
		} catch (Exception e) {
			throw new ParseException("Error: Cannot Divide by 0");
		}
		
		try {
			green = left.getGreen() % right.getGreen();
		} catch (Exception e) {
			throw new ParseException("Error: Cannot Divide by 0");
		}
		
		try {
			blue = left.getBlue() % right.getBlue();
		} catch (Exception e) {
			throw new ParseException("Error: Cannot Divide by 0");
		}
		
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperator() {
		return "%";
	}

}
