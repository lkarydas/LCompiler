package compiler;


import org.apache.log4j.Logger;


public class Program {
	Logger log = Logger.getLogger(getClass());
	public Instruction[] instruction;
	VarTable varTable;

	public Program(Instruction[] instruction){
		this.instruction = instruction;
	}

	public void print(){
		for (int i=0;i<length();i++){
			System.out.println(instruction[i].print());
		}
	}

	public int length(){
		return instruction.length;
	}

	public void updateVarTable(){
		varTable = new VarTable();
		for (int i=0;i<length();i++){
			varTable.putVariable(instruction[i].getVariableName());
		}
	}
	public void printVarTable(){
		varTable.print();
	}

	public void compute(int X){
		
		// initialize X value
		
		varTable.get("X").setValue(X);
		
		int pc = 0;
		int type;
		while(pc<length()){

			type = instruction[pc].getType();
			log.debug(instruction[pc].print() +" "+ type);
			if(type==1){
				varTable.get(instruction[pc].getVariableName()).increment();
				pc++;
			}else if (type==2){
				if(varTable.get(instruction[pc].getVariableName()).getValue()!=0){
					varTable.get(instruction[pc].getVariableName()).decrement();}
				pc++;
			}else if(type==3){
				if(varTable.get(instruction[pc].getVariableName()).getValue()==0){
					pc++;
				}
				else{
					String gotoLabel = instruction[pc].getGotoLabel();
					int nextPos = findInstructionWithLabel(gotoLabel);
					if (nextPos==-1){
						pc = length()+1;
					}else
						pc = nextPos;
				
				}
			}else{
				log.info("Invalid instruction: "+instruction[pc]);
			}
		}
	}
/*
 * Finds the instruction number with the label.
 * returns label number or -1 if label does not exist.
 */
	int findInstructionWithLabel(String label){
		int result = -1;
		for (int i=0; i<length(); i++){
			if(instruction[i].instruction.startsWith("["+label+"]")){
				result = i;
			}
		}
		log.debug(result);
		return result;
	}
	
	
}
