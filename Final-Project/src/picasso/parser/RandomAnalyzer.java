/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.language.expressions.Randoms;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * @author mesomaokolocha
 *
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {

	/**
	 * 
	 */
	public RandomAnalyzer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Randoms();
	}

}
