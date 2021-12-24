import java.util.Scanner;

public class SchoolYear {
private String year;//School year of attendance
private Teacher object1;//Saves the pre-school teacher in the specific school year
private Teacher object2;//Saves the infant's teacher in that school year
private Student[] Students1;//Stores Student objects where they depict preschool students for the specific school year
private Student[] Students2;//Stores Student items where they depict infant students for the specific school year
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

//Μέθοδος όπου επιστρέφει την μεταβλητή στιγμιοτύπου year
public String getYear() {
	return year;
}
//Μέθοδος όπου επιστρέφει την μεταβλητή στιγμιοτύπου object1
public Teacher getObject1() {
	return object1;
}
//Μέθοδος όπου επιστρέφει την μεταβλητή στιγμιοτύπου object2
public Teacher getObject2() {
	return object2;
}
//Μέθοδος όπου επιστρέφει τον στατικό πίνακα SchoolYears[]
public static SchoolYear[] getSchoolYears() {
	return SchoolYears;
}
//Μέθοδος όπου επιστρέφει την στατική μεταβλητή count
public static int getCount() {
	return count;
}
//Μέθοδος όπου επιστρέφει την στατική μεταβλητή y
public static int gety() {
	return y;
}

//Βοηθητική μέθοδος της Student_Registration()
public static boolean Availability(Student[] array) {
	boolean av=false;
	//Ελέγχουμε αν στην συγκεκριμένη τάξη την τρέχουσα σχολική χρονιά υπάρχει διαθεσιμότητα
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
//Βοηθητική μέθοδος της Student_Registration()
public static void Registration(boolean av, Student[] array) {
	Scanner scanner=new Scanner (System.in);
	Scanner scanner1=new Scanner (System.in);
	if (av==true) {
		//Επειδή υπάρχει διαθεσιμότητα στην συγκεκριμένη τάξη στην τρέχουσα σχολική χρονιά, ζητάμε απο τον χρήστη να εισάγει τα απαραίτητα στοιχεία του μαθητή και πραγματοποιούμε την εγγραφή
		System.out.println("Παρακαλώ εισάγετε το όνομα του μαθητή: (πχ Χρήστος Παπαδόπουλος)");
		String name = scanner.nextLine();
		System.out.println("Παρακαλώ εισάγετε την ημερομηνία γέννησης του μαθητή: (πχ 01/01/2015) ");
		String date = scanner1.next();
		for (int i=0;i<array.length;i++) {
			if(array[i]==null) {
				Student s1 = new Student(name,date);
				array[i]=s1;
				System.out.println("Η διαδικασία ολοκληρώθηκε επιτυχώς!");
				break;
			}
		}
	}
	else {
		////Επειδή δεν υπάρχει διαθεσιμότητα στην συγκεκριμένη τάξη στην τρέχουσα σχολική χρονιά εμφανίζουμε κατάλληλο μήνυμα
			System.out.println("Δεν υπάρχει διαθεσιμότητα");
	}

}
//Μέθοδος όπου πραγματοποιεί εγγραφή νέου φοιτητή στην τρέχουσα σχολική χρονιά
public static void Student_Registration() {
	Scanner scanner=new Scanner(System.in);
	boolean av;//Βοηθητική μεταβλητή όπου θα μας δείχνει την διαθεσιμότητα της τάξης όπου επέλεξε ο χρήστης
	boolean x=false;//Βοηθητική μεταβλητή όπου μας υποδεικνύει αν η επιλογή του χρήστη ήταν μέσα στις αναμενόμενες
	while (x==false) {
		System.out.println("Σε ποιο τμήμα θέλετε να πραγματοποιήσετε την εγραφή του μαθητή; \n[Εισάγετε 1:Προνήπιο ή 2:Νήπιο ή 0:Eπιστροφή στο Μενού]");
		String input = scanner.next();
		if (input.equals("1")) {
			//Αρχικά βρίσκουμε την διαθεσιμότητα στην τρέχουσα σχολική χρονιά και στην τάξη όπου επέλεξε ο χρήστης
			av=SchoolYear.Availability(SchoolYears[count-1].Students1);
			//Στην συνέχεια πραγματοποιούμε την εγγραφή αν η διαθεσιμότητα μας το επιτρέπει
			SchoolYear.Registration(av,SchoolYears[count-1].Students1);
			x=true;//Σταματάμε τον βρόχο επειδή ολοκληρώθηκε η διαδικασία
		}
		else if (input.equals("2")){
			av=SchoolYear.Availability(SchoolYears[count-1].Students2);
			SchoolYear.Registration(av,SchoolYears[count-1].Students2);
			x=true;
			}
		else  if (input.equals("0")) {
			break;//Σταματάμε τον βρόχο ο χρήστης εισήγαγε 0
		}
		else {
			System.out.println("Λάθος εισαγωγή!!");
			x=false;//Συνεχίζουμε τον βρόχο επειδή ο χρήστης δεν εισήγαγε κάποια αναμενόμενη επιλογή
		}
	}
}
//Βοηθητική μέθοδος της Student_Unregistration()
public static boolean Student_Index(String id,Student [] array) {
	Scanner scanner=new Scanner(System.in);
	boolean Find_Id=false;//Αρχικοποίηση μεταβλητής όπου θα επιστραφεί
	for (int i=0;i<array.length;i++) {
		if (array[i]!=null) {
			if (array[i].getId().equalsIgnoreCase(id)){
				//Ελέγχουμε εάν το id υπάρχει στον συγκεκριμένο πίνακα τύπου Student[] και αν το βρούμε εμφανίζουμε κατάλληλο μήνυμα για την ολοκλήρωση της διαγραφής
				Find_Id=true;
				System.out.println("Είστε σίγουροι ότι επιθυμείτε την διαγραφή του μαθητή; \n[Εισάγετε 1:Ναι ή 0:Όχι]");
				boolean x=false;
				while (x==false) {
					String input = scanner.next();
					if (input.equals("1")) {
						//Αν η απάντηση είναι θετική προχωράμε σε διαγραφη του μαθητή με το συγκεκριμένο id και εμφανίζουμε κατάλληλο μήνυμα
						array[i]=null;
						System.out.println("Η διαγραφή ολοκληρώθηκε επιτυχώς!");
						x=true;//Σταματάμε τον βρόχο έτσι ώστε να σταματήσει την αναζήτηση
					}
					else if (input.equals("0")) {
						//Αν η απάντηση είναι αρνητική σταματάμε την διαδικασία
						System.out.println("Η διαγραφή δεν πραγματοποιήθηκε!");
						x=true;
					}
					else {
						//Αν η απάντηση δεν είναι στις αναμενόμενες συνεχίζουμε να ζητάμε κάποια απάντηση
						System.out.println("Λάθος επιλογή");
						System.out.println("Παρακαλώ εισάγετε κάποια διαθέσιμη επιλογή: \n[Εισάγετε 1:Ναι ή 0:Όχι]");
					}
				}
				break;//Σταματάμε τον εξωτερικό βρόχο καθώς βρέθηκε το id
			}
		}
	}
	return Find_Id;
}
//Μέθοδος όπου πραγματοποιεί διαγραφή νέου φοιτητή στην τρέχουσα σχολική χρονιά
public static void Student_Unregistration() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//Βοηθητική μεταβλητή όπου μας υποδεικνύει αν ο χρήστης εισήγαγε καταχωρημένο id της τρέχουσας σχολικής χρονιάς
	while (x==false) {
		x=true;//Διακοπή βρόχου καθώς σκοπός είναι να εκτελεσθεί τουλάχιστον μια φορά ο βρόχος
		System.out.println("Παρακαλώ εισάγετε το id του μαθητή: \n[(πχ S190011) ή εισάγετε 0 για επιστροφή στο Μενού]");
		String input = scanner.next();
		if (input.equals("0")) {
			break;//Αν ο χρηστης επιλέξει  0 βγαίνουμε απο τον βρόχο
		}
		else {
			//Κάνουμε την πρώτη αναζήτηση στον πίνακα με τους μαθητές του προνηπίου (τιμή επιστροφής boolean)
			boolean Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students1);
			if (Find_Id==false) {
				//Ελέγχουμε αν βρέθηκε στον πίνακα με τους μαθητές του προνηπίου το συγκεκριμένο id, αλλιως πραγματοποιούμε δεύτερη αναζήτηση στον πίνακα με τους μαθητές του νηπίου
				Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students2);
			}
			if (Find_Id==false) {
				//Ελέγχουμε αν βρέθηκε στον πίνακα με τους μαθητές του νηπίου το συγκεκριμένο id, αλλίως εκτυπώνουμε κατάλληλο μήνυμα και εκκινούμε την διαδικασία απο την αρχή
				System.out.println("Λάθος id μαθητή!!");
				x=false;//Συνέχιση βρόχου
			}
		}
	}
}
//Βοηθητική μέθοδος της SchoolYear_Data()
public static void Print_Data(Teacher object, Student[] array) {
	//Εκτύπωση κατάλληλου μηνύματος και εκτύπωση καθηγητή για την συγκεκριμένη σχολική χρονιά και τάξη
	System.out.println("Δάσκαλος:\n"+object.getName()+"\nΜαθητές:");
	for (int i=0;i<array.length;i++) {
		//Εκτύπωση όλων των μαθητών της συγκεκριμένης σχολικής χρονιάς και τάξης
		if (array[i]!=null) {
		System.out.println(array[i].getName());
		}
	}
}
//Μέθοδος όπου επιστρέφει τα στοιχεία συγκεκριμένης σχολικής χρονιάς
public static void SchoolYear_Data() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//Βοηθητική μεταβλητή όπου μας υποδεικνυει αν η σχολική χρονιά εισήχθει σωστά και είναι καταχωρημένη
	while (x==false) {
		System.out.println("Παρακαλώ εισάγετε σχολική χρονιά: \n[(πχ 2018-2019) ή εισάγετε 0 για επιστροφή στο Mενού]");
		String input1 = scanner.next();
		if (input1.equals("0")) {
			break;//Αν ο χρηστης επιλέξει  0 βγαίνουμε απο τον βρόχο
		}
		else {
			for (int i=0;i<count;i++) {
				if (SchoolYears[i].year.equals(input1)) {
					//Ανζητούμε την σχολική χρονιά που εισήγαγε ο χρήστης
					x =true;
					boolean y=false;
					while (y==false) {
						//Ζητάμε απο τον χρήστη σε ποια τάξη επιθυμεί να πραγματοποιήσει αναζήτηση και εκτυπώνουμε τα κατάλληλα δεδομένα
						System.out.println("Παρακαλώ εισάγετε σε ποια τάξη θέλετε να πραγματοποιήσετε αναζήτηση: \n[Εισάγετε 1:Προνήπιο ή 2:Νήπιο ή 0:Eπιστροφή στο Μενού]");
						String input2 = scanner.next();
						if (input2.equals("1")) {
							SchoolYear.Print_Data(SchoolYears[i].object1, SchoolYears[i].Students1);
							y=true;//Διακοπή εσωτερικού βρόχου καθώς ο χρήστης εισήγαγε αναμενόμενη επιλογή
						}
						else if (input2.equals("2")) {
							SchoolYear.Print_Data(SchoolYears[i].object2, SchoolYears[i].Students2);
							y=true;//Διακοπή εσωτερικού βρόχου
						}
						else if (input2.equals("0")) {
							y=true;//Διακοπή εσωτερικού βρόχου
						}
						else {
							System.out.println("Λάθος εισαγωγή");
						}
					}
					break;//Διακοπή εξωτερικού βρόχου καθώς η σχολική χρονιά βρέθηκε
				}
			}
			if (x==false) {
				//Εκτύπωση κατάλληλου μηνύματος όταν η σχολική χρονία δεν έχει βρεθεί
				System.out.println("Η εισαγωγή που πραγματοποιήσατε είτε είναι λάθος είτε δεν υπάρχουν δεδομένα για την συγκεκριμένη χρονία");
			}
		}
	}
}

}





