package Nursery-School;

import java.util.Scanner;

public class Main_Nursery {

	public static void main(String[] args) {
		Create_Objects();//Construction of auxiliary objects for testing
		Scanner scanner= new Scanner(System.in);
		int x=1;//Auxiliary variable that helps us to terminate the application
		while (x!=0) {
			//Print Options menu
			System.out.println("\n~~~~~~~~~~ Options Menu ~~~~~~~~~~");
			System.out.println("1.Print all students who have attended the school");
			System.out.println("2.Registration of a new student in the current school year");
			System.out.println("3.Delete student from the current school year");
			System.out.println("4.Search school year data");
			System.out.println("5.Search for classes taken by each teacher in the school");
			System.out.println("6.Search for teacher data via social security number");
			System.out.println("   Enter number [1-6] :   ");
			x= scanner.nextInt();

			switch(x) {
			case 0 :
				break;
			case 1:
				Student.Print_Students();
				break;
			case 2:
				SchoolYear.Student_Registration();
				break;
			case 3:
				SchoolYear.Student_Unregistration();
				break;
			case 4:
				SchoolYear.SchoolYear_Data();
				break;
			case 5:
				Teacher.Teacher_Classes();
				break;
			case 6:
				Teacher.AMKA_Index();
				break;
			default:
				System.out.println("ËÜèïò åéóáãùãÞ");
			}
		}
	}
	//Method of creating objects
	private static void Create_Objects() {
		Student s1_18= new Student ("Vassilios Papadopoulos","18/03/2015");
		Student s2_18= new Student ("Eleftheria Grigoriou", "03/06/2015");
		Student s3_18= new Student ("Konstantina Anastasaki","03/12/2015");
		Student s4_18= new Student ("Nikolaos Mavropoulos","14/05/2015");
		Student s5_18= new Student ("George Antonopoulos","03/09/2015");
		Student s6_18= new Student ("Efstathios Demetriou","11/02/2014");
		Student s7_18= new Student ("Theodoros Vassilakopoulos","27/04/2014");
		Student s8_18= new Student ("Angelina Karakasi","18/01/2014");
		Student s9_18= new Student ("Eleni Kalogianni", "22/11/2014");
		Student s10_18= new Student ("Georgia Kehagia","09/08/2014");
		Teacher t1=new Teacher("Maria Giannellou","01058219503");
		Teacher t2=new Teacher("Konstantina Zafeiropoulou","17077732902");
		Student[] st1_18 = {s1_18,s2_18,s3_18,s4_18,s5_18,null,null,null,null,null};
		Student[] st2_18 = {s6_18,s7_18,s8_18,s9_18,s10_18,null,null,null,null,null};
		SchoolYear y18 = new SchoolYear ("2018-2019",st1_18,t1,st2_18,t2);

		Student s1_19= new Student ("Alexandros Vafiadis","30/06/2016");
		Student s2_19= new Student ("Irini Alexopoulou", "24/03/2016");
		Student s3_19= new Student ("Dimitra Giannakou","07/02/2016");
		Student s4_19= new Student ("Charalampos Kalogeras","28/11/2016");
		Student s5_19= new Student ("Vasiliki Eleftheriadou","11/08/2016");
		Student s6_19= new Student ("Nikolaos Vouroò","27/09/2015");
		Student s7_19= new Student ("Ilias Galanopoulos","04/06/2015");
		Student s8_19= new Student ("Athena Deli","11/01/2015");
		Student s9_19= new Student ("Stella Ioannidou", "24/09/2015");
		Student s10_19= new Student ("Marianna Komninou","18/04/2015");
		Teacher t3= new Teacher("Nikoletta Androutsou","21088432605");
		Student[] st1_19 = {s1_19,s2_19,s3_19,s4_19,s5_19,null,null,null,null,null,null,null,null,null,null};
		Student[] st2_19 = {s6_19,s7_19,s8_19,s9_19,s10_19,null,null,null,null,null,null,null,null,null,null};
		SchoolYear y19 = new SchoolYear ("2019-2020",st1_19,t1,st2_19,t3);
	}

}
