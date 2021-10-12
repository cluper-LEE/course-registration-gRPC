package utils;

import java.util.List;
import java.util.StringJoiner;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Courses;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.Students;

public final class PrintFormat {
	
	public static String toString(Course course) {
		return String.format(
				"[Course ID: %s\tCourse Name: %s\tProf: %s]", 
				course.getCourseId(), 
				course.getProfName(),
				course.getCourseName() 
				);
	}
	
	public static String toString(Courses courses) {
		StringJoiner sj = new StringJoiner("\n");
		for(Course course : courses.getCourseList()) {
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
	
	public static String toString (Students students) {
		StringJoiner sj = new StringJoiner("\n\n");
		for(Student student: students.getStudentsList()) {
			sj.add(PrintFormat.toString(student));
		}
		return sj.toString();
	}
}
