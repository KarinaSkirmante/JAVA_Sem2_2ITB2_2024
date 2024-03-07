package service;

import java.util.ArrayList;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {

	
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	
	public static void main(String[] args) {
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Karina", "Šķirmante", Degree.mg);
		allProfessors.add(pr1);
		allProfessors.add(pr2);
		
		for(Professor tempPr : allProfessors) {
			System.out.println(tempPr);
		}
	
		
		Student stu1 = new Student();
		Student stu2 = new Student("Klāvs", "Grīnvalds");
		allStudents.add(stu1);
		allStudents.add(stu2);
		
		for(Student tempSt: allStudents) {
			System.out.println(tempSt);
		}
		
		
		Course c1 = new Course();
		Course c2 = new Course("Programmēšana tīmeklī JAVA", 4, pr2);
		allCourses.add(c1);
		allCourses.add(c2);
		
		for(Course tempC : allCourses) {
			System.out.println(tempC);
		}
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, stu2, c2);
		Grade gr3 = new Grade(7, stu2, c1);
		allGrades.add(gr1);
		allGrades.add(gr2);
		allGrades.add(gr3);
		
		for(Grade tempGr: allGrades) {
			System.out.println(tempGr);
		}

	}

}
