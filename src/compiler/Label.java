package compiler;

public class Label {
char label_letter;
int label_index;



public Label(char label_letter, int label_index) {
	this.label_letter = label_letter;
	this.label_index = label_index;
}
public char getLabel_letter() {
	return label_letter;
}
public void setLabel_letter(char label_letter) {
	this.label_letter = label_letter;
}
public int getLabel_index() {
	return label_index;
}
public void setLabel_index(int label_index) {
	this.label_index = label_index;
}
public String toString(){
	return label_letter + Integer.toString(label_index);
}

}
