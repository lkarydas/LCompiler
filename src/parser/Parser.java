package parser;

import compiler.Instruction;
import compiler.Program;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class Parser {
	Logger log = Logger.getLogger(getClass());
	Importer importer;
	char label;

	int position;
	public Parser(String filename){
		importer = new Importer(filename);
	}

	public Program parse(){

		Program program = pass1();
		program.updateVarTable();
		program.printVarTable();
		return program;

	}

	Program pass1(){
		String[] instrStringTable = importer.getInstructions();

		Instruction[] instruction = new Instruction[instrStringTable.length];
		for (int i = 0;i<instrStringTable.length;i++){

			instrStringTable[i] = cropSpaces(instrStringTable[i]);
			instruction[i] = new Instruction(instrStringTable[i]);
		}
		return new Program(instruction);
	}


	/*
	 * Checks whether the input character is a valid label letter.
	 */
	boolean check(char label_letter){
		return ((label_letter == 'A')||
				(label_letter == 'B')||
				(label_letter == 'C')||
				(label_letter == 'D')||
				(label_letter == 'E'));
	}

	// TODO this has to be converted to isPositiveInteger(char c)
	boolean isDigit(char c){
		return ((c == '1')||(c == '2')||(c == '3')||(c == '4')||(c == '5')||(c == '6')||(c == '7')||(c == '8')||(c == '9'));

	}

	public String cropSpaces(String s) {
		StringTokenizer st = new StringTokenizer(s," ",false);
		String t="";
		while (st.hasMoreElements()) t += st.nextElement();
		return t;
	}


}
