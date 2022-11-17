/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import picasso.model.*;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author mesomaokolocha
 *
 */
public class PicString extends ExpressionTreeNode {
	private ImageFunctions image;
	/**
	 * 
	 */
	public  PicString(String name) {
		image = new ImageFunctions(name);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		Dimension size;
		try {
			size = image.getSize();
		}catch(NullPointerException e) {
			return new RGBColor(-1,-1,-1);
		}
		int newX = image.domainToImageScale(x,image.getSize().width-1);
		int newY =image.domainToImageScale(y, image.getSize().height-1);
		return new RGBColor(image.getColor(newX, newY));
		
	}

}
