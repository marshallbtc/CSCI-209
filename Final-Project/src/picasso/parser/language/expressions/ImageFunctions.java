/**
 * 
 */
package picasso.parser.language.expressions;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import picasso.view.commands.Evaluater;
import picasso.model.*;

/**
 * @author mesomaokolocha
 *
 */
public class ImageFunctions {
	
	public static final Color DEFAULT_COLOR = Color.BLACK;
	String filename;
	private BufferedImage myImage;
	private Dimension mySize;

	/**
	 * 
	 */
	public ImageFunctions(String filename ) {
		// TODO Auto-generated constructor stub
		this.filename = filename;
		try {
			myImage = ImageIO.read(new File(filename));
			mySize = new Dimension(myImage.getWidth(), myImage.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public Color getColor(int x, int y) {
		if (isInBounds(x, y))
			return new Color(myImage.getRGB(x, y));
		else
			return DEFAULT_COLOR;			
	}
	public boolean isInBounds(int x, int y) {
		return (0 <= x && x < mySize.width) && (0 <= y && y < mySize.height);
	}
	
	public int domainToImageScale (double value , int bounds) {
		double range = Evaluater.DOMAIN_MAX - Evaluater.DOMAIN_MIN;
		return (int) (((value - Evaluater.DOMAIN_MIN)/range)*bounds);
	}
	
	public Dimension getSize() {
		return new Dimension(mySize);
	}
	
	
}
