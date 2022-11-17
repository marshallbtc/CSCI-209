/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * @author mesomaokolocha
 *
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		// TODO Auto-generated method stub
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		

		if ((tokens.isEmpty() || !(tokens.peek() instanceof StringToken))) {
			throw new ParseException("No image file given");
		}
		
		StringToken t = (StringToken) tokens.pop();
		String imageName = t.value();
	
		
		
		return new ImageWrap(imageName,left,right);
	}

}
