package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import picasso.parser.ParseException;
import picasso.parser.Tokenizer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
//import picasso.parser.tokens.chars.TanToken;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.PlusToken;

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@BeforeEach
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
		
	}
	
	/**
	 * Test that parsing an expression with a comment works
	 */
	@Test
	public void testTokenizeComment() {
		String expression = "x // this is a comment";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(1, tokens.size());
		
		expression = "// everything is a comment";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(0, tokens.size());
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));

		// No problems here; problem will be in next step (Semantic Analysis)
		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}

	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

	@Test
	public void testTokenizeInvalidColor() {
		String expression = "[1, 1.0001, 1]";

		assertThrows(ParseException.class, () -> {
			tokens = tokenizer.parseTokens(expression);
		});
	}

	@Test
	public void testBasicExpression() {
		
		String string = "file";
		String expression = "floor(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new FloorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
		
		String expression2 = "tan(x)";
		List<Token> tokens1 = tokenizer.parseTokens(expression2);
		assertEquals(new TanToken(), tokens1.get(0));
		assertEquals(new LeftParenToken(), tokens1.get(1));
		assertEquals(new IdentifierToken("x"), tokens1.get(2));
		assertEquals(new RightParenToken(), tokens1.get(3));
		
		String expression3  = "floor(x) + tan(x)";
		List<Token> tokens2 = tokenizer.parseTokens(expression3);
		assertEquals(new FloorToken(), tokens2.get(0));
		assertEquals(new LeftParenToken(), tokens2.get(1));
		assertEquals(new IdentifierToken("x"), tokens2.get(2));
		assertEquals(new RightParenToken(), tokens2.get(3));
		assertEquals(new PlusToken(),tokens2.get(4));
		assertEquals(new TanToken(), tokens2.get(5));
		assertEquals(new LeftParenToken(), tokens2.get(6));
		assertEquals(new IdentifierToken("x"), tokens2.get(7));
		assertEquals(new RightParenToken(), tokens2.get(8));
		
		
		String expression4 = "tan(floor(x))";
		List<Token> tokens3 = tokenizer.parseTokens(expression4);
		assertEquals(new TanToken(), tokens3.get(0));
		assertEquals(new LeftParenToken(), tokens3.get(1));
		assertEquals(new FloorToken(), tokens3.get(2));
		assertEquals(new LeftParenToken(), tokens3.get(3));
		assertEquals(new IdentifierToken("x"),tokens3.get(4));
		assertEquals(new RightParenToken(), tokens3.get(5));
		assertEquals(new RightParenToken(), tokens3.get(6));
		
		
	}
	
	@Test
	public void Testbasicfunctions2() {
		String expression5= "wrap(x)";
		List<Token> tokens4 = tokenizer.parseTokens(expression5);
		assertEquals(new WrapToken(), tokens4.get(0));
		assertEquals(new LeftParenToken(), tokens4.get(1));
		assertEquals(new IdentifierToken("x"), tokens4.get(2));
		assertEquals(new RightParenToken(), tokens4.get(3));
		
		String expression6 = "wrap(floor(x))";
		List<Token> tokens5 = tokenizer.parseTokens(expression6);
		assertEquals(new WrapToken(), tokens5.get(0));
		assertEquals(new LeftParenToken(), tokens5.get(1));
		assertEquals(new FloorToken(), tokens5.get(2));
		assertEquals(new LeftParenToken(), tokens5.get(3));
		assertEquals(new IdentifierToken("x"),tokens5.get(4));
		assertEquals(new RightParenToken(), tokens5.get(5));
		assertEquals(new RightParenToken(), tokens5.get(6));
		
		//random comment
		String expression7= "abs(x)";
		List<Token> tokens6 = tokenizer.parseTokens(expression7);
		assertEquals(new AbsToken(), tokens6.get(0));
		assertEquals(new LeftParenToken(), tokens6.get(1));
		assertEquals(new IdentifierToken("x"), tokens6.get(2));
		assertEquals(new RightParenToken(), tokens6.get(3));
		
		String expression8 = "abs(floor(x))";
		List<Token> tokens7 = tokenizer.parseTokens(expression8);
		assertEquals(new AbsToken(), tokens7.get(0));
		assertEquals(new LeftParenToken(), tokens7.get(1));
		assertEquals(new FloorToken(), tokens7.get(2));
		assertEquals(new LeftParenToken(), tokens7.get(3));
		assertEquals(new IdentifierToken("x"),tokens7.get(4));
		assertEquals(new RightParenToken(), tokens7.get(5));
		assertEquals(new RightParenToken(), tokens7.get(6));
		
		String expression9= "ceil(x)";
		List<Token> tokens8 = tokenizer.parseTokens(expression9);
		assertEquals(new CeilToken(), tokens8.get(0));
		assertEquals(new LeftParenToken(), tokens8.get(1));
		assertEquals(new IdentifierToken("x"), tokens8.get(2));
		assertEquals(new RightParenToken(), tokens8.get(3));
		
		String expression10 = "ceil(floor(x))";
		List<Token> tokens9 = tokenizer.parseTokens(expression10);
		assertEquals(new CeilToken(), tokens9.get(0));
		assertEquals(new LeftParenToken(), tokens9.get(1));
		assertEquals(new FloorToken(), tokens9.get(2));
		assertEquals(new LeftParenToken(), tokens9.get(3));
		assertEquals(new IdentifierToken("x"),tokens9.get(4));
		assertEquals(new RightParenToken(), tokens9.get(5));
		assertEquals(new RightParenToken(), tokens9.get(6));
		
		
		String expression11= "ceil(x)";
		List<Token> tokens10 = tokenizer.parseTokens(expression11);
		assertEquals(new CeilToken(), tokens10.get(0));
		assertEquals(new LeftParenToken(), tokens10.get(1));
		assertEquals(new IdentifierToken("x"), tokens10.get(2));
		assertEquals(new RightParenToken(), tokens10.get(3));
		
		String expression12 = "tan(floor(x))";
		List<Token> tokens11 = tokenizer.parseTokens(expression12);
		assertEquals(new TanToken(), tokens11.get(0));
		assertEquals(new LeftParenToken(), tokens11.get(1));
		assertEquals(new FloorToken(), tokens11.get(2));
		assertEquals(new LeftParenToken(), tokens11.get(3));
		assertEquals(new IdentifierToken("x"),tokens11.get(4));
		assertEquals(new RightParenToken(), tokens11.get(5));
		assertEquals(new RightParenToken(), tokens11.get(6));
		
		
		String expression13 = "sin(floor(x))";
		List<Token> tokens12 = tokenizer.parseTokens(expression13);
		assertEquals(new SinToken(), tokens12.get(0));
		assertEquals(new LeftParenToken(), tokens12.get(1));
		assertEquals(new FloorToken(), tokens11.get(2));
		assertEquals(new LeftParenToken(), tokens12.get(3));
		assertEquals(new IdentifierToken("x"),tokens12.get(4));
		assertEquals(new RightParenToken(), tokens12.get(5));
		assertEquals(new RightParenToken(), tokens12.get(6));
		
		
		String expression14 = "cos(atan(x)) + atan(x+y)";
		List<Token> tokens13 = tokenizer.parseTokens(expression14);
		assertEquals(new CosToken(), tokens13.get(0));
		assertEquals(new LeftParenToken(), tokens13.get(1));
		assertEquals(new AtanToken(), tokens13.get(2));
		assertEquals(new LeftParenToken(), tokens13.get(3));
		assertEquals(new IdentifierToken("x"),tokens13.get(4));
		assertEquals(new RightParenToken(), tokens13.get(5));
		assertEquals(new RightParenToken(), tokens13.get(6));
		assertEquals(new PlusToken(), tokens13.get(7));
		assertEquals(new AtanToken(),tokens13.get(8));
		assertEquals(new LeftParenToken(), tokens13.get(9));
		assertEquals(new IdentifierToken("x"), tokens13.get(10));
		assertEquals(new PlusToken(), tokens13.get(11));
		assertEquals(new IdentifierToken("y"), tokens13.get(12));
		assertEquals(new RightParenToken(), tokens13.get(13));
		
		
		
		
		String expression15 = "imageWrap(\"sin.jpg\",x,y) + atan(x)";
		
		List<Token> tokens14 = tokenizer.parseTokens(expression15);
		assertEquals(new ImageWrapToken(), tokens14.get(0));
		assertEquals(new LeftParenToken(),tokens14.get(1));
		
		
		assertEquals(new IdentifierToken("x"), tokens14.get(4));
		assertEquals(new IdentifierToken("y"), tokens14.get(6));
		assertEquals(new PlusToken(), tokens13.get(7));
		assertEquals(new AtanToken(),tokens13.get(8));
		assertEquals(new LeftParenToken(), tokens13.get(9));
		assertEquals(new IdentifierToken("x"), tokens13.get(10));
		assertEquals(new PlusToken(), tokens13.get(11));
		assertEquals(new IdentifierToken("y"), tokens13.get(12));
		assertEquals(new RightParenToken(), tokens13.get(13));
		
	
		
		String expression16 = "perlinColor(x,y) + atan(x)";
		

		List<Token> tokens15 = tokenizer.parseTokens(expression16);
		assertEquals(new PerlinColorToken(), tokens15.get(0));
		assertEquals(new LeftParenToken(),tokens15.get(1));
		
		assertEquals(new IdentifierToken("x"), tokens15.get(2));
		assertEquals(new IdentifierToken("y"), tokens15.get(4));
		assertEquals(new PlusToken(), tokens15.get(6));
		assertEquals(new AtanToken(),tokens15.get(7));
		assertEquals(new LeftParenToken(), tokens15.get(8));
		assertEquals(new IdentifierToken("x"), tokens15.get(9));
		
		assertEquals(new RightParenToken(), tokens15.get(10));
		
		
		String expression17 = "imageClip(\"sin.jpg\",x,y) + atan(x)";
		
		tokens14 = tokenizer.parseTokens(expression17);
		assertEquals(new ImageClipToken(), tokens14.get(0));
		assertEquals(new LeftParenToken(),tokens14.get(1));
		
		
		assertEquals(new IdentifierToken("x"), tokens14.get(4));
		assertEquals(new IdentifierToken("y"), tokens14.get(6));
		assertEquals(new PlusToken(), tokens13.get(7));
		assertEquals(new AtanToken(),tokens13.get(8));
		assertEquals(new LeftParenToken(), tokens13.get(9));
		assertEquals(new IdentifierToken("x"), tokens13.get(10));
		assertEquals(new PlusToken(), tokens13.get(11));
		assertEquals(new IdentifierToken("y"), tokens13.get(12));
		assertEquals(new RightParenToken(), tokens13.get(13));
		
	
		
		
	}

	@Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		
		
		// TODO: Check the tokens...

		expression = "sin(perlinColor(x, y))";
		tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...
	}
	

	// TODO: Test arithmetic (rather than function-based) expressions ...

}
