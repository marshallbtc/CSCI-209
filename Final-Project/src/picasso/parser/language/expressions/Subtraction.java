package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Armando Mendez
 *
 */
public class Subtraction extends BinaryOperator {

	/**
	 * @param first
	 * @param second
	 */
	public Subtraction(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double red = left.getRed()- right.getRed();
		double green = left.getGreen()- right.getGreen();
		double blue = left.getBlue()- right.getBlue();

		return new RGBColor(red, green, blue);
	}
	
	
	@Override
	public String getOperator() {
		return "-";
	}
	

}