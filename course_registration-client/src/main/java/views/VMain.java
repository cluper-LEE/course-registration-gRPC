package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Courses;
import com.cluper.course_registration.Registration;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.Students;

import utils.PrintFormat;

public class VMain {
	SearchServiceBlockingStub stub;
	Scanner scanner;

	public VMain(SearchServiceBlockingStub stub, Scanner scanner) {
		this.scanner = scanner;
		this.stub = stub;
	}

	public int show() {
		printMenu();
		String choice = scanner.nextLine().trim();
		try {
			Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			System.out.println(choice + " is not a number");
			return 1;
		}
		System.out.println();
		
		switch(choice) {
		case "0":
			return 0;
		case "1":
			printGetAllStudents();
			break;
		case "2":
			printGetAllCourses();
			break;
		case "3":
			printAddStudent();
			break;
		case "4":
			printDeleteStudent();
			break;
		case "5":
			printAddCourse();
			break;
		case "6":
			printDeleteCourse();
			break;
		case "7":
			printMakeRegistration();
			break;
		default:
			System.out.println(choice + " is worng number. Please check the options");
		}
		return 1;
	}

	private void printMakeRegistration() {
		System.out.println("----- Make Registration -----");
		System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
		System.out.print("Course ID List >> "); String courseIds = scanner.nextLine().trim();
		List<String> corseIdList = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(courseIds);
		while(tokenizer.hasMoreTokens()) {
			corseIdList.add(tokenizer.nextToken());
		}
		Registration registration = Registration.newBuilder()
				.setStudentId(studentId)
				.addAllCourseId(corseIdList)
				.build();
		ResponseMessage responseMessage = this.stub.makeRegistration(registration);
		System.out.println(responseMessage.getMessage());
		if(!responseMessage.getSuccess()) {
			System.out.println("Please check your input. Student name first and course ids following");
		}
	}
	private void printDeleteCourse() {
		System.out.println("----- Delete Course -----");
		System.out.print("Course ID >> "); String courseId = scanner.nextLine().trim();
		Course course = Course.newBuilder().setCourseId(courseId).build();
		ResponseMessage responseMessage = this.stub.deleteCourse(course);
		System.out.println(responseMessage.getMessage());
		if(!responseMessage.getSuccess()) {
			System.out.println("Please check your input. Course ID must be number");
		}
	}
	private void printAddCourse() {
		System.out.println("----- Add Course -----");
		System.out.print("Course ID >> "); String courseId = scanner.nextLine().trim();
		System.out.print("Course Name >> "); String courseName = scanner.nextLine().trim();
		System.out.print("Professor Name >> "); String profName = scanner.nextLine().trim();
		Course course = Course.newBuilder().setCourseId(courseId).setProfName(profName).setCourseName(courseName).build();
		ResponseMessage responseMessage = this.stub.addCourse(course);
		System.out.println(responseMessage.getMessage());
		if(!responseMessage.getSuccess()) {
			System.out.println("Please check your input. At least 5 elements joined by blank");
		}
	}
	private void printDeleteStudent() {
		System.out.println("----- Delete Student -----");
		System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
		Student student = Student.newBuilder().setStudentId(studentId).build();
		ResponseMessage responseMessage = this.stub.deleteStudent(student);
		System.out.println(responseMessage.getMessage());
		if(!responseMessage.getSuccess()) {
			System.out.println("Please check your input. Student ID must be number");
		}
	}
	private void printAddStudent() {
		System.out.println("----- Add Student -----");
		System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
		System.out.print("Student First Name >> "); String studentFirstName = scanner.nextLine().trim();
		System.out.print("Student Last Name >> "); String studentLastName = scanner.nextLine().trim();
		System.out.print("Student Department >> "); String department = scanner.nextLine().trim();
		System.out.print("Completed Course List>> "); String courseIds = scanner.nextLine().trim();
		Student.Builder builder = Student.newBuilder();
		StringTokenizer tokenizer = new StringTokenizer(courseIds);
		while(tokenizer.hasMoreTokens()) {
			builder.addCourseId(tokenizer.nextToken());
		}
		Student student = builder
				.setStudentId(studentId)
				.setFirstName(studentFirstName)
				.setLastName(studentLastName)
				.setDepartment(department)
				.build();
		ResponseMessage responseMessage = this.stub.addStudent(student);
		System.out.println(responseMessage.getMessage());
		if(!responseMessage.getSuccess()) {
			System.out.println("Please check your input. At least 5 elements joined by blank");
		}
	}
	private void printGetAllCourses() {
		Courses courses = stub.getAllCourses(null);
		System.out.println(PrintFormat.toString(courses));
	}
	private void printGetAllStudents() {
		Students students = stub.getAllStudents(null);
		System.out.println(PrintFormat.toString(students));
	}
	private void printMenu() {
		System.out.println("\n\n***** Menu *****");
		System.out.println("1. List Students");
		System.out.println("2. List Courses");
		System.out.println("3. Add Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Add Course");
		System.out.println("6. Delete Course");
		System.out.println("7. Make Reservation");
		System.out.println("0. Exit Program");
		System.out.print(">> ");
	}
}
