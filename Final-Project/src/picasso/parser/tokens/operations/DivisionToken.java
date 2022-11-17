
/**
 * 
 */

package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author marshalljones
 *
 * Represents the Division sign token
 */
public class DivisionToken extends CharToken implements OperationInterface {
	public DivisionToken() {
		super(CharConstants.SLASH);
	}
}



