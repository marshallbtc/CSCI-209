/**
 * 
 */
package picasso.parser.tokens;

/**
 * @author mesomaokolocha
 *
 */
public class StringToken extends Token {
	
	private final String myValue;

	/**
	 * @param description
	 */
	public StringToken(String value) {
		super("String Token");
		myValue = value;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return true iff o is a NumberToken with same value
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken other = (StringToken) o;
		return myValue == other.myValue;
	}

	/**
	 * @return the value of this token
	 */
	public String value() {
		return myValue;
	}

	public String toString() {
		return super.toString() + ": " + myValue;
	}

	@Override
	public boolean isConstant() {
		return true;
	}

	@Override
	public boolean isFunction() {
		return false;
	}
}
