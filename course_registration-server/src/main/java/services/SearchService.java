package services;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.Courses;
import com.cluper.course_registration.Empty;
import com.cluper.course_registration.Registration;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.Students;

import io.grpc.stub.StreamObserver;

public class SearchService extends SearchServiceImplBase{
	SearchServiceBlockingStub stub;
	
	public SearchService(SearchServiceBlockingStub stub) {
		this.stub = stub;
	}

	@Override
	public void getAllStudents(Empty request, StreamObserver<Students> responseObserver) {
		responseObserver.onNext(this.stub.getAllStudents(null));
		responseObserver.onCompleted();
	}
	@Override
	public void getAllCourses(Empty request, StreamObserver<Courses> responseObserver) {
		responseObserver.onNext(this.stub.getAllCourses(null));
		responseObserver.onCompleted();
	}
	@Override
	public void addStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
		responseObserver.onNext(this.stub.addStudent(request));
		responseObserver.onCompleted();
	}
	@Override
	public void deleteStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
		responseObserver.onNext(this.stub.deleteStudent(request));
		responseObserver.onCompleted();
	}
	@Override
	public void addCourse(Course request, StreamObserver<ResponseMessage> responseObserver) {
		responseObserver.onNext(this.stub.addCourse(request));
		responseObserver.onCompleted();
	}
	@Override
	public void deleteCourse(Course request, StreamObserver<ResponseMessage> responseObserver) {
		responseObserver.onNext(this.stub.deleteCourse(request));
		responseObserver.onCompleted();
	}
	@Override
	public void makeRegistration(Registration request, StreamObserver<ResponseMessage> responseObserver) {
		responseObserver.onNext(this.stub.makeRegistration(request));
		responseObserver.onCompleted();
	}
	
	

//	@Override
//	public void getAllStudents(Empty request, StreamObserver<StudentResponse> responseObserver) {
//		System.out.println("server - getAllStudents");
//		Empty empty = Empty.newBuilder().build();
//		StudentResponse response = stub.getAllStudents(empty);
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//	}
//
//	@Override
//	public void getAllCourses(Empty request, StreamObserver<CourseResponse> responseObserver) {
//		System.out.println("server - getAllCourses");
//		Empty empty = Empty.newBuilder().build();
//		CourseResponse response = stub.getAllCourses(empty);
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//	}
//
//	@Override
//	public void addStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
//		System.out.println("server - addStudent");
//		ResponseMessage response = stub.addStudent(request);
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//	}
//
//	@Override
//	public void deleteStudent(Student request, StreamObserver<ResponseMessage> responseObserver) {
//		super.deleteStudent(request, responseObserver);
//	}
//	
	
}
