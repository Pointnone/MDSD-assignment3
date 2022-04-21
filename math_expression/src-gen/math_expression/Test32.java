package math_expression;

import java.util.*;

public class Test32 {
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
	public int e;
	
	
	public Test32() {
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		a = 40;
		scope0.vars.put("a", a);
		}
		{
		b = 40+2;
		scope0.vars.put("b", b);
		}
		{
		c = 40+5-10-8;
		scope0.vars.put("c", c);
		}
		{
		d = 40+2*4+80;
		scope0.vars.put("d", d);
		}
		{
		e = (40+2)*(4+80);
		scope0.vars.put("e", e);
		}
	}
}
