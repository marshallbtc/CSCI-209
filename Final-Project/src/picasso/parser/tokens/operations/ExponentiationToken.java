/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author marshalljones
 *
 * Represents the Exponentiate sign token
 */
public class ExponentiationToken extends CharToken implements OperationInterface {
	public ExponentiationToken() {
		super(CharConstants.CARET);
	}

}
