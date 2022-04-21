package math_expression;

import java.util.*;

public class Test14 {
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
	public int z;
	
	
	public Test14() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 42;
		scope0.vars.put("x", x);
		}
		{
		y = 100-20+10-3;
		scope0.vars.put("y", y);
		}
		{
		z = 100*20/10*3;
		scope0.vars.put("z", z);
		}
	}
}
