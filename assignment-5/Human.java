
import java.awt.*;

/**
 * Represents a Human in the Game
 *
 * @author Chuck C. Liang, modified by Sara Sprenkle (mostly refactoring; some simplification)
 */
class Human extends GamePiece {

	private int dx;
	private int dy;
	private static final int STEP = 4; // movement default step in pixels

	public Human(int x, int y, Graphics g) {
		super(x, y, g);
		// change the following to location of file:
		img = Toolkit.getDefaultToolkit().getImage( imgDir + "running_dude.gif");
		img_width = 30;
		char_width = 26;
	}

	/**
	 * Moves the Human based on the direction specified
	 */
	@Override
	public void move(Game game) { // will wrap around edges of window
		xcoord = xcoord + dx;
		if (xcoord < 0 ) {
			//System.out.println(xcoord);
			xcoord = Game.XBOUND - img_width;
		}
		if (xcoord > Game.XBOUND - img_width) {
			//System.out.println(xcoord);
			xcoord = 0;
		}
		ycoord = ycoord + dy;
		if (ycoord < Game.YMIN_DISPLAY) {
			//System.out.println(ycoord);
			ycoord = Game.YBOUND - img_width;
		}
		if (ycoord > Game.YBOUND - img_width ) {
			//System.out.println(ycoord);
			ycoord = Game.YMIN_DISPLAY;
		}
	}

	/**
	 * @return the change in x, in pixels
	 */
	public int getChangeInX() {
		return dx;
	}

	/**
	 * @return the change in y, in pixels
	 */
	public int getChangeInY() {
		return dy;
	}

	/**
	 * Sets which direction Human should go in
	 * 
	 * @param horizontalDirection
	 *            : -1 means left, 1 means right, 0 means no horizontal movement
	 * @param verticalDirection
	 *            : -1 means up, 1 means down, 0 means no vertical movement
	 */
	public void setDirection(int horizontalDirection, int verticalDirection) {
		dx = horizontalDirection * STEP;
		dy = verticalDirection * STEP;
	}

	@Override
	public Human clone() throws CloneNotSupportedException {
		return (Human) super.clone();
	}

}
