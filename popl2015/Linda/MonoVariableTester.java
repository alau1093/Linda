package popl2015.Linda;

public class MonoVariableTester {
	
	/* 
	 * Class to test MonoVariable.
	 * Creates an instance of MonoVariable and starts a Producer thread and
	 * Consumer thread that uses this instance.
	 */
	public static void main(String[] args) {
		MonoVariable<Integer> mv = new MonoVariable<Integer>();
		Producer p = new Producer(mv, 1);
		Consumer c = new Consumer(mv, 1);
		
		p.start();
		c.start();
	}
}