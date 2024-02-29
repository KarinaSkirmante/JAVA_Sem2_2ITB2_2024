package service;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Karina", "Šķirmante", Degree.mg);
		System.out.println(pr1);
		System.out.println(pr2);
		
		Student stu1 = new Student();
		Student stu2 = new Student("Klāvs", "Grīnvalds");
		System.out.println(stu1);
		System.out.println(stu2);
		
		Course c1 = new Course();
		Course c2 = new Course("Programmēšana tīmeklī JAVA", 4, pr2);
		System.out.println(c1);
		System.out.println(c2);
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, stu2, c2);
		System.out.println(gr1);
		System.out.println(gr2);

	}

}
