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
public class PerlinBW extends MultiArgumentFunction {

	/**
	 * @param first
	 * @param second
	 */
	public PerlinBW(ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Generate Perlin noise based on the given values. Algorithm described in
	 * detail at this site:
	 * http://freespace.virgin.net/hugo.elias/models/m_perlin.htm
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double grey = ImprovedNoise.noise(left.getRed() + right.getRed(), left.getGreen() + right.getGreen(),
				left.getBlue() + right.getBlue());
		return new RGBColor(grey, grey, grey);
	}

}
