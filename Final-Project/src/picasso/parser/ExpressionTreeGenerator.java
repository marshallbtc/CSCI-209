package picasso.parser;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import picasso.parser.language.AssignVariables;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.*;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions)
 * @author Sara Sprenkle modified for Picasso
 * @author Mesoma Okolocha
 */
public class ExpressionTreeGenerator {

	// TODO: Do these belong here?
	private static final int CONSTANT = 0;
	private static final int ADD_OR_SUBTRACT = 1;
	private static final int MULTIPLY_OR_DIVIDE = 2;
	private static final int MODULUS = 2;
	private static final int EXPONENTIATION = 3;
	private static final int NEGATE = 4;
	private static final int GROUPING = 5; // parentheses

	/**
	 * Converts the given string into expression tree for easier manipulation.
	 * 
	 * @param infix - a non-empty expression to parse.
	 * 
	 * @return ExpressionTreeNode representing the root node of the given infix
	 *         formula
	 */
	public ExpressionTreeNode makeExpression(String infix) {
		Stack<Token> postfix = infixToPostfix(infix);

		if (postfix.isEmpty()) {
			return null;
		}
		// System.out.println("Postfx expression: "+postfix);
		// System.out.println("Assigned: "+AssignVariables.ASSIGNED_VARIABLES+"\n");

		// System.out.println("Process postfix expression");
		SemanticAnalyzer semAnalyzer = SemanticAnalyzer.getInstance();
		ExpressionTreeNode root = semAnalyzer.generateExpressionTree(postfix);

		// Is this the best place to put this check?
		if (!postfix.isEmpty()) {
			// System.out.println("Postfx expression: "+postfix);

			throw new ParseException(postfix + " is not a valid argument");
			// throw new ParseException("Extra operands without operators or functions");
		}
		return root;
	}

