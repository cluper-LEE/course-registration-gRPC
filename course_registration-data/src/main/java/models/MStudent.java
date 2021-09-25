package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MStudent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String studentId;
    protected String firstName;
    protected String lastName;
    protected String department;
    protected ArrayList<String> completedCoursesList;
 
    public MStudent(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.studentId = stringTokenizer.nextToken();
    	this.lastName = stringTokenizer.nextToken();
    	this.firstName = stringTokenizer.nextToken();
    	this.department = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.completedCoursesList.add(stringTokenizer.nextToken());
    	}
    }

    public boolean match(String studentId) {
        return this.studentId.equals(studentId);
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getDepartment() {
		return department;
	}

	public ArrayList<String> getCompletedCoursesList() {
		return completedCoursesList;
	}

    public String toString() {
        String stringReturn = this.studentId + " " + this.lastName + " " + this.firstName + " "+ this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return stringReturn;
    }

}
