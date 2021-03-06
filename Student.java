
public class Student {
private String id;//�������� id ������
private String name;//������������� ������
private String date_birth;//���������� �������� ������
private static Student[] Students = new Student[100];//�������� ������� ��� �������� ��� �� ����������� ����� Student
private static int count=0;//�������� ������������ ����� Student ���� ���������� ���� ���������� ��� ������������ ���� ������� ������

//������������� ������ Student
public Student(String name, String date_birth) {
	Students[count]=this;//���������� ������������ ���� ������� ������ Students
	count++;
	this.id = "S"+SchoolYear.gety()+"00"+count;//��������� id ������������ ����� Student ��� ������ S18001
	this.name = name;
	this.date_birth = date_birth;
}

//������� ���� ��������� ����� ���� ������� ���� ����� �������� � ������� ���� ������� ������
public static void Print_Students() {
	for (Student s: Students)
		if (s!=null) {
			System.out.println(s.name+" [ ������� ID:"+s.id+", ��.��������:"+s.date_birth+" ]");
		}
}
//������� ���� ���������� ��� ��������� ������������ id
public String getId() {
	return id;
}

//������� ���� ���������� ��� ��������� ������������ name
public String getName() {
	return name;
}


}
