
import java.awt.*;
import java.util.Random;

/**
 * Represents a Treasure in the Game
 * 
 * @author Marshall Jones
 */
class Treasure extends GamePiece {

    private static final Random rand = new Random();

    public Treasure(int x, int y, Graphics g) {
        super(x, y, g);
        img = Toolkit.getDefaultToolkit().getImage( imgDir + "gem.gif");
        img_width = 30;
        char_width = 26;

        xcoord = rand.nextInt(Game.XBOUND);
        ycoord = rand.nextInt((Game.YBOUND - Game.YMIN_DISPLAY)) + Game.YMIN_DISPLAY;
    }

    /**
     * Moves the Goblin based on the human's position
     */
    @Override
    public void move(Game game) { // will not wrap around edges of window
        int go = rand.nextInt(33);
        if (go == 0) {
            xcoord = rand.nextInt(Game.XBOUND);
            ycoord = rand.nextInt((Game.YBOUND - Game.YMIN_DISPLAY)) + Game.YMIN_DISPLAY;
        }
        }
    }