package picasso.parser;

import java.awt.Dimension;
import java.awt.Color;

import picasso.view.PopUpWindow;

/**
 * Describe an exception that occured during parsing.
 * 
 * @author Sara Sprenkle
 * @author [edited by] Armando Mendez
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	public ParseException(String message) {
		super("ParseException: " + message);

		// create GUI components
		PopUpWindow errorPopUp = new PopUpWindow("ERROR", new Dimension(400, 100));
		errorPopUp.addMessage(message);
		errorPopUp.outputPanel.setBackground(Color.RED);

	}
/*
	public static void main(String[] args) {
		new ParseException("Error");
	}
*/
}
