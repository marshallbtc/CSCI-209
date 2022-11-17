/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.tokens.Token;

/**
 * @author marshalljones
 *
 */
public class ClampAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the Wrap token
		// the parameter is the next token on the stack.
		
		
		return new Clamp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	

}
}

