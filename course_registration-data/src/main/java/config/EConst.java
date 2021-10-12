package config;

public enum EConst {
	STUDENT_FILE_NAME("/Students.txt"),
	COURSE_FILE_NAME("/Courses.txt"), 
	REGISTRATION_FILE_NAME("/Registration.txt");
	
	private String value;
	private EConst(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}
}
