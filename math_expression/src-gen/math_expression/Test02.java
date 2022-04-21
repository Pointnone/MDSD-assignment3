package math_expression;

import java.util.*;

public class Test02 {
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
	
	
	public Test02() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 40+2;
		scope0.vars.put("x", x);
		}
	}
}
