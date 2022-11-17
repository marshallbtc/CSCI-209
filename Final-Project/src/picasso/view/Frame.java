package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.parser.language.AssignVariables;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
import picasso.model.Argumentgenerator;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// create Eval and ThreadCommand
		Evaluater eval = new Evaluater();
		ThreadedCommand<Pixmap> start = new ThreadedCommand<Pixmap>(canvas, eval);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer());

		JButton newWindow = new JButton("View in new window");
		commands.add(newWindow);
		newWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame newFrame = new JFrame();
				Canvas newCanvas = new Canvas(newFrame);
				newCanvas.setSize(size);

				ThreadedCommand<Pixmap> start1 = new ThreadedCommand<Pixmap>(canvas, eval);
				eval.AssignExpression(eval.EXPRESSION);
				start1.execute(newCanvas.getPixmap());
				newCanvas.refresh();
				newFrame.setTitle("Eternals Expression: " + eval.EXPRESSION);
				newFrame.getContentPane().add(newCanvas);
				newFrame.pack();
				newFrame.setVisible(true);

			}
		});

		// add view assigned variables button
		JButton assignedListButton = new JButton("View Assigned");
		commands.add(assignedListButton);

		assignedListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> assignedVars = AssignVariables.getStringVars();
				PopUpWindow varsFrame = new PopUpWindow("Assigned Variables", new Dimension(400, 200));
				for (String str : assignedVars) {
					

					varsFrame.addMessage(str);
					varsFrame.addPixmap(str);
					//varsFrame.outputPanel.pack();
				}
				varsFrame.addScroll();
			}
		});

		//create the random expression buttion


		// add Expression Input and Buttons
		JPanel inputFrame = new JPanel();
		inputFrame.add(new JLabel("Enter Expression:"));
		JTextField input = new JTextField(20);
		inputFrame.add(input);

		JButton evaluateButton = new JButton("Evaluate");
		inputFrame.add(evaluateButton);

		evaluateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eval.AssignExpression(input.getText());
				start.execute(canvas.getPixmap());
				canvas.refresh();
			}
		});


		JButton RandomButton = new JButton("Random Expression");
		inputFrame.add(RandomButton);

		RandomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Argumentgenerator a = new Argumentgenerator();

				//generate a unary expression, tell it that it hadn't recursed yet(i.e the false boolean argument). 
				String b = a.generateUnaryexpression(4,false);
				System.out.println(b);
				eval.AssignExpression(b);
				start.execute(canvas.getPixmap());
				canvas.refresh();
			}
		});

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(inputFrame, BorderLayout.SOUTH);
		pack();

	}
}
