
public class Student {
private String id;//Μοναδικό id μαθητή
private String name;//Ονοματεπώνυμο μαθητή
private String date_birth;//Ημερομηνία γέννησης μαθητή
private static Student[] Students = new Student[100];//Στατικός πίνακας που περιέχει όλα τα αντικείμενα τύπου Student
private static int count=0;//Μετρητής αντικειμένων τύπου Student όπου χρησιμεύει στην αποθήκευση των αντικειμένων στον στατικό πίνακα

//Κατασκευαστής κλάσης Student
public Student(String name, String date_birth) {
	Students[count]=this;//Αποθήκευση αντικειμένων στον στατικό πίνακα Students
	count++;
	this.id = "S"+SchoolYear.gety()+"00"+count;//Κατασκευή id αντικειμένων τύπου Student της μορφης S18001
	this.name = name;
	this.date_birth = date_birth;
}

//Μέθοδος όπου εκτυπώνει όλους τους μαθητές οπου έχουν φοιτήσει ή φοιτούν στον νηπιακό σταθμό
public static void Print_Students() {
	for (Student s: Students)
		if (s!=null) {
			System.out.println(s.name+" [ Κωδικός ID:"+s.id+", Ημ.Γέννησης:"+s.date_birth+" ]");
		}
}
//Μέθοδος όπου επιστρέφει την μεταβλητή στιγμιοτύπου id
public String getId() {
	return id;
}

//Μέθοδος όπου επιστρέφει την μεταβλητη στιγμιοτύπου name
public String getName() {
	return name;
}


}
