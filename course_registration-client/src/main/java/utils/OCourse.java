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
				"[ " + "강좌번호: " + this.courseId
				+ "\t강좌명: " + this.courseName
				+ "\t담당교수: " + this.profName
				+ " ]";
		return returnString;
	}
	
	
}
