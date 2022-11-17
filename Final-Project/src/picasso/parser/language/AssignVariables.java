package picasso.parser.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.tokens.Token;

/**
 * Mutable Map of Assigned Variables and Values. Used for checking if Identifier
 * token is in Map of assigned variables
 * 
 * @author Armando Mendez
 *
 */

public class AssignVariables {

	public static Map<String, Stack<Token>> ASSIGNED_VARIABLES = new HashMap<String, Stack<Token>>();
	public static Map<String, String> ASSIGNED_STRING_EXPRESSIONS = new HashMap<String, String>();// used for displaying
																									// string repesentation of
																									// assignments

	public static void assignNewAssignment(String name, Stack<Token> expressionStack, String expression) {
		Stack<Token> copyExpression = new Stack<Token>();
		Stack<Token> throwaway = new Stack<Token>();
		for (Token t : expressionStack) {
			copyExpression.push(t);
			throwaway.push(t);
		}

		try {
			SemanticAnalyzer semAnalyzer = SemanticAnalyzer.getInstance();
			semAnalyzer.generateExpressionTree(throwaway);
		} catch (Exception e) {
			return;
		};


		ASSIGNED_VARIABLES.put(name, copyExpression);

		name = name.substring(name.indexOf(":") + 1);

		if (ASSIGNED_STRING_EXPRESSIONS.keySet().contains(name)) {
			// System.out.println("Replace: "+name+"
			// with:"+ASSIGNED_STRING_EXPRESSIONS.get(name));
			expression = expression.replaceAll(name, ASSIGNED_STRING_EXPRESSIONS.get(name));
		}

		ASSIGNED_STRING_EXPRESSIONS.put(name, expression);
	}

	// Creates arrayList of formated assigned expressions
	// @return ArrayList<String>
	public static ArrayList<String> getStringVars() {
		ArrayList<String> assignedString = new ArrayList<String>();

		for (String val : ASSIGNED_STRING_EXPRESSIONS.keySet()) {
			assignedString.add(val + " = " + ASSIGNED_STRING_EXPRESSIONS.get(val));

		}

		return assignedString;
	}
}
