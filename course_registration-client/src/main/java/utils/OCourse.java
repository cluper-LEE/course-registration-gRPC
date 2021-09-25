package utils;

import com.cluper.course_registration.Course;

public class OCourse {
	private String courseId;
	private String courseName;
	private String profName;
	
	public OCourse(Course course) {
		this.courseId = course.getCourseId();
		this.courseName = course.getCourseName();
		this.profName = course.getProfName();
	}

	@Override
	public String toString() {
		String returnString = "";
		returnString +=
				"[ " + "���¹�ȣ: " + this.courseId
				+ "\t���¸�: " + this.courseName
				+ "\t��米��: " + this.profName
				+ " ]";
		return returnString;
	}
	
	
}
