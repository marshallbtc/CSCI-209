
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class Addition extends BinaryOperator {

	/**
	 * @param first
	 * @param second
	 */
	public Addition(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double red = left.getRed()+ right.getRed();
		double green = left.getGreen()+ right.getGreen();
		double blue = left.getBlue()+ right.getBlue();

		return new RGBColor(red, green, blue);
	}
	
	@Override
	public String getOperator() {
		return "+";
	}
	

}
