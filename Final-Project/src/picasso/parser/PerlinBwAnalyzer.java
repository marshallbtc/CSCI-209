/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * @author mesomaokolocha
 *
 */
public class PerlinBwAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		// TODO Auto-generated method stub
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new PerlinBW(left,right);
	}

}
