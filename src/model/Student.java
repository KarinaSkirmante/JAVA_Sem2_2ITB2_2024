package model;

public class Student {
	//1.variables
	private long sID;
	private String name;
	private String surname;
	
	private static long counter = 10000; //ne get, ne set funkcijas
	//2.get and set

	public long getsID() {
		return sID;
	}

	public void setsID() {
		this.sID = counter;
		counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && name.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+")) {
			this.name = name;
		}
		else
			this.name = "Undefined";
		
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+")) 
			this.surname = surname;
		else
			this.surname = "Undefined";			
	}
	
	
	//3. constructors
	
	public Student()
	{
		setsID();
		setName("Baiba");
		setSurname("Jaukā");
	}
	
	public Student(String name, String surname) {
		setsID();
		setName(name);
		setSurname(surname);
	}
	//4. toString
	public String toString() {
		return sID + ": " + name + " " + surname;
	}
	
	
	//5. other functions
	

}
