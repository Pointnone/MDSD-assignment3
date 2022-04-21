package math_expression;

import java.util.*;

public class Test23 {
	class Scope {
		public HashMap<String, Integer> vars = new HashMap<String, Integer>();
		public Scope parentScope = null;
		
		public Integer getVar(String n) {
			Integer i = vars.get(n);
			if(i == null) {
				if(parentScope == null)
					return null;
				return parentScope.getVar(n);
			}
			return i;
		}
	}
	
	public int x;
	public int y;
	
	
	public Test23() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 21;
		scope0.vars.put("x", x);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("i", 2);
		scope1.parentScope = scope0;
		y = scope1.getVar("i")*scope1.getVar("x");
		scope0.vars.put("y", y);
		}
	}
}
