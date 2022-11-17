package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Wrap extends UnaryFunction {

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = MathHelp.wrapvalue(result.getRed());
		double green = MathHelp.wrapvalue(result.getGreen());
		double blue = MathHelp.wrapvalue(result.getBlue());

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
		if (!(obj instanceof Wrap)) {

			return false;

		}
		Wrap f = (Wrap) obj;
		return param.equals(f.param);
	}

}
