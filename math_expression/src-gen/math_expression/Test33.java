package math_expression;

import java.util.*;

public class Test33 {
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
	
	public int a;
	public int b;
	public int c;
	public int d;
	
	
	public Test33() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		a = 40;
		scope0.vars.put("a", a);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("i", 2);
		scope1.parentScope = scope0;
		b = scope1.getVar("a")*scope1.getVar("i");
		scope0.vars.put("b", b);
		}
		{
		c = scope0.getVar("b")*3;
		scope0.vars.put("c", c);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("i", 4);
		scope1.parentScope = scope0;
		d = scope1.getVar("c")+scope1.getVar("i");
		scope0.vars.put("d", d);
		}
	}
}
