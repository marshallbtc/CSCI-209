/**
 * 
 */
package picasso.parser.language.expressions;
import picasso.parser.language.ExpressionTreeNode;


/**
 * @author mesomaokolocha
 *
 */
public abstract class MultiArgumentFunction extends ExpressionTreeNode {
	
	ExpressionTreeNode first;
	ExpressionTreeNode second;



	/**
	 * @param first
	 * @param second
	 */
	public MultiArgumentFunction(ExpressionTreeNode first , ExpressionTreeNode second) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.second = second;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + first + ","+ second + ")";
	}
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof BinaryOperator)) {
			return true;
			
		}
		

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator uf = (BinaryOperator) o;

		// check if their parameters are equal
		if (!this.first.equals(uf.first)) {
			return false;
		}
		if (!this.second.equals(uf.second)) {
			return false;
		}
		return true;
	}

}
