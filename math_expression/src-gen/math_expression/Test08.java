package math_expression;

import java.util.*;

public class Test08 {
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
	
	
	public Test08() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 5*4;
		scope0.vars.put("x", x);
		}
	}
}
