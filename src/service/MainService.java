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
		Student stu2 = new Student("Klāvs", "Grīnvalds", "121290-45678");
		allStudents.add(stu1);
		allStudents.add(stu2);
		
		for(Student tempSt: allStudents) {
			System.out.println(tempSt);
		}
		
		
		Course c1 = new Course();
		Course c2 = new Course("Programmēšana tīmeklī JAVA", 4, pr2);
		Course c3 = new Course("Objektoerientētā programmēšana II", 4, pr2);
		allCourses.add(c1);
		allCourses.add(c2);
		allCourses.add(c3);
		
		for(Course tempC : allCourses) {
			System.out.println(tempC);
		}
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, stu2, c2);
		Grade gr3 = new Grade(7, stu2, c1);
		Grade gr4 = new Grade(3, stu1, c2);
		allGrades.add(gr1);
		allGrades.add(gr2);
		allGrades.add(gr3);
		allGrades.add(gr4);
		
		for(Grade tempGr: allGrades) {
			System.out.println(tempGr);
		}
		
		try
		{
			System.out.println(stu2.getName() + " " + stu2.getSurname() 
			+ "-> vidējā atzīme ir " + calculateAVGgradeByStudent(stu2));
			
			System.out.println(c2.getTitle() + " -> vidēja atzīme ir "
			+ calculateAVGgradeInCourse(c2));
			
			System.out.println(pr2.getName() + " " + pr2.getSurname()
					+ " pasniedz " + calculateHowManyCoursesByProfessor(pr2)
					+ " kursus");
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
	//TODO
	//Create a new method which calculates average grade based on course credit
	//points (weighted average grade) for each student
	
	
	public static float calculateAVGgradeInCourse(Course course) throws Exception {
		if(course == null) throw new Exception("Problems with input arguments");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getCourse().equals(course)) {
				sum = sum + tempGr.getGrValue();
				howMany++;
			}
		}
		
		//if(howMany == 0) throw new Exception("There is no grade for this course");
		if(howMany == 0) return 0;
		return sum/howMany;
		
	}
	//TODO
	//Create a new method which calculates how many courses does professor
	//teach;
	
	public static int calculateHowManyCoursesByProfessor(Professor professor) 
			throws Exception
	{
		if(professor == null) throw new Exception("Problems with input arguments");
		
		int howMany = 0;
		
		
		for(Course tempCr: allCourses) {
			if(tempCr.getProfessor().equals(professor)) {
				howMany++;
			}
		}

		return howMany;
		
	}
	
	
	//CRUD - create - retrieve - update - delete
	//CREATE
	public static void createNewStudent(String name, String surname, String personCode) 
			throws Exception  {
		if(name == null || surname == null || personCode == null) {
			throw new Exception("Problems with input arguments");
		}
		
		
		for(Student tempSt: allStudents) {
			if(tempSt.getPersonCode().equals(personCode)) {
				throw new Exception(tempSt.getName() +" " + tempSt.getSurname()
				+ " is already regeisterd in the system");
			}
		}
		
		Student newStudent = new Student(name, surname, personCode);
		allStudents.add(newStudent);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
