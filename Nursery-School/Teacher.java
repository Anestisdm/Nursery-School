package Nursery;

import javax.swing.*;
import java.util.Scanner;

public class Teacher {

private String id;//Unique teacher id
private String name;//Teacher's name
private String AMKA;//Social Security Number of Teacher
private static Teacher[] Teachers = new Teacher[100];//Static table containing all Teacher type objects
private static int count = 0;//Teacher object counter where it is used to store objects in the static table but also to run through the specific table and avoid the NullPointerException exception


//Constructor of Teacher class
public Teacher(String name, String AMKA) {
	Teachers[count] = this;//Storing objects in the Teachers static table
	count++;		
	this.id = "T"+SchoolYear.gety()+"00"+count;//Construction of Student type objects of the T18001 format
	this.name = name;
	this.AMKA = AMKA;
}

//Method where it returns the instance variable name
public String getName() {
	return name;
}


//Method where it prints in detail which classes each teacher has undertaken
public static void Teacher_Classes() {
	String Classes[] = new String[Teachers.length-1] ;

	//We run the table the static table Teachers
	for (int i=0;i<count;i++) {
		//Print the name of each teacher
		Classes[i] = "\nHis / her classes "+ Teachers[i].name+" are the folowing:\n";
		//We go through the static table SchoolYears and check if in that year is the name of the teacher and then we print the school year as well as the class where he had taken
		for (int x=0;x<SchoolYear.getCount();x++) { 
			if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject1().name)) {
				Classes[i] += "- The year "+SchoolYear.getSchoolYears()[x].getYear()+" the PreKindergarten class\n";
			}
			else if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject2().name)) {
				Classes[i] +="- The year "+SchoolYear.getSchoolYears()[x].getYear()+" the Kindergarten class\n";

			}
		}
	}
	String Returntxt = "";
	for (String c: Classes){
		if (c==null){
			break;
		}
		Returntxt+=c;
	}
	JOptionPane.showMessageDialog(null,"TEACHER CLASSES\n"+Returntxt);
}

//Method where it searches for teacher data with the Social Security Number where we enter it and then displays it
public static void AMKA_Index() {
	boolean x=false;//Auxiliary variable where it tells us if the Social Security Number entered by the user exists in memory
	while (x==false) {
		String input = (String)JOptionPane.showInputDialog(null,"Please enter the teacher's Social Security Number: \n [eg 17077732902]");
		//We give the user the option to press 0 and end the search
		if (input==null) {
			x=true;//We stop the loop because the user entered 0
		}
		else {
			//We go through the static table Teachers
			for (int i=0;i<count;i++) { 
				if (Teachers[i].AMKA.equals(input)) {
					//If we find an object of type Teacher with Social Security Number (instance variable) where it is the same as the input we display the data of the specific teacher
					JOptionPane.showMessageDialog(null,"\nThe details of the teacher with Social Security Number '"+input+"' are the following:\nId: "+Teachers[i].id+"\nFull name: "+Teachers[i].name);
					x=true;//We stop the loop because the teacher was found
				}
			}
		}
		if (x==false) {
			//We display an appropriate message as we know that no Teacher object was found with Social Security Number (instance variable) where it is the same as the user input
			JOptionPane.showMessageDialog(null,"The Social Security Number you entered does not correspond to a teacher");
		}	
	}
}

}
