package popl2015.Linda;

public class TypedValue {
	
	public static enum Type { Integer, Float, String, Bool, Null };
	private Object value;
	protected Type type;
	
	public TypedValue() {
		type = Type.Null;
		value = null;
	}
	
	public TypedValue(Type t, Object v) {
		type = t;
		value = v;
	}
	
	public Object value() {
		return value;
	}
	
	public Type type() {
		return type;
	}
	
	public boolean equals(Object o) { // Call to hashCode() won't return same values.
		if (!(o instanceof TypedValue)) {
			return false;
		}
		else {
			TypedValue typedvalue = (TypedValue) o;
			if (typedvalue instanceof Hole || this instanceof Hole ) {
				return typedvalue.type == type;
			} 
			return typedvalue.type == type && typedvalue.value == value; 
		}
	}
	
	public String toString() {
		return value + ":" + type;
	}
}