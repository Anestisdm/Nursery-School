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

//������� ���� ���������� ��� ��������� ������������ year
public String getYear() {
	return year;
}
//������� ���� ���������� ��� ��������� ������������ object1
public Teacher getObject1() {
	return object1;
}
//������� ���� ���������� ��� ��������� ������������ object2
public Teacher getObject2() {
	return object2;
}
//������� ���� ���������� ��� ������� ������ SchoolYears[]
public static SchoolYear[] getSchoolYears() {
	return SchoolYears;
}
//������� ���� ���������� ��� ������� ��������� count
public static int getCount() {
	return count;
}
//������� ���� ���������� ��� ������� ��������� y
public static int gety() {
	return y;
}

//��������� ������� ��� Student_Registration()
public static boolean Availability(Student[] array) {
	boolean av=false;
	//��������� �� ���� ������������ ���� ��� �������� ������� ������ ������� �������������
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
//��������� ������� ��� Student_Registration()
public static void Registration(boolean av, Student[] array) {
	Scanner scanner=new Scanner (System.in);
	Scanner scanner1=new Scanner (System.in);
	if (av==true) {
		//������ ������� ������������� ���� ������������ ���� ���� �������� ������� ������, ������ ��� ��� ������ �� ������� �� ���������� �������� ��� ������ ��� ��������������� ��� �������
		System.out.println("�������� �������� �� ����� ��� ������: (�� ������� ������������)");
		String name = scanner.nextLine();
		System.out.println("�������� �������� ��� ���������� �������� ��� ������: (�� 01/01/2015) ");
		String date = scanner1.next();
		for (int i=0;i<array.length;i++) {
			if(array[i]==null) {
				Student s1 = new Student(name,date);
				array[i]=s1;
				System.out.println("� ���������� ������������ ��������!");
				break;
			}
		}
	}
	else {
		////������ ��� ������� ������������� ���� ������������ ���� ���� �������� ������� ������ ����������� ��������� ������
			System.out.println("��� ������� �������������");
	}

}
//������� ���� ������������� ������� ���� ������� ���� �������� ������� ������
public static void Student_Registration() {
	Scanner scanner=new Scanner(System.in);
	boolean av;//��������� ��������� ���� �� ��� ������� ��� ������������� ��� ����� ���� ������� � �������
	boolean x=false;//��������� ��������� ���� ��� ����������� �� � ������� ��� ������ ���� ���� ���� ������������
	while (x==false) {
		System.out.println("�� ���� ����� ������ �� ���������������� ��� ������ ��� ������; \n[�������� 1:�������� � 2:����� � 0:E�������� ��� �����]");
		String input = scanner.next();
		if (input.equals("1")) {
			//������ ��������� ��� ������������� ���� �������� ������� ������ ��� ���� ���� ���� ������� � �������
			av=SchoolYear.Availability(SchoolYears[count-1].Students1);
			//���� �������� ��������������� ��� ������� �� � ������������� ��� �� ���������
			SchoolYear.Registration(av,SchoolYears[count-1].Students1);
			x=true;//��������� ��� ����� ������ ������������ � ����������
		}
		else if (input.equals("2")){
			av=SchoolYear.Availability(SchoolYears[count-1].Students2);
			SchoolYear.Registration(av,SchoolYears[count-1].Students2);
			x=true;
			}
		else  if (input.equals("0")) {
			break;//��������� ��� ����� � ������� �������� 0
		}
		else {
			System.out.println("����� ��������!!");
			x=false;//����������� ��� ����� ������ � ������� ��� �������� ������ ����������� �������
		}
	}
}
//��������� ������� ��� Student_Unregistration()
public static boolean Student_Index(String id,Student [] array) {
	Scanner scanner=new Scanner(System.in);
	boolean Find_Id=false;//������������ ���������� ���� �� ����������
	for (int i=0;i<array.length;i++) {
		if (array[i]!=null) {
			if (array[i].getId().equalsIgnoreCase(id)){
				//��������� ��� �� id ������� ���� ������������ ������ ����� Student[] ��� �� �� ������ ����������� ��������� ������ ��� ��� ���������� ��� ���������
				Find_Id=true;
				System.out.println("����� �������� ��� ���������� ��� �������� ��� ������; \n[�������� 1:��� � 0:���]");
				boolean x=false;
				while (x==false) {
					String input = scanner.next();
					if (input.equals("1")) {
						//�� � �������� ����� ������ ��������� �� �������� ��� ������ �� �� ������������ id ��� ����������� ��������� ������
						array[i]=null;
						System.out.println("� �������� ������������ ��������!");
						x=true;//��������� ��� ����� ���� ���� �� ���������� ��� ���������
					}
					else if (input.equals("0")) {
						//�� � �������� ����� �������� ��������� ��� ����������
						System.out.println("� �������� ��� ����������������!");
						x=true;
					}
					else {
						//�� � �������� ��� ����� ���� ������������ ����������� �� ������ ������ ��������
						System.out.println("����� �������");
						System.out.println("�������� �������� ������ ��������� �������: \n[�������� 1:��� � 0:���]");
					}
				}
				break;//��������� ��� ��������� ����� ����� ������� �� id
			}
		}
	}
	return Find_Id;
}
//������� ���� ������������� �������� ���� ������� ���� �������� ������� ������
public static void Student_Unregistration() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//��������� ��������� ���� ��� ����������� �� � ������� �������� ������������ id ��� ��������� �������� �������
	while (x==false) {
		x=true;//������� ������ ����� ������ ����� �� ���������� ����������� ��� ���� � ������
		System.out.println("�������� �������� �� id ��� ������: \n[(�� S190011) � �������� 0 ��� ��������� ��� �����]");
		String input = scanner.next();
		if (input.equals("0")) {
			break;//�� � ������� ��������  0 ��������� ��� ��� �����
		}
		else {
			//������� ��� ����� ��������� ���� ������ �� ���� ������� ��� ��������� (���� ���������� boolean)
			boolean Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students1);
			if (Find_Id==false) {
				//��������� �� ������� ���� ������ �� ���� ������� ��� ��������� �� ������������ id, ������ ��������������� ������� ��������� ���� ������ �� ���� ������� ��� ������
				Find_Id=SchoolYear.Student_Index(input,SchoolYears[count-1].Students2);
			}
			if (Find_Id==false) {
				//��������� �� ������� ���� ������ �� ���� ������� ��� ������ �� ������������ id, ������ ����������� ��������� ������ ��� ��������� ��� ���������� ��� ��� ����
				System.out.println("����� id ������!!");
				x=false;//�������� ������
			}
		}
	}
}
//��������� ������� ��� SchoolYear_Data()
public static void Print_Data(Teacher object, Student[] array) {
	//�������� ���������� ��������� ��� �������� �������� ��� ��� ������������ ������� ������ ��� ����
	System.out.println("��������:\n"+object.getName()+"\n�������:");
	for (int i=0;i<array.length;i++) {
		//�������� ���� ��� ������� ��� ������������� �������� ������� ��� �����
		if (array[i]!=null) {
		System.out.println(array[i].getName());
		}
	}
}
//������� ���� ���������� �� �������� ������������� �������� �������
public static void SchoolYear_Data() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//��������� ��������� ���� ��� ����������� �� � ������� ������ �������� ����� ��� ����� ������������
	while (x==false) {
		System.out.println("�������� �������� ������� ������: \n[(�� 2018-2019) � �������� 0 ��� ��������� ��� M����]");
		String input1 = scanner.next();
		if (input1.equals("0")) {
			break;//�� � ������� ��������  0 ��������� ��� ��� �����
		}
		else {
			for (int i=0;i<count;i++) {
				if (SchoolYears[i].year.equals(input1)) {
					//��������� ��� ������� ������ ��� �������� � �������
					x =true;
					boolean y=false;
					while (y==false) {
						//������ ��� ��� ������ �� ���� ���� �������� �� ��������������� ��������� ��� ����������� �� ��������� ��������
						System.out.println("�������� �������� �� ���� ���� ������ �� ���������������� ���������: \n[�������� 1:�������� � 2:����� � 0:E�������� ��� �����]");
						String input2 = scanner.next();
						if (input2.equals("1")) {
							SchoolYear.Print_Data(SchoolYears[i].object1, SchoolYears[i].Students1);
							y=true;//������� ���������� ������ ����� � ������� �������� ����������� �������
						}
						else if (input2.equals("2")) {
							SchoolYear.Print_Data(SchoolYears[i].object2, SchoolYears[i].Students2);
							y=true;//������� ���������� ������
						}
						else if (input2.equals("0")) {
							y=true;//������� ���������� ������
						}
						else {
							System.out.println("����� ��������");
						}
					}
					break;//������� ���������� ������ ����� � ������� ������ �������
				}
			}
			if (x==false) {
				//�������� ���������� ��������� ���� � ������� ������ ��� ���� ������
				System.out.println("� �������� ��� ���������������� ���� ����� ����� ���� ��� �������� �������� ��� ��� ������������ ������");
			}
		}
	}
}

}





