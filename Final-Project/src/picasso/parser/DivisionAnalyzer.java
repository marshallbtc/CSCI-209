
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;

import picasso.parser.tokens.Token;

/**
 * @author marshalljones
 * 
 * Handles parsing the division function
 *
*/


import picasso.parser.tokens.Token;

/**
 * Handles parsing the times function
 * 
 * @author Armando Mendez
 * 
*/
public class DivisionAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		ExpressionTreeNode right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Division(left,right);
	}

}
