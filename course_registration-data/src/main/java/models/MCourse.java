package models;

import java.io.Serializable;
import java.util.StringTokenizer;

public class MCourse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String courseId;
    protected String profName;
    protected String courseName;
 
    public MCourse(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.courseId = stringTokenizer.nextToken();
    	this.courseName = stringTokenizer.nextToken();
    	this.profName = stringTokenizer.nextToken();
    }

    public boolean match(String studentId) {
        return this.courseId.equals(studentId);
    }


    public String getCourseId() {
		return courseId;
	}

	public String getProfName() {
		return profName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String toString() {
        String stringReturn = this.courseId + " " + this.courseName + " " + this.profName;
        return stringReturn;
    }

}
