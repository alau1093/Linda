package popl2015.Linda;
import java.util.*;

public class TupleSpace implements aTupleSpace {
	
	private Collection<aTuple> theSpace;
	
	public TupleSpace() {
		theSpace = new Vector<aTuple>();
	}
	
	@Override
	public synchronized void out(aTuple v) {
		System.out.println("Producer thread called out()..."); // For testing purposes.
		theSpace.add(v);
		notifyAll();
	}
	
	@Override
	public synchronized void in(aTemplate t, aMonoVariable<aTuple> result) {
		while (true) {
			System.out.println("Consumer thread called in()..."); // For testing purposes.
			Iterator<aTuple> iterator = theSpace.iterator();
			List<aTuple> matched = new ArrayList<aTuple>();
			while (iterator.hasNext()) {
				aTuple tempTuple = iterator.next();
				if (t.matches(tempTuple)) {
					matched.add(tempTuple);
				}
			}
			if (matched.isEmpty()) {
				try {
					System.out.println("Consumer thread blocking..."); // For testing purposes.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				Random random = new Random();
				int index = random.nextInt(matched.size());
				result.becomes(matched.get(index));
				theSpace.remove(matched.get(index));
				System.out.println("in() has found a match."); // For testing purposes.
				notifyAll();
				return;
			}
		}
	}
	
	@Override
	public synchronized void rd(aTemplate t, aMonoVariable<aTuple> result) {
		while (true) {
			System.out.println("Consumer thread called rd()..."); // For testing purposes.
			Iterator<aTuple> iterator = theSpace.iterator();
			List<aTuple> matched = new ArrayList<aTuple>();
			while (iterator.hasNext()) {
				aTuple tempTuple = iterator.next();
				if (t.matches(tempTuple)) {
					matched.add(tempTuple);
				}
			}
			if (matched.isEmpty()) {
				try {
					System.out.println("Consumer thread blocking..."); // For testing purposes.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				Random random = new Random();
				int index = random.nextInt(matched.size());
				result.becomes(matched.get(index));
				System.out.println("rd() has found a match."); // For testing purposes.
				notifyAll();
				return;
			}
		}
	}
	
	public String toString() {
		return "# " + theSpace + " #";
	}
}