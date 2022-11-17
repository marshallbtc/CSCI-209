/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class PerlinColor extends MultiArgumentFunction {

	/**
	 * @param first
	 * @param second
	 */
	public PerlinColor(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first,second);
		// TODO Auto-generated constructor stub
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double red = ImprovedNoise.noise(left.getRed() + 0.3, right.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(left.getBlue() + 0.1, right.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(left.getGreen() - 0.8, right.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}

}