	/**
	 * This method converts the String infix expression to a Stack of tokens, which
	 * are in postfix.
	 * 
	 * @param infix
	 * @return a stack of tokens, in postfix order
	 */
	private Stack<Token> infixToPostfix(String infix) {
		boolean isAssign = infix.contains("=");

		// Algorithm for converting infix to postfix was adapted from
		// http://en.wikipedia.org/wiki/Shunting_yard_algorithm
		// Needed to handle identifiers and colors, which aren't in the original
		// algorithm.
		// May need to modify/update further...

		Stack<Token> operators = new Stack<Token>();
		Stack<Token> postfixResult = new Stack<Token>();

		Tokenizer tokenizer = new Tokenizer();
		List<Token> tokens = tokenizer.parseTokens(infix);

		Iterator<Token> iter = tokens.iterator();

		// TO DISCUSS: Is this the correct way to design this code?
		// What is the code smell? What is the alternative?

		while (iter.hasNext()) {
			Token token = iter.next(); // System.out.println(token.toString());

			if (token instanceof NumberToken) {
				postfixResult.push(token);
			} else if (token instanceof ColorToken) {
				postfixResult.push(token);
			} else if (token instanceof IdentifierToken) {
				// Checks if identifier is an assigned variable & that it is not being mutated.
				// If so, swaps IDToken for assigned expression.
				// Otherwise executes as normal

				String tString = token.toString(); // Represents token as string for comparison regardless of refrence
													// pointer

				if (AssignVariables.ASSIGNED_VARIABLES.containsKey(tString) && !isAssign) {

					Stack<Token> postfixAssignedExpression = (AssignVariables.ASSIGNED_VARIABLES.get(tString));

					for (Token assignExpressionToken : postfixAssignedExpression) {
						postfixResult.push(assignExpressionToken);
					}

				} else {
					postfixResult.push(token);
				}
			} else if (token instanceof FunctionToken) {
				operators.push(token);
			} else if (token instanceof StringToken) {
				operators.push(token);
			} else if (token instanceof OperationInterface) {

				/*
				 * while there is an operator, o2, at the top of the stack (this excludes left
				 * parenthesis), and either
				 * 
				 * o1 is left-associative and its precedence is less than (lower precedence) or
				 * equal to that of o2, or o1 is right-associative and its precedence is less
				 * than (lower precedence) that of o2 (SS: second case is not reflected in below
				 * code),
				 * 
				 * pop o2 off the stack, onto the output queue;
				 */
				while (!operators.isEmpty() && !(operators.peek() instanceof LeftParenToken)
						&& orderOfOperation(token) <= orderOfOperation(operators.peek())) {
					postfixResult.push(operators.pop());
				}

				operators.push(token);

			} else if (token instanceof CommaToken) {
				// Until the token at the top of the stack is a left
				// parenthesis, pop operators off the stack onto the output
				// queue.

				while (!operators.isEmpty() && !(operators.peek() instanceof LeftParenToken)) {
					postfixResult.push(operators.pop());
				}

				// If no left parentheses are encountered, either the
				// separator was misplaced or parentheses were mismatched.
				if (operators.isEmpty() || !(operators.peek() instanceof LeftParenToken)) {
					throw new ParseException("Parentheses were mismatched.");
				}

			} else if (token instanceof LeftParenToken) {
				operators.push(token);
			} else if (token instanceof RightParenToken) {
				// Until the token at the top of the stack is a left
				// parenthesis, pop operators off the stack onto the output
				// queue.
				while (operators.size() > 0 && !(operators.peek() instanceof LeftParenToken)) {
					postfixResult.push(operators.pop());
				}

				// Pop the left parenthesis from the stack, but not onto the
				// output queue.
				if (operators.isEmpty()) {
					throw new ParseException("Missing (");
				}
				operators.pop();

				// If the token at the top of the stack is a function token, pop
				// it onto the output queue.
				if (operators.size() > 0 && operators.peek() instanceof FunctionToken) {
					postfixResult.push(operators.pop());
				}

			} else if (token instanceof EqualsToken) {
				// Using infix, set String after "=" to String newExpression
				// Reursivly call infixToPostfix using newExpression. Save as postfixExpression
				// Map token.toString & postfixExpression to ASSIGNED_NAMES.
				// Map token.toString & newExpression to ASSIGNED_NAMES.
				// Return postfixExpression.

				Token assignNameToken = postfixResult.peek();

				if (!(assignNameToken instanceof IdentifierToken)) {
					throw new ParseException("Cannot assign an expression to: " + assignNameToken.toString());
				} else if (((IdentifierToken) assignNameToken).getName().contains("x")
						|| ((IdentifierToken) assignNameToken).getName().contains("y")) {
					throw new ParseException("Cannot assign an expression to: x or y");
				}
				// System.out.println(((IdentifierToken) assignNameToken).getName());
				int equalIndex = infix.indexOf("=");

				String newExpression = infix.substring(equalIndex + 1);
				// System.out.println(newExpression);

				Stack<Token> postfixExpression = infixToPostfix(newExpression);

				AssignVariables.assignNewAssignment(assignNameToken.toString(), postfixExpression, newExpression);

				return postfixExpression;

			} else {
				System.out.println("ERROR: No match: " + token);
			}
			// System.out.println("Postfix: " + postfixResult);
		}

		while (!operators.isEmpty()) {

			// If the operator token on the top of the stack is a parenthesis,
			// then there are mismatched parentheses.

			Token top = operators.peek();

			if (top.equals(CharTokenFactory.getToken('(')) || top.equals(CharTokenFactory.getToken(')'))) {
				throw new ParseException("Mismatched Parentheses");
			}
			postfixResult.push(operators.pop());
		}

		// System.out.println(postfixResult);
		return postfixResult;
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	private int orderOfOperation(Token token) {

		// TODO: Need to finish with other operators.

		// TODO: DISCUSS: Is it better to have a method in the OperatorToken
		// class that gives the order of operation?

		if (token instanceof PlusToken)
			return ADD_OR_SUBTRACT;
		else if (token instanceof MinusToken)
			return ADD_OR_SUBTRACT;
		else if (token instanceof MultiplicationToken)
			return MULTIPLY_OR_DIVIDE;
		else if (token instanceof DivisionToken)
			return MULTIPLY_OR_DIVIDE;
		else if (token instanceof ExponentiationToken)
			return EXPONENTIATION;
		else if (token instanceof ModulusToken)
			return MODULUS;
		else if (token instanceof NegateToken)
			return NEGATE;
		else
			return CONSTANT;
	}

	public static void main(String[] args) {
		ExpressionTreeGenerator test = new ExpressionTreeGenerator();
		// ExpressionTreeNode tester = test.makeExpression("w = 1");
		// System.out.println(tester);

		Stack<Token> tester2 = test.infixToPostfix("z =  y");// private Stack<Token> infixToPostfix(String infix)
		System.out.println(tester2.toString());
	}
}
