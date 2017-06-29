package popl2015.Linda;

public interface aMonoVariable<T> {
	
	/*
	 * If an instance of this class has no value, becomes(T val) sets the value
	 * of the instance to be val of type T. If it is occupied, the calling 
	 * thread is blocked until the value has been consumed.
	 */
	public void becomes(T val);
	
	/*
	 * If an instance of this class has a value stored, it is returned and the
	 * instance becomes unoccupied. If it is unoccupied, then the calling
	 * thread is blocked until there is a value to be returned.
	 */
	public T consume();
}
