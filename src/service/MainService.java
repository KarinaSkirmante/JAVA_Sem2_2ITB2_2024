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
		
		try
		{
			System.out.println(stu2.getName() + " " + stu2.getSurname() 
			+ "-> vidējā atzīme ir " + calculateAVGgradeByStudent(stu2));
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static float calculateAVGgradeByStudent(Student inputStudent) throws Exception{
		if(inputStudent == null) throw new Exception("Problems with input arguments");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getGrValue();
				howMany++;
			}
		}
		
		//if(howMany == 0) throw new Exception("There is no grade for this student");
		if(howMany == 0) return 0;
		return sum/howMany;
		
		
		
		
		
	}

}
