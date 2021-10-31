package utils;

import java.util.StringJoiner;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Reservation;
import com.cluper.course_registration.Student;

public final class PrintFormat {
	public static String toString(Course course) {
		StringJoiner sj1 = new StringJoiner("\n");
		sj1.add("���¹�ȣ: " + course.getCourseId());
		sj1.add("���¸�: " + course.getCourseName());
		sj1.add("��米��: " + course.getProfName());
		StringJoiner sj2 = new StringJoiner(" ");
		if(course.getPrerequisiteCount() > 0) {
			sj2.add("��������:");
			for(String courseID: course.getPrerequisiteList()) {
				sj2.add(courseID);
			}
		}
		return sj1.merge(sj2).toString();
	}
	
	public static String toString(Course[] courses) {
		StringJoiner sj = new StringJoiner("\n\n");
		for(Course course : courses) {
			sj.add(toString(course));
		}
		return sj.toString();
	}
	
	public static String toString(Student student) {
		StringJoiner sj1 = new StringJoiner("\n");
		sj1.add("�й�: " + student.getStudentId());
		sj1.add("�̸�: " + student.getLastName() + " " + student.getFirstName());
		StringJoiner sj2 = new StringJoiner(" ");
		if(student.getCourseIdCount() > 0) {
			sj2.add("����� ���� ����:");
			for(String courseID: student.getCourseIdList()) {
				sj2.add(courseID);
			}
		}
		return sj1.merge(sj2).toString();
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
