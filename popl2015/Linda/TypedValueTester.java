package popl2015.Linda;
import java.util.*;

public class TypedValueTester {

	/* 
	 * Class to test TypedValue.
	 */
	public static List<Object> values = new ArrayList<Object>(); 
	
	public static void setValues() {
		values.add(1);
		values.add(1.0);
		values.add("One");
		values.add(true);
		values.add(null);
	}
	
	public static void main(String[] args) {	
		int count1 = 0;
		int count2 = 0;
		setValues();
		for (TypedValue.Type type1 : TypedValue.Type.values()) {
			for (TypedValue.Type type2 : TypedValue.Type.values()) {
				TypedValue tv1 = new TypedValue(type1, values.get(count1));
				TypedValue tv2 = new TypedValue(type2, values.get(count2));
				System.out.println(tv1.toString() + " and " + tv2.toString() + 
						" is " + tv1.equals(tv2));
				count2++;
			}
			count2 = 0;
			count1++;
		}
	}
}
