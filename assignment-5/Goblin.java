
import java.awt.*;

/**
 * Represents a Goblin in the Game
 * 
 * @author Marshall Jones
 */
class Goblin extends GamePiece {

    public Goblin(int x, int y, Graphics g) {
        super(x, y, g);
        img = Toolkit.getDefaultToolkit().getImage( imgDir + "gremlin.gif");
        img_width = 30;
        char_width = 26;
    }

    /**
     * Moves the Goblin based on the human's position
     */
    @Override
    public void move(Game game) { // will not wrap around edges of window
        Human human = game.getHuman();
        int xPos = human.getXPos();
        int yPos = human.getYPos();
        if (xcoord != xPos && ycoord != yPos) {
            if (xcoord < xPos) {
                xcoord = xcoord + 2;
            }
            if (xcoord > xPos) {
                xcoord = xcoord - 2;
            }
            if (ycoord < yPos) {
                ycoord = ycoord + 2;
            }
            if (ycoord > yPos) {
                ycoord = ycoord - 2;
            }
        } else {
            if (xcoord < xPos) {
                xcoord = xcoord + 4;
            }
            if (xcoord > xPos) {
                xcoord = xcoord - 4;
            }
            if (ycoord < yPos) {
                ycoord = ycoord + 4;
            }
            if (ycoord > yPos) {
                ycoord = ycoord - 4;
            }
        }
    }
}