package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import com.cluper.course_registration.Registration;


public class MRegistration implements Serializable{
	private static final long serialVersionUID = 1L;
	private String studentId;
	private List<String> courseIdList;
	
	public MRegistration() {
		this.courseIdList = new ArrayList<>();
	}
	public String getStudentID() {
		return studentId;
	}
	public List<String> getCourseIDList() {
		return courseIdList;
	}

	public boolean read(BufferedReader reader) {
    	try {
			String stuInfo = "";
			while (reader.ready()) {
				stuInfo = reader.readLine();
				if (!stuInfo.equals("")) {
					StringTokenizer stringTokenizer = new StringTokenizer(stuInfo);
					this.studentId = stringTokenizer.nextToken();
			    	while (stringTokenizer.hasMoreTokens()) {
			    		this.courseIdList.add(stringTokenizer.nextToken());
			    	}
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return false;
    }
	public boolean add(BufferedWriter writer, Registration registration) {
		try {
			this.set(registration);
			StringJoiner sj = new StringJoiner(" ");
			sj.add(this.studentId);
			for (String courseId : this.courseIdList) {
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
	private void set(Registration registration) {
		this.studentId = registration.getStudentId();
		for(String courseId : registration.getCourseIdList()) {
			this.courseIdList.add(courseId);
		}
	}
	public String toString() {
		String stringReturn = this.studentId;
		for(String courseID : this.courseIdList) {
			stringReturn += " " + courseID;
		}
		return stringReturn;
	}
	public Registration build() {
		return Registration.newBuilder()
				.setStudentId(studentId)
				.addAllCourseId(courseIdList)
				.build();
	}
}
