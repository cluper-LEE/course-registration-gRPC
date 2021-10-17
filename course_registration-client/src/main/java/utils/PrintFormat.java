package utils;

import java.util.List;
import java.util.StringJoiner;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Reservation;
import com.cluper.course_registration.Student;

public final class PrintFormat {
	public static String toString(Course course) {
		String retString = String.format(
				"[Course ID: %s\tCourse Name: %s\tProf: %s", 
				course.getCourseId(), 
				course.getProfName(),
				course.getCourseName() 
				);
		List<String> preIds = course.getPrerequisiteList();
		if(preIds.size() > 0) {
			retString += "\tPrerequisites: {";
			for(String preId : preIds) {
				retString += " " + preId;
			}
			retString += " }";
		}
		return retString + "]";
	}
	
	public static String toString(Course[] courses) {
		StringJoiner sj = new StringJoiner("\n");
		for(Course course : courses) {
			sj.add(toString(course));
		}
		return sj.toString();
	}
	
	public static String toString(Student student) {
		StringJoiner sj1 = new StringJoiner("\n");
		sj1.add("Student ID: " + student.getStudentId());
		sj1.add("Name: " + student.getLastName() + " " + student.getFirstName());
		sj1.add("Count. applied courses: " + student.getCourseIdCount());
		sj1.add("Applied courses:");
		StringJoiner sj2 = new StringJoiner(" ");
		sj2.add(sj1.toString());
		for(String courseID: student.getCourseIdList()) {
			sj2.add(courseID);
		}
		return sj2.toString();
	}
	
	public static String toString (Student[] students) {
		StringJoiner sj = new StringJoiner("\n\n");
		for(Student student: students) {
			sj.add(PrintFormat.toString(student));
		}
		return sj.toString();
	}

	public static String toString(Reservation reservation) {
		StringJoiner sj = new StringJoiner(" ");
		for(String courseId : reservation.getCourseIdList()) {
			sj.add(courseId);
		}
		return sj.toString();
	}
}
