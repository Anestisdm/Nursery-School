import java.util.Scanner;

public class Teacher {

private String id;//�������� id ��������
private String name;//������������� ��������
private String AMKA;//���� ��������
private static Teacher[] Teachers = new Teacher[100];//�������� ������� ��� �������� ��� �� ����������� ����� Teacher
private static int count = 0;//�������� ������������ ����� Teacher ���� ���������� ���� ���������� ��� ������������ ���� ������� ������ ���� ��� ��� �� ����������� ��� ������������ ������ ��� �� ����������� ��� �������� NullPointerException


//������������� ������ Teacher
public Teacher(String name, String AMKA) {
	Teachers[count] = this;//���������� ������������ ���� ������� ������ Teachers
	count++;		
	this.id = "T"+SchoolYear.gety()+"00"+count;//��������� id ������������ ����� Student ��� ������ T18001
	this.name = name;
	this.AMKA = AMKA;
}

//������� ���� ���������� ��� ��������� ������������ name
public String getName() {
	return name;
}

//������� ���� ��������� ��������� ����� ������ ���� �������� ���� ���������
public static void Teacher_Classes() {
	//����������� ��� ������ ��� ������� ������ Teachers
	for (int i=0;i<count;i++) {
		//�������� ��� �������� ��� �������� ��������
		System.out.println("\n�� ������ ���/��� "+ Teachers[i].name+" ����� �� ����:");
		//����������� ��� ������� ������ SchoolYears ��� ��������� �� ���� ������������ ������ ��������� �� ����� ��� �������� ��� ���� ������� ����������� ��� ������� ������ ����� ��� ��� ���� ���� ���� ��������
		for (int x=0;x<SchoolYear.getCount();x++) { 
			if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject1().name)) {
				System.out.println("�� ���� "+SchoolYear.getSchoolYears()[x].getYear()+" ��� ���� ��� ���������");
			}
			else if (Teachers[i].name.equals(SchoolYear.getSchoolYears()[x].getObject2().name)) {
				System.out.println("�� ���� "+SchoolYear.getSchoolYears()[x].getYear()+" ��� ���� ��� ������");
			}
		}		
	}
}

//������� ���� �������� �������� �������� �� ��� ���� ���� ��������� ��� ���� �������� �� ���������
public static void AMKA_Index() {
	Scanner scanner=new Scanner(System.in);
	boolean x=false;//��������� ��������� ���� ��� ����������� �� � ���� ��� �������� � ������� �������� ���� �����
	while (x==false) {
		System.out.println("�������� �������� ��� ���� ��� ��������: \n[(�� 17077732902) � �������� 0 ��� ��������� ��� �����]");
		String input = scanner.next();
		//������� ���� ������ ��� ������� �� ������� 0 ��� �� ����������� � ���������
		if (input.equals("0")) {
			x=true;//��������� ��� ����� ������ � ������� �������� 0
		}
		else {
			//����������� ��� ������� ������ Teachers
			for (int i=0;i<count;i++) { 
				if (Teachers[i].AMKA.equals(input)) {
					//�� ������ ����������� ����� Teacher �� ���� (��������� �������������) ���� ����� ����� �� ��� �������� ����������� �� �������� ��� ������������� ��������
					System.out.println("\n�� �������� ��� �������� �� ���� '"+input+"' ����� �� ����:\nId:"+Teachers[i].id+"\n�������������:"+Teachers[i].name);
					x=true;//��������� ��� ����� ������ ������� � �������� 
				}
			}
		}
		if (x==false) {
			//����������� ��������� ������ ����� ���������� ��� ��� ������� ����������� ����� Teacher �� ���� (��������� ������������) ���� ����� ����� �� ��� �������� ��� ������
			System.out.println("� ���� ��� �������� ��� ����������� �� ������� �������");	
		}	
	}
}

}
