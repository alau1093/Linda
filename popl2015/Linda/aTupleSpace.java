package popl2015.Linda;

public interface aTupleSpace {
	
	/*
	 * Places v into this tuple space and returns. It does not block.
	 */
	public void out(aTuple v);
	
	/*
	 * Removes the tuple which matches t from this space. The matching tuple is
	 * placed into result.
	 */
	public void in(aTemplate t, aMonoVariable<aTuple> result);
	
	/*
	 * Follows the same semantics as in() except that a matched tuple is not
	 * removed from the space.
	 */
	public void rd(aTemplate t, aMonoVariable<aTuple> result);
}