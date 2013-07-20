package compiler;

import org.apache.log4j.Logger;

public class Instruction {
	Logger log = Logger.getLogger(getClass());
	String instruction;

	public Instruction(String instruction){
		this.instruction = instruction;
	}



	public String getVariableName(){
		String temp = "";
		int position = 0;


		if(instruction.charAt(position)=='['){
			position = instruction.indexOf(']');
			position++;
		}
		if(instruction.charAt(position)=='I'){
			log.debug("JMP instruction found.");
			temp = instruction.substring(position+2, instruction.indexOf('!'));
		}else{
			temp = instruction.substring(position, instruction.indexOf('<'));
		}
		return temp;
	}


	public String print() {
		return instruction;
	}
	
	public int getType(){
		int type;
		if(instruction.indexOf('+')!=-1){
			type = 1;
		}else if(instruction.indexOf('-')!=-1){
			type = 2;
		}else if(instruction.indexOf('!')!=-1){
			type = 3;
		}else{
			type = 0;
		}
		return type;
	}
	
	public String getGotoLabel(){
		return instruction.substring(instruction.indexOf("GOTO")+4);
	}
	
}
