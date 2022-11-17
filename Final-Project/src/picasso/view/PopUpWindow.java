package picasso.view;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import picasso.view.commands.Evaluater;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;


/**
 * Used for Simple GUI Pop-Up windows
 * 
 * @author Armando Mendez
 *
 */
@SuppressWarnings("serial")
public class PopUpWindow extends JFrame {

	public JPanel outputPanel;

	public PopUpWindow(String title, Dimension size) {
		super(title);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(size);
		// this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);

		outputPanel = new JPanel();
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));

		this.add(outputPanel);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		pack();
	}

	public void addMessage(String message) {
		JLabel messageLabel = new JLabel(message);
		messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		outputPanel.add(messageLabel);
		pack();

	}

	public void addScroll() {
		JScrollPane scrollBar = new JScrollPane(outputPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.add(scrollBar);
		pack();
	}

	public void addPixmap(String str) {
		Evaluater eval2 = new Evaluater();

		Canvas newCanvas = new Canvas(this);
		newCanvas.setSize(new Dimension(30, 30));
		newCanvas.setAlignmentX(Component.CENTER_ALIGNMENT);
//		newCanvas.setLayout(new BorderLayout());

		newCanvas.getPixmap().setSize(new Dimension(30, 30));

		eval2.AssignExpression(str.substring(str.indexOf("=") + 1));
		eval2.execute(newCanvas.getPixmap());
		newCanvas.refresh();

		outputPanel.add(newCanvas);
		pack();

	}

}
