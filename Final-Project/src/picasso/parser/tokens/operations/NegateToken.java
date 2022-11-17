package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author marshalljones
 * 
 * Represents the Negate sign token
 */
public class NegateToken extends CharToken implements OperationInterface {
	public NegateToken() {
		super(CharConstants.BANG);
	}

}
