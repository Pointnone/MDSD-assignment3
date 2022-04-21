package math_expression;

import java.util.*;

public class Test30 {
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
	
	private External external;
	
	public Test30(External external) {
		this.external = external;
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = external.sqrt(external.pow(external.pi(), 2));
		scope0.vars.put("x", x);
		}
	}
	public interface External {
		public int pow(int p0,int p1);
		public int sqrt(int p2);
		public int pi();
	}
}
