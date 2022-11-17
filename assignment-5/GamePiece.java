import java.awt.*;

/**
 * The base class for GamePieces that are displayed on the game panel.
 *
 * @author Chuck C. Liang, modified by Sara Sprenkle (mostly refactoring; some simplification)
 */
public abstract class GamePiece implements Cloneable {
	protected Image img; // animated gif
	protected int xcoord, ycoord; // coordinates of top-left corner

	/** size of the image */
	protected int img_width; // may need to fine tune

	/** size of the character inside the image */
	protected int char_width; // may need to fine tune

	private Graphics brush;

        /**
	 * Location of the image files. When using Eclipse, use bin/. Without
	 * Eclipse structure, use ./
	 */
	protected static String imgDir = "./";

	public GamePiece(int x, int y, Graphics g) {
		xcoord = x;
		ycoord = y;
		brush = g;
	}

	// ------------------- accessor methods -------------------
	public final int getXPos() {
		return xcoord;
	}

	public final int getYPos() {
		return ycoord;
	}

	public final int getImageWidth() {
		return img_width;
	}

	public final int getCharacterWidth() {
		return char_width;
	}

	/**
	 * Draws the GamePiece on the canvas
	 */
	public final void draw() {
		brush.drawImage(img, xcoord, ycoord, null);
	}

	/**
	 * Moves the object to the next spot (nothing for this class)
	 * 
	 * @param game
	 *            - provides access to information about the other 'pieces' in
	 *            the game
	 */
	public abstract void move(Game game);

	@Override
	public GamePiece clone() throws CloneNotSupportedException {
		return (GamePiece) super.clone();
	}

}
