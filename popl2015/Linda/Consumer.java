package popl2015.Linda;

public class Consumer extends Thread {
	
	/*
	 * Standard Consumer class used by MonoVariableTester to test the 
	 * MonoVariable class.
	 */
	private MonoVariable<Integer> monoVariable;
	private int number;
	
	public Consumer(MonoVariable<Integer> monoVariable, int number) {
		this.monoVariable = monoVariable;
		this.number = number;
	}
	
	public void run() {
		System.out.println("Consumer thread starting...");
		for (int i=0; i < 5; i++) {
			System.out.println("Consumer #" + this.number + " consume(): " + monoVariable.consume());
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer thread finished.");
	}
}
