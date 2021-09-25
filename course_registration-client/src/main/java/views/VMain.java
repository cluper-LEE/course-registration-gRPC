package views;

import java.util.List;
import java.util.Scanner;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.CourseResponse;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.StudentResponse;

import utils.PrintFormat;

public class VMain {
	SearchServiceBlockingStub stub;
	Scanner scanner;

	public VMain(SearchServiceBlockingStub stub, Scanner scanner) {
		this.scanner = scanner;
		this.stub = stub;
	}

	public int show() {
		System.out.println("\n\n***** Menu *****");
		System.out.println("1. List Students (with courses)");
		System.out.println("2. List Students");
		System.out.println("3. List Courses");
		System.out.println("0. Exit Program");

		System.out.print(">> ");
		String choice = scanner.nextLine().trim();
		try {
			Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			System.out.println(choice + " is not a number");
			return 1;
		}
		System.out.println();
		
		if(choice.equals("0")) {
			return 0;
		} else if(choice.equals("1")) {
			StudentResponse studentResponse = stub.getAllStudents(null);
			System.out.println(PrintFormat.toString(studentResponse.getStudentsList(), true));
		} else if(choice.equals("2")) {
			StudentResponse studentResponse = stub.getAllStudents(null);
			System.out.println(PrintFormat.toString(studentResponse.getStudentsList(), false));
		} else if(choice.equals("3")) {			
			CourseResponse courseResponse = stub.getAllCourses(null);
			System.out.println(PrintFormat.toString(courseResponse.getCourseList()));
		}
		else {
			System.out.println(choice + " is worng number. Please check the options");
		}
		
		return 1;
	}
}
