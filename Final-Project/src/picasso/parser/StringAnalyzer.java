/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PicString;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.StringToken;

/**
 * @author mesomaokolocha
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		// TODO Auto-generated method stub
		StringToken token = (StringToken) tokens.pop();
		String imageName = token.value();
		return new PicString(imageName);
	}

}
