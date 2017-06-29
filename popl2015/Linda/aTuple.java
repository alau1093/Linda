package popl2015.Linda;

public interface aTuple {
	
	/*
	 * Returns the element n of the tuple where 0 is the first element.
	 */
	public TypedValue nth(int n);
	
	/*
	 * Returns the number of elements in the tuple.
	 */
	public int length();
	
	/*
	 * Appends v to the end of this tuple, returning the updated tuple.
	 */
	public aTuple add(TypedValue v);
}
