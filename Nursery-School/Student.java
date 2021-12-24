package Nursery-School;

public class Student {
private String id;//Unique student id
private String name;//Student name
private String date_birth;//Student's date of birth
private static Student[] Students = new Student[100];//Static table containing all Student type objects
private static int count=0;//Student type counter where it is used to store objects in the static table

//Constructor of Student class
public Student(String name, String date_birth) {
	Students[count]=this;//Save items to the Students static table
	count++;
	this.id = "S"+SchoolYear.gety()+"00"+count;//Construction of student type id objects of the S18001 format
	this.name = name;
	this.date_birth = date_birth;
}

//Method where it prints all students who have attended or are attending nursery school
public static void Print_Students() {
	for (Student s: Students)
		if (s!=null) {
			System.out.println(s.name+" [ ID code:"+s.id+", Date of Birth:"+s.date_birth+" ]");
		}
}
//Method where returns the instance variable id
public String getId() {
	return id;
}

//Method where it returns the instance variable name
public String getName() {
	return name;
}


}
