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
			System.out.println(choice + " �� ���ڰ� �ƴմϴ�. ������ ������ ��ȣ�� �Է����ּ���.");
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
			System.out.println(choice + " ��(��) �߸��� ��ȣ�Դϴ�.");
		}
		return 1;
	}

	private void printCancelReservation() {
		try {
			System.out.println("�л��� ������û ��Ͽ��� ���¸� �����մϴ�.");
			System.out.print("�й� >> "); String studentId = scanner.nextLine().trim();
			System.out.print("����� ������ ���¹�ȣ(���� ���� ��� �������� ����) >> "); String courseIds = scanner.nextLine().trim();
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
			System.out.println("�л��� ������û ������ Ȯ���մϴ�.");
			System.out.print("�й� >> "); String studentId = scanner.nextLine().trim();
			GetReservedCoursesRequest request = GetReservedCoursesRequest.newBuilder().setStudentId(studentId).build();
			List<Course> courseList = this.stub.getReservedCourses(request).getCoursesList();
			System.out.println(studentId + "�� ������û ����");
			System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printMakeRegistration() {
		try {
			System.out.println("������û�� �����մϴ�.");
			System.out.print("�й� >> "); String studentId = scanner.nextLine().trim();
			System.out.print("��û�� ������ ���¹�ȣ(���� ���� ��� �������� ����)>> "); String courseIds = scanner.nextLine().trim();
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
				System.out.println("�Է��� Ȯ�����ּ���.");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printDeleteCourse() {
		try {
			System.out.println("���¸� �����մϴ�.");
			System.out.print("������ ������ ���¹�ȣ >> "); String courseId = scanner.nextLine().trim();
			DeleteCourseRequest request = DeleteCourseRequest.newBuilder().setCourseId(courseId).build();
			ResponseMessage responseMessage = this.stub.deleteCourse(request).getResponseMessage();
			System.out.println(responseMessage.getMessage());
			if(!responseMessage.getSuccess()) {
				System.out.println("�Է��� Ȯ�����ּ���.");
			}
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
			handleException(e);
		}
	}
	private void printAddCourse() {
		try {
			System.out.println("���ο� ���¸� �߰��մϴ�.");
			System.out.print("���¹�ȣ >> "); String courseId = scanner.nextLine().trim();
			System.out.print("���¸� >> "); String courseName = scanner.nextLine().trim();
			System.out.print("��米�� >> "); String profName = scanner.nextLine().trim();
			System.out.print("���� ���� ����Ʈ >> "); String courseIds = scanner.nextLine().trim();
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
			System.out.println("������ �л� ������ �����մϴ�.");
			System.out.print("�й� >> "); String studentId = scanner.nextLine().trim();
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
			System.out.println("���ο� �л� ������ �߰��մϴ�.");
			System.out.print("�й� >> "); String studentId = scanner.nextLine().trim();
			System.out.print("�̸� (First Name) >> "); String studentFirstName = scanner.nextLine().trim();
			System.out.print("�̸� (Last Name) >> "); String studentLastName = scanner.nextLine().trim();
			System.out.print("�Ҽ� >> "); String department = scanner.nextLine().trim();
			System.out.print("���� ���� ����Ʈ >> "); String courseIds = scanner.nextLine().trim();
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
		System.out.println("���� ������ ��ȸ�մϴ�.");
		List<Course> courseList = stub.getAllCourses(null).getCoursesList();
		System.out.println(PrintFormat.toString(courseList.toArray(new Course[courseList.size()])));
	}
	private void printGetAllStudents() {
		System.out.println("�л� ������ ��ȸ�մϴ�.");
		List<Student> studentList = stub.getAllStudents(null).getStudentsList();
		System.out.println(PrintFormat.toString(studentList.toArray(new Student[studentList.size()])));
	}
	private void printMenu() {
		System.out.println("\n\n***** ���� �޴� *****");
		System.out.println("1. �л� ���� ��ȸ");
		System.out.println("2. ���� ���� ��ȸ");
		System.out.println("3. �л� ���� �߰�");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. ���� ���� �߰�");
		System.out.println("6. ���� ���� ����");
		System.out.println("7. �л� ������û ��ȸ");
		System.out.println("8. �л� ������û ���� �߰�");
		System.out.println("9. �л� �����û ���� ����");

		System.out.println("0. ����");
		System.out.print(">> ");
	}
	
	private void handleException(StatusRuntimeException e) {
		switch(e.getStatus().getCode()) {
		case INVALID_ARGUMENT:
			System.out.println("ID�� ���ڰ� �ƴ� ���ڰ� �ԷµǾ����ϴ�.");
			break;
		case NOT_FOUND:
			System.out.println("�������� �ʴ� ID�Դϴ�.");
			break;
		case FAILED_PRECONDITION:
			System.out.println("�������� ������ Ȯ�����ּ���.");
			break;
		default:
			System.out.println("����ġ ���� �����Դϴ�.");
			break;
		}
	}
}
