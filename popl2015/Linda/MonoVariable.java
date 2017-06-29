package popl2015.Linda;

public class MonoVariable<T> implements aMonoVariable<T> {
	
	/*
	 * This instance is not occupied if isOccupied is false and value is null,
	 * value and isOccupied are set to null and false upon instantiation.
	 */
	private T value = null;
	private boolean isOccupied = false;
	
	@Override
	public synchronized void becomes(T val) {
		System.out.println("Producer thread called becomes()..."); // For testing purposes.
		try {
			while (isOccupied) {
				System.out.println("Producer thread blocking..."); // For testing purposes.
				wait();
			}
 		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Producer thread executing..."); // For testing purposes.
		value = val;
		isOccupied = true;
		notifyAll();
	}
	
	@Override
	public synchronized T consume() {
		T result;
		System.out.println("Consumer thread called consume()..."); // For testing purposes.
		try {
			while (!isOccupied) {
				System.out.println("Consumer thread blocking..."); // For testing purposes.
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Consumer thread executing..."); // For testing purposes.
		result = value;
		value = null;
		isOccupied = false;
		notifyAll();
		return result;
	}
}
