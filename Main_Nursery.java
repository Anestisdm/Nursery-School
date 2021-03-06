import java.util.Scanner;

public class Main_Nursery {

	public static void main(String[] args) {
		Create_Objects();//Κατασκεύη βοηθητικών αντικειμένων για έλεγχο εφαρμογής
		Scanner scanner= new Scanner(System.in);
		int x=1;//Βοηθητική μεταβλητή οπου μας βοηθάει στον τερματισμό της εφαρμογής
		while (x!=0) {
			//Εκτύπωση Μενού επιλογών
			System.out.println("\n~~~~~~~~~~ Μενού Επιλογών ~~~~~~~~~~");
			System.out.println("1.Εκτύπωση όλων των μαθητών που έχουν φοιτήσει στο σχολείο");
			System.out.println("2.Εγγραφή νέου μαθητή στην τρέχουσα σχολική χρονιά");
			System.out.println("3.Διαγραφή μαθητή από την τρέχουσα σχολική χρονιά");
			System.out.println("4.Αναζήτηση στοιχείων σχολικής χρονιάς");
			System.out.println("5.Αναζήτηση τάξεων που έχει αναλάβει κάθε δάσκαλος του σχολείου");
			System.out.println("6.Αναζήτηση στοιχείων δασκάλου μέσω ΑΜΚΑ");
			System.out.println("   Εισάγετε επιλογή [1-6] :   ");
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
				System.out.println("Λάθος εισαγωγή");
			}
		}
	}
	//Μέθοδος κατασκευής αντικειμένων
	private static void Create_Objects() {
		Student s1_18= new Student ("Βασίλειος Παπαδόπουλος","18/03/2015");
		Student s2_18= new Student ("Ελευθερία Γρηγορίου", "03/06/2015");
		Student s3_18= new Student ("Κωνσταντίνα Αναστασάκη","03/12/2015");
		Student s4_18= new Student ("Νικόλαος Μαυρόπουλος","14/05/2015");
		Student s5_18= new Student ("Γεώργιος Αντωνόπουλος","03/09/2015");
		Student s6_18= new Student ("Ευστάθιος Δημητρίου","11/02/2014");
		Student s7_18= new Student ("Θεόδωρος Μπάσης","27/04/2014");
		Student s8_18= new Student ("Αγγελίνα Καρακάση","18/01/2014");
		Student s9_18= new Student ("Ελένη Καλογιάννη", "22/11/2014");
		Student s10_18= new Student ("Τζώρτζια Κεχαγιά","09/08/2014");
		Teacher t1=new Teacher("Μαρία Γιανέλλου","01058219503");
		Teacher t2=new Teacher("Κωνσταντίνα Ζαφειροπούλου","17077732902");
		Student[] st1_18 = {s1_18,s2_18,s3_18,s4_18,s5_18,null,null,null,null,null};
		Student[] st2_18 = {s6_18,s7_18,s8_18,s9_18,s10_18,null,null,null,null,null};
		SchoolYear y18 = new SchoolYear ("2018-2019",st1_18,t1,st2_18,t2);

		Student s1_19= new Student ("Αλέξανδρος Βαφειάδης","30/06/2016");
		Student s2_19= new Student ("Ειρήνη Αλεξοπούλου", "24/03/2016");
		Student s3_19= new Student ("Δήμητρα Γιαννακού","07/02/2016");
		Student s4_19= new Student ("Χαράλαμπος Καλογεράς","28/11/2016");
		Student s5_19= new Student ("Βασιλική Ελευθεριάδου","11/08/2016");
		Student s6_19= new Student ("Νικόλαος Βούρος","27/09/2015");
		Student s7_19= new Student ("Ηλίας Γαλανόπουλος","04/06/2015");
		Student s8_19= new Student ("Αθηνά Δελή","11/01/2015");
		Student s9_19= new Student ("Στέλλα Ιωαννίδου", "24/09/2015");
		Student s10_19= new Student ("Μαριάννα Κομνηνού","18/04/2015");
		Teacher t3= new Teacher("Νικολέττα Ανδρούτσου","21088432605");
		Student[] st1_19 = {s1_19,s2_19,s3_19,s4_19,s5_19,null,null,null,null,null,null,null,null,null,null};
		Student[] st2_19 = {s6_19,s7_19,s8_19,s9_19,s10_19,null,null,null,null,null,null,null,null,null,null};
		SchoolYear y19 = new SchoolYear ("2019-2020",st1_19,t1,st2_19,t3);
	}

}
