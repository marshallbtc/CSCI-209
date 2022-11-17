/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class ImageClip extends MultiArgumentFunction {


	/**
	 * @param image
	 * @param first
	 * @param second
	 */
	ImageFunctions image;
	public ImageClip(String Filename,ExpressionTreeNode first, ExpressionTreeNode second) {
		super(first, second);
		//create image class
		image = new ImageFunctions(Filename);
		// TODO Auto-generated constructor stub
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor left = first.evaluate(x, y);
		RGBColor right = second.evaluate(x, y);
		double xcoord = MathHelp.clampvalue(left.getBlue());
		double ycoord = MathHelp.clampvalue(right.getBlue());
		
		int newX = image.domainToImageScale(xcoord,image.getSize().width-1);
		int newY =image.domainToImageScale(ycoord, image.getSize().height-1);
		return new RGBColor(image.getColor(newX, newY));
	}


}
