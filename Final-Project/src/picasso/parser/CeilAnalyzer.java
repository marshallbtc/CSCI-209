/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.Token;

/**
 * @author mesomaokolocha
 *
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the ceiling token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Ceil(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
