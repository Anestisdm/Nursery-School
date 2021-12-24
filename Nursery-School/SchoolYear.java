package Nursery;

import java.util.Scanner;

public class SchoolYear {
private String year;//School year of attendance
private Teacher object1;//Saves the pre-school teacher in the specific school year
private Teacher object2;//Saves the infant's teacher in that school year
private Student[] Students1;//Stores Student objects where they depict PreKindergarten students for the specific school year
private Student[] Students2;//Stores Student items where they depict Kindergarten students for the specific school year
private static SchoolYear[] SchoolYears= new SchoolYear[100];//Static table containing all SchoolYears objects
private static int count = 0;//SchoolYear object counter where it is used to store objects in the static table but also to run through the specific table and avoid the NullPointerException exception
private static int y=18;//Auxiliary static variable that used to build the id of Student and Teacher objects

//School Year class constructor
public SchoolYear(String year, Student[] Students1, Teacher object1, Student[] Students2, Teacher object2) {
	SchoolYears[count]= this;//Storing objects in the school Years static table
	count++;
	y++;//Increase of the auxiliary static variable y every time we create a new school year (Prerequisite the first school year where it will be introduced will be 2018-2019)
	this.year = year;
	this.Students1= Students1;
	this.object1 = object1;
	this.Students2 = Students2;
	this.object2 = object2;
}

//Method where returns the instance variable year
public String getYear() {
	return year;
}
//Method where returns the instance variable object1
public Teacher getObject1() {
	return object1;
}
//Method where returns the instance variable object2
public Teacher getObject2() {
	return object2;
}
//Method where returns the static table SchoolYears[]
public static SchoolYear[] getSchoolYears() {
	return SchoolYears;
}
//Method where returns the static variable count
public static int getCount() {
	return count;
}
//Method where returns the static variable y
public static int gety() {
	return y;
}

//Auxiliary method of Student_Registration()
public static boolean Availability(Student[] array) {
	boolean av=false;
	//We check if there is availability in this class in the current school year
	for (int i=0;i<array.length;i++) {
		if (array[i]==null) {
			av=true;
			break;
		}
		else {
			av=false;
		}
	}
	return av;
}
//Auxiliary method of Student_Registration()
public static void Registration(boolean av, Student[] array) {
	Scanner scanner=new Scanner (System.in);
	Scanner scanner1=new Scanner (System.in);
	if (av==true) {
		//Because there is availability in this class in the current school year, we ask the user to enter the necessary information of the student and we register
		System.out.println("Please enter the student's name: (eg Christos Papadopoulos)");
		String name = scanner.nextLine();
		System.out.println("Please enter the date of birth of the student: (eg 01/01/2015) ");
		String date = scanner1.next();
		for (int i=0;i<array.length;i++) {
			if(array[i]==null) {
				Student s1 = new Student(name,date);
				array[i]=s1;
				System.out.println("The process was completed successfully!");
				break;
			}
		}
	}
	else {
		//Because there is no availability in this class in the current school year we display an inforamtive message
			System.out.println("There is no availability");
	}

}
//Method where a new student register in the current school year
public static void Student_Registration() {
	Scanner scanner=new Scanner(System.in);
	boolean av;//Auxiliary variable where it will show us the availability of the class where the user has chosen
	boolean x=false;//Auxiliary variable where it indicates to us if the user's selection was within the expected
	while (x==false) {
		System.out.println("In which class do you want to enroll the student? \n [Enter 1: PreKindergarten or 2: kindergarten 0: Return to Menu]");
		String input = scanner.next();
		if (input.equals("1")) {
			//First we find the availability in the current school year and in the classroom where the user chose
			av=SchoolYear.Availability(SchoolYears[count-1].Students1);
			//Then we register if our availability allows
			SchoolYear.Registration(av,SchoolYears[count-1].Students1);
			x=true;//We stop the loop because the process is complete
		}
		else if (input.equals("2")){
			av=SchoolYear.Availability(SchoolYears[count-1].Students2);
			SchoolYear.Registration(av,SchoolYears[count-1].Students2);
			x=true;
			}
		else  if (input.equals("0")) {
			break;//We stop the loop the user entered 0
		}
		else {
			System.out.println("Wrong input!!");
			x=false;//We continue the loop because the user did not enter an expected option
		}
	}
}
//Auxiliary method of Student_Unregistration()
public static boolean Student_Index(String id,Student [] array) {
	Scanner scanner=new Scanner(System.in);
	boolean Find_Id=false;//Initialize a variable where it will be returned
	for (int i=0;i<array.length;i++) {
		if (array[i]!=null) {
			if (array[i].getId().equalsIgnoreCase(id)){
				//We check if the id exists in the specific table type Student [] and if we find it we display an appropriate message to complete the deletion
				Find_Id=true;
				System.out.println("Are you sure you want to delete the student? \n [Enter 1: Yes or 0: No]");
				boolean x=false;
				while (x==false) {
					String input = scanner.next();
					if (input.equals("1")) {
						//If the answer is yes we proceed to delete the student with the specific id and display an appropriate message
						array[i]=null;
						System.out.println("Deletion completed successfully!");
						x=true;//We stop the loop so that it stops searching
					}
					else if (input.equals("0")) {
						//If the answer is no we stop the process
						System.out.println("Deletion did not take place!");
						x=true;
					}
					else {
						//If the answer is not as expected we continue to ask for an answer
						System.out.println("Wrong choice");
						System.out.println("Please enter an available option: \n [Enter 1: Yes or 0: No]");
					}
				}
				break;//We stop the outer loop as the id was found
			}
		}
	}
	return Find_Id;
}
//Method where create a new student in the current school year
public static void Student_Unregistration() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//Auxiliary variable where indicates if the user entered a registered id of the current school year
	while (x==false) {
		x=true;//Stop loop as the purpose is to execute the loop at least once
		System.out.println("Please enter the student's id: \n [(eg S190011) or enter 0 to return to Menu]");
		String input = scanner.next();
		if (input.equals("0")) {
			break;//If the user selects 0 we exit the loop
		}
		else {
			//We do the first search in the table with the PreKindergarten students (boolean return price)
			boolean Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students1);
			if (Find_Id==false) {
				//We check if the specific id was found in the table with the PreKindergarten students, otherwise we make a second search in the table with the pre-school students
				Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students2);
			}
			if (Find_Id==false) {
				//Check if the specific id was found in the table with the Kindergarten students, otherwise we print an appropriate message and start the process from the beginning
				System.out.println("Wrong student id !!");
				x=false;//Continue loop
			}
		}
	}
}
//Auxiliary method of SchoolYear_Data()
public static void Print_Data(Teacher object, Student[] array) {
	//Print an appropriate message and print a teacher for the specific school year and class
	System.out.println("Teacher:\n"+object.getName()+"\nStudents:");
	for (int i=0;i<array.length;i++) {
		//Print all students of the specific school year and class
		if (array[i]!=null) {
		System.out.println(array[i].getName());
		}
	}
}
//Method where it returns the data of a specific school year
public static void SchoolYear_Data() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//Auxiliary variable where it indicates if the school year is entered correctly and is registered
	while (x==false) {
		System.out.println("Please enter school year: \n [(eg 2018-2019) or enter 0 to return to Menu]");
		String input1 = scanner.next();
		if (input1.equals("0")) {
			break;//If the user selects 0 we exit the loop
		}
		else {
			for (int i=0;i<count;i++) {
				if (SchoolYears[i].year.equals(input1)) {
					//We are looking for the school year entered by the user
					x =true;
					boolean y=false;
					while (y==false) {
						//We ask the user in which class he wants to search and we print the appropriate data
						System.out.println("Please enter in which class you want to search: \n [Enter 1: PreKindergarten or 2: Kindergarten or 0: Return to Menu]");
						String input2 = scanner.next();
						if (input2.equals("1")) {
							SchoolYear.Print_Data(SchoolYears[i].object1, SchoolYears[i].Students1);
							y=true;//Stop inner loop as user enters expected option
						}
						else if (input2.equals("2")) {
							SchoolYear.Print_Data(SchoolYears[i].object2, SchoolYears[i].Students2);
							y=true;//Internal loop interruption
						}
						else if (input2.equals("0")) {
							y=true;//Internal loop interruption
						}
						else {
							System.out.println("Wrong input");
						}
					}
					break;//Stop external loop as the school year is found
				}
			}
			if (x==false) {
				//Print an appropriate message when the school year has not been found
				System.out.println("The input you made is either incorrect or there is no data for that year");
			}
		}
	}
}

}





