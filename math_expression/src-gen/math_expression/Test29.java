package math_expression;

import java.util.*;

public class Test29 {
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
	
	public Test29(External external) {
		this.external = external;
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		x = external.pow(4, 2);
		scope0.vars.put("x", x);
		}
		{
		y = scope0.getVar("x")-2;
		scope0.vars.put("y", y);
		}
	}
	public interface External {
		public int pow(int p0,int p1);
	}
}
