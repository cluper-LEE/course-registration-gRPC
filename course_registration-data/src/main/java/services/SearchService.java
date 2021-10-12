package services;

import java.util.ArrayList;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Courses;
import com.cluper.course_registration.Empty;
import com.cluper.course_registration.Registration;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.Students;

import dao.DCourse;
import dao.DRegistration;
import dao.DStudent;
import io.grpc.stub.StreamObserver;

public class SearchService extends SearchServiceImplBase{
	private DStudent dStudent;
	private DCourse dCourse;
	private DRegistration dRegistration;
	
	public SearchService() {
		this.dStudent = new DStudent();
		this.dCourse = new DCourse();
		this.dRegistration = new DRegistration();
	}

	@Override
	public void getAllStudents(Empty request, StreamObserver<Students> responseObserver) {
		ArrayList<Student> studentsList = this.dStudent.getAllStudents();
		if(studentsList != null) {
			Students students = Students.newBuilder().addAllStudents(studentsList).build();
			responseObserver.onNext(students);
		}
		responseObserver.onCompleted();			
	}
	@Override
	public void getAllCourses(Empty request, StreamObserver<Courses> responseObserver) {
		ArrayList<Course> courseList = this.dCourse.getAllCourses();
		if(courseList != null) {
			Courses courses = Courses.newBuilder().addAllCourse(courseList).build();
			responseObserver.onNext(courses);
		}
		responseObserver.onCompleted();
	}
	@Override
	public void addStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		if(this.dStudent.add(request)) {
			responseObserver.onNext(responseMessageBuilder.setSuccess(true).setMessage("SUCCESS").build());			
		} else {
			responseObserver.onNext(responseMessageBuilder.setSuccess(false).setMessage("FAIL").build());			
		}
		responseObserver.onCompleted();
	}
	@Override
	public void deleteStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		if(this.dStudent.delete(request.getStudentId())) {
			responseObserver.onNext(responseMessageBuilder.setSuccess(true).setMessage("SUCCESS").build());			
		} else {
			responseObserver.onNext(responseMessageBuilder.setSuccess(false).setMessage("FAIL").build());			
		}
		responseObserver.onCompleted();
	}
	@Override
	public void addCourse(Course request, StreamObserver<ResponseMessage> responseObserver) {
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		if(this.dCourse.add(request)) {
			responseObserver.onNext(responseMessageBuilder.setSuccess(true).setMessage("SUCCESS").build());			
		} else {
			responseObserver.onNext(responseMessageBuilder.setSuccess(false).setMessage("FAIL").build());			
		}
		responseObserver.onCompleted();
	}
	@Override
	public void deleteCourse(Course request, StreamObserver<ResponseMessage> responseObserver) {
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		if(this.dCourse.delete(request.getCourseId())) {
			responseObserver.onNext(responseMessageBuilder.setSuccess(true).setMessage("SUCCESS").build());			
		} else {
			responseObserver.onNext(responseMessageBuilder.setSuccess(false).setMessage("FAIL").build());			
		}
		responseObserver.onCompleted();
	}
	@Override
	public void makeRegistration(Registration request, StreamObserver<ResponseMessage> responseObserver) {
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		if(this.dRegistration.addOrUpdate(request)) {
			responseObserver.onNext(responseMessageBuilder.setSuccess(true).setMessage("SUCCESS").build());			
		} else {
			responseObserver.onNext(responseMessageBuilder.setSuccess(false).setMessage("FAIL").build());			
		}
		responseObserver.onCompleted();
	}
}
