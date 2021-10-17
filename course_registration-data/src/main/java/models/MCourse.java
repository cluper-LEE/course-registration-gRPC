package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import com.cluper.course_registration.Course;

public class MCourse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String courseId;
    protected String profName;
    protected String courseName;
    protected List<String> prerequisiteList;
 
    public MCourse() {
    	this.prerequisiteList = new ArrayList<>();
    }
    public MCourse(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.courseId = stringTokenizer.nextToken();
    	this.courseName = stringTokenizer.nextToken();
    	this.profName = stringTokenizer.nextToken();
    	this.prerequisiteList = new ArrayList<>();
    	while(stringTokenizer.hasMoreTokens()) {
    		prerequisiteList.add(stringTokenizer.nextToken());
    	}
    }
    
    public boolean read(BufferedReader reader) {
    	try {
			String courseInfo = "";
			while (reader.ready()) {
				courseInfo = reader.readLine();
				if (!courseInfo.equals("")) {
					StringTokenizer stringTokenizer = new StringTokenizer(courseInfo);
			    	this.courseId = stringTokenizer.nextToken();
			    	this.courseName = stringTokenizer.nextToken();
			    	this.profName = stringTokenizer.nextToken();
			    	this.prerequisiteList = new ArrayList<>();
			    	while(stringTokenizer.hasMoreTokens()) {
			    		this.prerequisiteList.add(stringTokenizer.nextToken());
			    	}
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return false;
    }
    public boolean write(BufferedWriter writer, Course course) {
		try {
			this.set(course);
			StringJoiner sj = new StringJoiner(" ");
			sj.add(this.courseId).add(this.profName).add(this.courseName);
			for(String preId : this.prerequisiteList) {
				sj.add(preId);
			}
			writer.newLine();writer.newLine();writer.newLine();writer.newLine();
			writer.append(sj.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
    
    private void set(Course course) {
		this.courseId = course.getCourseId();
		this.profName = course.getProfName();
		this.courseName = course.getCourseName();
		this.prerequisiteList = course.getPrerequisiteList();
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
	public List<String> getPrerequisiteList(){
		return this.prerequisiteList;
	}
	public String toString() {
        String stringReturn = this.courseId + " " + this.courseName + " " + this.profName;
        for(String preId : this.prerequisiteList) {
        	stringReturn += " " + preId;
        }
        return stringReturn;
    }
	public Course build() {
		return Course.newBuilder()
				.setCourseId(this.courseId)
				.setProfName(this.profName)
				.setCourseName(this.courseName)
				.addAllPrerequisite(this.prerequisiteList)
				.build();
	}
}
