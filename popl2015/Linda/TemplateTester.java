package popl2015.Linda;

public class TemplateTester {
	
	/* 
	 * Class to test Template.
	 * Creates an instance of Tuple for different instances of template to test
	 * against.
	 */
	public static void main(String[] args) {
		
		// 1 element tuple that templates will compare to.
		Tuple tuple = new Tuple();
		tuple.add(new TypedValue(TypedValue.Type.Integer, 1));
		
		// Template with 1 correct hole.
		Template template1 = new Template();
		template1.add(new Hole(TypedValue.Type.Integer));
		System.out.println(template1.toString() + " and " + tuple.toString() + 
				" is " + template1.matches(tuple));
		
		// Template with 1 correct typed value.
		Template template2 = new Template();
		template2.add(new TypedValue(TypedValue.Type.Integer, 1));
		System.out.println(template2.toString() + " and " + tuple.toString() + 
				" is " + template2.matches(tuple));
		
		// Template with 1 incorrect hole.
		Template template3 = new Template();
		template3.add(new Hole(TypedValue.Type.Float));
		System.out.println(template3.toString() + " and " + tuple.toString() + 
				" is " + template3.matches(tuple));
		
		// Templates with incorrect typed values.
		Template template4 = new Template();
		template4.add(new TypedValue(TypedValue.Type.Bool, true));
		System.out.println(template4.toString() + " and " + tuple.toString() + 
				" is " + template4.matches(tuple));
		
		Template template5 = new Template();
		template5.add(new TypedValue(TypedValue.Type.Integer, 2));
		System.out.println(template5.toString() + " and " + tuple.toString() + 
				" is " + template5.matches(tuple));
	}
}
