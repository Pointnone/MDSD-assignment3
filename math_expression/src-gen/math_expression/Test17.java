package math_expression;

import java.util.*;

public class Test17 {
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
	
	
	public Test17() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		Scope scope1 = new Scope();
		scope1.vars.put("y", 42);
		scope1.parentScope = scope0;
		x = scope1.getVar("y");
		scope0.vars.put("x", x);
		}
	}
}
