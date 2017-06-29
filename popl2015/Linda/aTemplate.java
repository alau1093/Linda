package popl2015.Linda;

public interface aTemplate extends aTuple {
	
	/*
	 * Returns true iff aTuple t matches this instance of aTemplate.
	 */
	public boolean matches(aTuple t);
}
