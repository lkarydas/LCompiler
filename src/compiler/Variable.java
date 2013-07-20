package compiler;

public class Variable {
	String name;
	int value;
	public Variable(String name) {
		this.name = name;
		this.value = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void increment(){
		value++;
	}
	public void decrement(){
		value--;
	}

}
