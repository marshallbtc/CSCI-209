import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;

/**
 * A GUI game that involves a professor chasing treasure and goblins chasing the
 * professor.
 * 
 * @author Chuck C. Liang, modified by Sara Sprenkle (mostly refactoring; some simplification)
 */
public class Game extends JFrame implements KeyListener {
	private Graphics brush;
	private Graphics display;
	private Image canvas; // off-screen graphics buffer
	
	// the professor who is our hero
	private Human professor;
	// the goblin the professor is trying to avoid
	private Goblin goblin;
	// the treasure that the professor is trying to catch
	private Treasure treasure;

	public static final int XBOUND = 800; // img_width of window
	public static final int YMIN_DISPLAY = 20; // the top 20 pixels (or so) are cut off by the menu bar
	public static final int YBOUND = 600; // height of window
	
	private static final Color BG_COLOR = Color.black; // background color
	private static final int FDELAY = 30; // animation frame delay

	public static void main(String[] args) {
		Game game = new Game();
		game.animate();
	}
	
	public Game() {
		super();
		
		setBounds(0, 0, XBOUND, YBOUND);
		setTitle("Professor vs Goblin");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = createImage(XBOUND, YBOUND);

		brush = canvas.getGraphics();
		brush.setColor(BG_COLOR); // clear
		brush.fillRect(0, 0, XBOUND, YBOUND); // with black background
		
		display = this.getGraphics();

		addKeyListener(this);
		requestFocus(); // keys go to JFrame
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
	} // overrides auto-update

	public void clearBuffer() {
		Color old = brush.getColor();
		brush.setColor(BG_COLOR); // clear
		brush.fillRect(0, 0, XBOUND, YBOUND); // with black background
		brush.setColor(old); // restores color
	}

	/**
	 * 
	 * @param delay in ms
	 */
	public void nextFrame(int delay) { 
		try {
			Thread.sleep(delay);
		} catch (InterruptedException IE) {
		}
		display.drawImage(canvas, 0, 0, null); // draws to screen
		clearBuffer();
	}

	// -------- event handling: respond to key strokes -------

	/**
	 * controls direction of professor
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); // key pressed
		if (key == KeyEvent.VK_UP)
			professor.setDirection(0, -1); // move up
		if (key == KeyEvent.VK_DOWN)
			professor.setDirection(0, 1);
		if (key == KeyEvent.VK_LEFT)
			professor.setDirection(-1, 0);
		if (key == KeyEvent.VK_RIGHT)
			professor.setDirection(1, 0);
		if (key == KeyEvent.VK_SPACE)
			professor.setDirection(0, 0); // stop
		// else do nothing - direction remains the same
	}
	
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	// --------------------------------------------- 

	public void animate() {
		boolean stop = false; // controls when loop stops

		// our images
		professor = new Human(XBOUND - 50, YBOUND - 50, brush);
		goblin = new Goblin(0, YMIN_DISPLAY, brush);
		treasure = new Treasure(0, YMIN_DISPLAY, brush);

		// initialize GamePiece array that holds all the pieces
		GamePiece[] piece = new GamePiece[3];
		piece[0] = professor;
		piece[1] = goblin;
		piece[2] = treasure;
		
		// wait 1 second
		try {
			Thread.sleep(1000);
		} catch (Exception ee) {
		} 

		boolean win = false;

		while (!stop) {
			// loop through each game piece, 
			// moving and drawing them in each iteration
			for ( int i = 0; i < piece.length; i++ ) {
				piece[i].move(this);
				piece[i].draw();
			}

			// Extra Credit: Determine win/loss
			
			nextFrame(FDELAY);

		}

		String displayStr = "You lose!";
		if (win) {
			displayStr = "You win!";
		}
		
		display.setFont(new Font("SansSerif", Font.ITALIC+Font.BOLD, 36));
		display.setColor(Color.red);
		display.drawString(displayStr, XBOUND / 2 - 100, YBOUND / 2);

	}

	public Human getHuman() {
		try {
			return professor.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
