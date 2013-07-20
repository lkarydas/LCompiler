package compiler;

import java.util.Enumeration;
import java.util.Hashtable;

public class VarTable {
	Hashtable<String, Variable> varTable;
	
	public VarTable(){
		varTable = new Hashtable<String, Variable>();
	}
	
	public void putVariable(String name){
		varTable.put(name, new Variable(name));
	}
	
	public void print(){
        Enumeration<String> e = varTable.keys ();
        while (e.hasMoreElements ()) {
            String key = (String) e.nextElement ();
            Variable var = (Variable) varTable.get (key);
            System.out.println (key + " : " + var.getValue());
        } 
	}
	
	public Variable get(String name){
		return varTable.get(name);		
	}
	
}
