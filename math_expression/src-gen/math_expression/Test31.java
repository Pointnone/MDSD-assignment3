package math_expression;

import java.util.*;

public class Test31 {
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
	
	private External external;
	
	public Test31(External external) {
		this.external = external;
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = 5;
		scope0.vars.put("x", x);
		}
		{
		 Scope scope1 = new Scope();
		scope1.vars.put("i", scope0.getVar("x"));
		scope1.parentScope = scope0;
		
		y = 2+external.pow(scope1.getVar("i")-3, 3*2);
		scope0.vars.put("y", y);
		}
	}
	public interface External {
		public int pow(int p0,int p1);
	}
}
