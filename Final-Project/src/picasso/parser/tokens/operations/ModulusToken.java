/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author marshalljones
 *
 * Represents the Modulus sign token
 */
public class ModulusToken extends CharToken implements OperationInterface {
	public ModulusToken() {
		super(CharConstants.MOD);
	}

}
