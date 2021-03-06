import java.util.Scanner;

public class Teacher {

private String id;//Μοναδικό id δασκάλου
private String name;//Ονοματεπώνυμο δασκάλου
private String AMKA;//ΑΜΚΑ δασκάλου
private static Teacher[] Teachers = new Teacher[100];//Στατικός πίνακας που περιέχει όλα τα αντικείμενα τύπου Teacher
private static int count = 0;//Μετρητής αντικειμένων τύπου Teacher όπου χρησιμεύει στην αποθήκευση των αντικειμένων στον στατικό πίνακα αλλα και στο να διατρέχουμε τον συγκεκριμένο πίνακα και να αποφεύγουμε την εξαίρεση NullPointerException


//Κατασκευαστής κλάσης Teacher
public Teacher(String name, String AMKA) {
	Teachers[count] = this;//Αποθήκευση αντικειμένων στον στατικό πίνακα Teachers
	count++;		
	this.id = "T"+SchoolYear.gety()+"00"+count;//Κατασκευή id αντικειμένων τύπου Student της μορφης T18001
	this.name = name;
	this.AMKA = AMKA;
}

//Μέθοδος όπου επιστρέφει την μεταβλητή στιγμιοτύπου name
public String getName() {
	return name;
}

//Μέθοδος όπου εκτυπώνει αναλυτικά ποιες τάξεις έχει αναλάβει κάθε καθηγητής
public static void Teacher_Classes() {
	//Διατρέχουμε τον πίνακα τον στατικό πίνακα Teachers
	for (int i=0;i<count;i++) {
		//Εκτύπωση του ονόματος του εκάστοτε καθηγητή
		System.out.println("\nΟι τάξεις του/της "+ Teachers[i].name+" είναι οι εξής:");
		//Διατρέχουμε τον στατικό πίνακα SchoolYears και ελέγχουμε αν στην συγκεκριμένη χρονία βρίσκεται το όνομα του δασκάλου και στην συνέχει εκτυπώνουμε την σχολική χρονία καθώς και την τάξη όπου είχε αναλάβει
		for (int x=0;x<SchoolYear.getCount();x++) { 
			if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject1().name)) {
				System.out.println("Το έτος "+SchoolYear.getSchoolYears()[x].getYear()+" την τάξη του προνηπίου");
			}
			else if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject2().name)) {
				System.out.println("Το έτος "+SchoolYear.getSchoolYears()[x].getYear()+" την τάξη του νηπίου");
			}
		}		
	}
}

//Μέθοδος όπου αναζητεί στοιχεία δασκάλου με τον ΑΜΚΑ όπου εισάγουμε και στην συνέχεια τα εμφανίζει
public static void AMKA_Index() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//Βοηθητική μεταβλητη όπου μας υποδεικνύει αν ο ΑΜΚΑ που εισήγαγε ο χρήστης υπάρχουν στην μνήμη
	while (x==false) {
		System.out.println("Παρακαλώ εισάγετε τον ΑΜΚΑ του καθηγητή: \n[(πχ 17077732902) ή εισάγετε 0 για επιστροφή στο Μενού]");
		String input = scanner.next();
		//Δίνουμε στον χρήστη την επιλογή να πατήσει 0 και να τερματιστεί η αναζήτηση
		if (input.equals("0")) {
			x=true;//Σταματάμε τον βρόχο επειδή ο χρήστης εισήγαγε 0
		}
		else {
			//Διατρέχουμε τον στατικό πίνακα Teachers
			for (int i=0;i<count;i++) { 
				if (Teachers[i].AMKA.equals(input)) {
					//Αν βρόυμε αντικείμενο τύπου Teacher με ΑΜΚΑ (μεταβλητή στιγμιοτύοπου) όπου είναι ίδιος με την εισαγωγή εμφανίζουμε τα στοιχεία του συγκεκριμένου δασκάλου
					System.out.println("\nΤα στοιχεία του δασκάλου με ΑΜΚΑ '"+input+"' είναι τα εξής:\nId:"+Teachers[i].id+"\nΟνοματεπώνυμο:"+Teachers[i].name);
					x=true;//Σταματάμε τον βρόχο επειδή βρέθηκε ο δάσκαλος 
				}
			}
		}
		if (x==false) {
			//Εμφανίζουμε κατάλληλο μύνημα καθώς γνωρίζουμε ότι δεν βρέθηκε αντικείμενο τύπου Teacher με ΑΜΚΑ (μεταβλητή στιγμιοτύπου) όπου είναι ίδιος με την εισαγωγή του χρήστη
			System.out.println("Ο ΑΜΚΑ που εισάγατε δεν αντιστοιχεί σε κάποιον δάσκαλο");	
		}	
	}
}

}
