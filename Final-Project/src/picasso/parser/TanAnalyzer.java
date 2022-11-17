package picasso.parser;


import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the floor function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		
		
		return new Tan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	

}
}
