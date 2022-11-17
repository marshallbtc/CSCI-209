/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.tokens.Token;

/**
 * @author marshalljones
 * 
 * Handles parsing the Negate function
 */
public class NegateAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the negate token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		ExpressionTreeNode result = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Negate(result);
	}

}
