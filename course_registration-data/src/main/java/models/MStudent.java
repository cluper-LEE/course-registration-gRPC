package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import com.cluper.course_registration.Student;

public class MStudent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String studentId;
    protected String firstName;
    protected String lastName;
    protected String department;
    protected ArrayList<String> completedCoursesList;
 
    public MStudent() {
    	this.completedCoursesList = new ArrayList<>();
    }
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
    public MStudent(Student student) {
    	this.set(student);
	}
    
	public boolean read(BufferedReader reader) {
    	try {
			String stuInfo = "";
			while (reader.ready()) {
				stuInfo = reader.readLine();
				if (!stuInfo.equals("")) {
					StringTokenizer stringTokenizer = new StringTokenizer(stuInfo);
					this.studentId = stringTokenizer.nextToken();
					this.lastName = stringTokenizer.nextToken();
					this.firstName = stringTokenizer.nextToken();
					this.department = stringTokenizer.nextToken();
					this.completedCoursesList = new ArrayList<String>();
			    	while (stringTokenizer.hasMoreTokens()) {
			    		this.completedCoursesList.add(stringTokenizer.nextToken());
			    	}
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return false;
    }
	public boolean add(BufferedWriter writer, Student student) {
		try {
			this.set(student);
			StringJoiner sj = new StringJoiner(" ");
			sj.add(this.studentId).add(this.lastName).add(this.firstName).add(this.department);
			for (String courseId : this.completedCoursesList) {
				sj.add(courseId);
			}
			writer.newLine();writer.newLine();writer.newLine();writer.newLine();
			writer.append(sj.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	private void set(Student student) {
		this.studentId = student.getStudentId();
    	this.firstName = student.getFirstName();
    	this.lastName = student.getLastName();
    	this.department = student.getDepartment();
    	this.completedCoursesList.clear();
    	for(String courseID : student.getCourseIdList()) {
    		this.completedCoursesList.add(courseID);
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

    public Student build() {
    	return Student.newBuilder()
    			.setStudentId(this.studentId)
    			.setFirstName(this.firstName)
    			.setLastName(this.lastName)
    			.setDepartment(this.department)
    			.addAllCourseId(completedCoursesList)
    			.build();
    }
	
	
}
