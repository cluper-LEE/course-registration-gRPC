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
import com.cluper.course_registration.ReservationServiceGrpc.ReservationServiceBlockingStub;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.Student;

import io.grpc.StatusRuntimeException;
import utils.PrintFormat;

public class VMain {
	ReservationServiceBlockingStub stub;
	Scanner scanner;

	public VMain(ReservationServiceBlockingStub stub, Scanner scanner) {
		this.scanner = scanner;
		this.stub = stub;
	}

	public int show() {
		printMenu();
		String choice = scanner.nextLine().trim();
		try {
			Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			System.out.println(choice + " 는 숫자가 아닙니다. 실행할 서비스의 번호를 입력해주세요.");
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
			System.out.println(choice + " 은(는) 잘못된 번호입니다.");
		}
		return 1;
	}

	private void printCancelReservation() {
		try {
			System.out.println("학생의 수강신청 목록에서 강좌를 삭제합니다.");
			System.out.print("학번 >> "); String studentId = scanner.nextLine().trim();
			System.out.print("취소할 강좌의 강좌번호(여러 개일 경우 공백으로 구분) >> "); String courseIds = scanner.nextLine().trim();
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
			handleException(e);
		}
	}

	private void printReservationList() {
		try {
			System.out.println("학생의 수강신청 내역을 확인합니다.");
			System.out.print("학번 >> "); String studentId = scanner.nextLine().trim();
			GetReservedCoursesRequest request = GetReservedCoursesRequest.newBuilder().setStudentId(studentId).build();
			List<Course> courseList = this.stub.getReservedCourses(request).getCoursesList();
			System.out.println(studentId + "의 수강신청 내역");
			System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printMakeRegistration() {
		try {
			System.out.println("수강신청을 진행합니다.");
			System.out.print("학번 >> "); String studentId = scanner.nextLine().trim();
			System.out.print("신청할 강좌의 강좌번호(여러 개일 경우 공백으로 구분)>> "); String courseIds = scanner.nextLine().trim();
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
				System.out.println("입력을 확인해주세요.");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printDeleteCourse() {
		try {
			System.out.println("강좌를 삭제합니다.");
			System.out.print("삭제할 강좌의 강좌번호 >> "); String courseId = scanner.nextLine().trim();
			DeleteCourseRequest request = DeleteCourseRequest.newBuilder().setCourseId(courseId).build();
			ResponseMessage responseMessage = this.stub.deleteCourse(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("입력을 확인해주세요.");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printAddCourse() {
		try {
			System.out.println("새로운 강좌를 추가합니다.");
			System.out.print("강좌번호 >> "); String courseId = scanner.nextLine().trim();
			System.out.print("강좌명 >> "); String courseName = scanner.nextLine().trim();
			System.out.print("담당교수 >> "); String profName = scanner.nextLine().trim();
			System.out.print("선수 과목 리스트 >> "); String courseIds = scanner.nextLine().trim();
			Course.Builder builder = Course.newBuilder();
			StringTokenizer tokenizer = new StringTokenizer(courseIds);
			while(tokenizer.hasMoreTokens()) {
				builder.addPrerequisite(tokenizer.nextToken());
			}
			Course course = builder.setCourseId(courseId).setCourseName(courseName).setProfName(profName).build();
			AddCourseRequest request = AddCourseRequest.newBuilder().setCourse(course).build();
			ResponseMessage responseMessage = this.stub.addCourse(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. At least 5 elements joined by blank");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printDeleteStudent() {
		try {
			System.out.println("기존의 학생 정보를 삭제합니다.");
			System.out.print("학번 >> "); String studentId = scanner.nextLine().trim();
			DeleteStudentRequest request = DeleteStudentRequest.newBuilder().setStudentId(studentId).build();
			ResponseMessage responseMessage = this.stub.deleteStudent(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("Please check your input. Student ID must be number");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printAddStudent() {
		try {
			System.out.println("새로운 학생 정보를 추가합니다.");
			System.out.print("학번 >> "); String studentId = scanner.nextLine().trim();
			System.out.print("이름 (First Name) >> "); String studentFirstName = scanner.nextLine().trim();
			System.out.print("이름 (Last Name) >> "); String studentLastName = scanner.nextLine().trim();
			System.out.print("소속 >> "); String department = scanner.nextLine().trim();
			System.out.print("수강 과목 리스트 >> "); String courseIds = scanner.nextLine().trim();
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
			handleException(e);
		}
	}
	private void printGetAllCourses() {
		System.out.println("강좌 정보를 조회합니다.");
		List<Course> courseList = stub.getAllCourses(null).getCoursesList();
		System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
	}
	private void printGetAllStudents() {
		System.out.println("학생 정보를 조회합니다.");
		List<Student> studentList = stub.getAllStudents(null).getStudentsList();
		System.out.println(PrintFormat.toString(studentList.toArray(new Student[studentList.size()])));
	}
	private void printMenu() {
		System.out.println("\n\n***** 메인 메뉴 *****");
		System.out.println("1. 학생 정보 조회");
		System.out.println("2. 강좌 정보 조회");
		System.out.println("3. 학생 정보 추가");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 강좌 정보 추가");
		System.out.println("6. 강좌 정보 삭제");
		System.out.println("7. 학생 수강신청 조회");
		System.out.println("8. 학생 수강신청 강좌 추가");
		System.out.println("9. 학생 수상신청 강좌 삭제");

		System.out.println("0. 종료");
		System.out.print(">> ");
	}
	
	private void handleException(StatusRuntimeException e) {
		switch(e.getStatus().getCode()) {
		case INVALID_ARGUMENT:
			System.out.println("ID로 숫자가 아닌 문자가 입력되었습니다.");
			break;
		case NOT_FOUND:
			System.out.println("존재하지 않는 ID입니다.");
			break;
		case FAILED_PRECONDITION:
			System.out.println("선수과목 조건을 확인해주세요.");
			break;
		default:
			System.out.println("예상치 못한 에러입니다.");
			break;
		}
	}
}
