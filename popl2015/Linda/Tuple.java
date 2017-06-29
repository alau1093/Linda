package popl2015.Linda;
import java.util.*;

public class Tuple implements aTuple {
	
	private List<TypedValue> elements;
	
	public Tuple() { 
		elements = new Vector<TypedValue>();
	}
	
	public Tuple(List<TypedValue> es) {
		elements = es;
	}
	
	@Override
	public aTuple add(TypedValue v) {
		elements.add(v);
		return this;
	}
	
	@Override
	public int length() {
		return elements.size();
	}

	@Override
	public TypedValue nth(int n) {
		if (n < 0 || n >= elements.size()) return null;
		else return elements.get(n);
	}
	
	public String toString() {
		return "<" + elements + ">";
	}
}
