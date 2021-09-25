package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Student;

public final class PrintFormat {
	
	public static String toString(Course course) {
		return String.format(
				"[Course ID: %s\tCourse Name: %s\tProf: %s]", 
				course.getCourseId(), 
				course.getProfName(),
				course.getCourseName() 
				);
	}
	
	public static String toString(List<Course> courses) {
		StringJoiner sj = new StringJoiner("\n\n");
		for(Course course: courses) {
			sj.add(PrintFormat.toString(course));
		}
		return sj.toString();
	}
	
	public static String toString(Student student, boolean withCourses) {
		if(withCourses) {
			StringJoiner sj1 = new StringJoiner("\n");
			sj1.add("Student ID: " + student.getStudentId());
			sj1.add("Name: " + student.getLastName() + " " + student.getFirstName());
			sj1.add("Count. applied courses: " + student.getCoursesCount());
			sj1.add("Applied courses:");
			StringJoiner sj2 = new StringJoiner("\n\t");
			sj2.add(sj1.toString());
			for(Course course: student.getCoursesList()) {
				sj2.add(PrintFormat.toString(course));
			}
			return sj2.toString();
		} else {			
			return String.format(
					"[Student ID: %s\tName: %s]", 
					student.getStudentId(),
					student.getLastName() + " " + student.getFirstName()
			);
		}
	}
	
	public static String toString (List<Student> students, boolean withCourses) {
		StringJoiner sj = new StringJoiner("\n\n");
		for(Student student: students) {
			sj.add(PrintFormat.toString(student, withCourses));
		}
		return sj.toString();
	}
}
