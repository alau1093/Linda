package popl2015.Linda;

public class Producer extends Thread {
	
	/*
	 * Standard Producer class used by MonoVariableTester to test the 
	 * MonoVariable class.
	 */
	private MonoVariable<Integer> monoVariable;
	private int number;
	
	public Producer(MonoVariable<Integer> monoVariable, int number) {
		this.monoVariable = monoVariable;
		this.number = number;
	}
	
	public void run() {
		System.out.println("Producer thread starting...");
		for (int i=0; i < 5; i++) {
			monoVariable.becomes(i);
			System.out.println("Producer #" + this.number + " becomes(): " + i);
			try {
				sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Producer thread finished.");
	}
}