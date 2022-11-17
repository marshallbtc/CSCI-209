package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Multiplication;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the times function
 * 
 * @author Armando Mendez
 * 
 */
public class MultiplicationAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Multiplication(left,right);
	}

}
