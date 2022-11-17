/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author marshalljones
 *
 * This class represents the unary function for exponentiation. 
 * It evaluates e^parameter.
 */
public class Exp extends UnaryFunction {

	/**
	 * @param param
	 */
	public Exp(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double e = 2.71828;
		
		double red = Math.pow(e, result.getRed());
		double green = Math.pow(e, result.getGreen());
		double blue = Math.pow(e, result.getBlue());

		return new RGBColor(red, green, blue);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Exp)) {
			return false;
		}
		Exp e = (Exp) obj;
		return param.equals(e.param);
	}

}
