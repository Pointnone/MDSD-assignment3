package math_expression;

import java.util.*;

public class Test19 {
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
	
	
	public Test19() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		Scope scope1 = new Scope();
		scope1.vars.put("y", 2);
		scope1.parentScope = scope0;
					Scope scope2 = new Scope();
					scope2.vars.put("z", 3);
					scope2.parentScope = scope1;
		x = scope2.getVar("y")*scope2.getVar("z")+scope1.getVar("y")+79;
		scope0.vars.put("x", x);
		}
	}
}
