package math_expression;

import java.util.*;

public class Test34 {
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
	
	public int sideA;
	public int sideB;
	public int sideC;
	public int perimeterTriangle;
	public int radius;
	public int perimeterCircle;
	
	private External external;
	
	public Test34(External external) {
		this.external = external;
	}
	
	public void compute() {
		Scope scope0 = new Scope();
		{
		sideA = 3;
		scope0.vars.put("sideA", sideA);
		}
		{
		sideB = 4;
		scope0.vars.put("sideB", sideB);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("powA", external.pow(scope0.getVar("sideA"), 2));
		scope1.parentScope = scope0;
					Scope scope2 = new Scope();
					scope2.vars.put("powB", external.pow(scope1.getVar("sideB"), 2));
					scope2.parentScope = scope1;
		sideC = external.sqrt(scope2.getVar("powA")+scope2.getVar("powB"));
		scope0.vars.put("sideC", sideC);
		}
		{
		perimeterTriangle = scope0.getVar("sideA")+scope0.getVar("sideB")+scope0.getVar("sideC");
		scope0.vars.put("perimeterTriangle", perimeterTriangle);
		}
		{
		radius = 5;
		scope0.vars.put("radius", radius);
		}
		{
		Scope scope1 = new Scope();
		scope1.vars.put("diameter", 2*scope0.getVar("radius"));
		scope1.parentScope = scope0;
		perimeterCircle = scope1.getVar("diameter")*external.pi();
		scope0.vars.put("perimeterCircle", perimeterCircle);
		}
	}
	public interface External {
		public int pow(int p0,int p1);
		public int sqrt(int p2);
		public int pi();
	}
}
