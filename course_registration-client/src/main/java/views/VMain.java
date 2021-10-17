package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.cluper.course_registration.AddCourseRequest;
import com.cluper.course_registration.AddStudentRequest;
import com.cluper.course_registration.CancelReservationRequest;
import com.cluper.course_registration.Course;
import com.cluper.course_registration.DeleteCourseRequest;
import com.cluper.course_registration.DeleteStudentRequest;
import com.cluper.course_registration.GetReservedCoursesRequest;
import com.cluper.course_registration.MakeReservationRequest;
import com.cluper.course_registration.Reservation;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.Student;

import io.grpc.StatusRuntimeException;
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
			printReservationList();
			break;
		case "8":
			printMakeRegistration();
			break;
		case "9":
			printCancelReservation();
			break;
		default:
			System.out.println(choice + " is worng number. Please check the options");
		}
		return 1;
	}

	private void printCancelReservation() {
		try {
			System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
			System.out.print("Course ID List >> "); String courseIds = scanner.nextLine().trim();
			List<String> corseIdList = new ArrayList<>();
			StringTokenizer tokenizer = new StringTokenizer(courseIds);
			while(tokenizer.hasMoreTokens()) {
				corseIdList.add(tokenizer.nextToken());
			}
			Reservation reservation = Reservation.newBuilder()
					.setStudentId(studentId)
					.addAllCourseId(corseIdList)
					.build();
			CancelReservationRequest request = CancelReservationRequest.newBuilder().setReservation(reservation).build();
			ResponseMessage responseMessage = this.stub.cancelReservation(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printReservationList() {
		try {
			System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
			GetReservedCoursesRequest request = GetReservedCoursesRequest.newBuilder().setStudentId(studentId).build();
			List<Course> courseList = this.stub.getReservedCourses(request).getCoursesList();
			System.out.println("Reserved Course List of " + studentId);
			System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printMakeRegistration() {
		try {
			System.out.println("----- Make Registration -----");
			System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
			System.out.print("Course ID List >> "); String courseIds = scanner.nextLine().trim();
			List<String> corseIdList = new ArrayList<>();
			StringTokenizer tokenizer = new StringTokenizer(courseIds);
			while(tokenizer.hasMoreTokens()) {
				corseIdList.add(tokenizer.nextToken());
			}
			Reservation reservation = Reservation.newBuilder()
					.setStudentId(studentId)
					.addAllCourseId(corseIdList)
					.build();
			MakeReservationRequest request = MakeReservationRequest.newBuilder().setReservation(reservation).build();
			ResponseMessage responseMessage = this.stub.makeReservation(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. Student name first and course ids following");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printDeleteCourse() {
		try {
			System.out.println("----- Delete Course -----");
			System.out.print("Course ID >> "); String courseId = scanner.nextLine().trim();
			DeleteCourseRequest request = DeleteCourseRequest.newBuilder().setCourseId(courseId).build();
			ResponseMessage responseMessage = this.stub.deleteCourse(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. Course ID must be number");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printAddCourse() {
		try {
			System.out.println("----- Add Course -----");
			System.out.print("Course ID >> "); String courseId = scanner.nextLine().trim();
			System.out.print("Course Name >> "); String courseName = scanner.nextLine().trim();
			System.out.print("Professor Name >> "); String profName = scanner.nextLine().trim();
			Course course = Course.newBuilder().setCourseId(courseId).setCourseName(courseName).setProfName(profName).build();
			AddCourseRequest request = AddCourseRequest.newBuilder().setCourse(course).build();
			ResponseMessage responseMessage = this.stub.addCourse(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. At least 5 elements joined by blank");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printDeleteStudent() {
		try {
			System.out.println("----- Delete Student -----");
			System.out.print("Student ID >> "); String studentId = scanner.nextLine().trim();
			DeleteStudentRequest request = DeleteStudentRequest.newBuilder().setStudentId(studentId).build();
			ResponseMessage responseMessage = this.stub.deleteStudent(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. Student ID must be number");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printAddStudent() {
		try {
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
			AddStudentRequest request = AddStudentRequest.newBuilder().setStudent(student).build();
			ResponseMessage responseMessage = this.stub.addStudent(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. At least 5 elements joined by blank");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	private void printGetAllCourses() {
		List<Course> courseList = stub.getAllCourses(null).getCoursesList();
		System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
	}
	private void printGetAllStudents() {
		List<Student> studentList = stub.getAllStudents(null).getStudentsList();
		System.out.println(PrintFormat.toString(studentList.toArray(new Student[studentList.size()])));
	}
	private void printMenu() {
		System.out.println("\n\n***** Main Menu *****");
		System.out.println("1. List Students");
		System.out.println("2. List Courses");
		System.out.println("3. Add Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Add Course");
		System.out.println("6. Delete Course");
		System.out.println("7. List Reservation");
		System.out.println("8. Make Reservation");
		System.out.println("9. Cancel Reservation");

		System.out.println("0. Exit Program");
		System.out.print(">> ");
	}
}
