package testing;

import compiler.Program;

import parser.Parser;

public class WorkBench {
	public static void main(String[] args) {
		int X;
		X=4;
		String filename = "SampleProgram.txt";
		
		Parser parser = new Parser(filename);
		Program program = parser.parse();

		program.compute(X);
		program.printVarTable();
	}
}
