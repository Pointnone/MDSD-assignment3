package math_expression;

import java.util.*;

public class Test24 {
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
	
	
	public Test24() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 21;
		scope0.vars.put("x", x);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("i", scope0.getVar("x"));
		scope1.parentScope = scope0;
		y = scope1.getVar("i")*2;
		scope0.vars.put("y", y);
		}
	}
}
