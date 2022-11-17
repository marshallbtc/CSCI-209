/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponentiation;
import picasso.parser.tokens.Token;

/**
 * @author marshalljones
 *
 * Handles parsing the Exponentiate function
 */
public class ExponentiationAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);

		return new Exponentiation(left,right);
	}

}
