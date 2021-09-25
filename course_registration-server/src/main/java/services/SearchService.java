package services;

import com.cluper.course_registration.CourseResponse;
import com.cluper.course_registration.Empty;
import com.cluper.course_registration.SearchServiceGrpc;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;
import com.cluper.course_registration.StudentResponse;

import io.grpc.stub.StreamObserver;

public class SearchService extends SearchServiceImplBase{
	SearchServiceBlockingStub stub;
	
	public SearchService(SearchServiceBlockingStub stub) {
		this.stub = stub;
	}

	@Override
	public void getAllStudents(Empty request, StreamObserver<StudentResponse> responseObserver) {
		System.out.println("server - getAllStudents");
		Empty empty = Empty.newBuilder().build();
		StudentResponse response = stub.getAllStudents(empty);
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void getAllCourses(Empty request, StreamObserver<CourseResponse> responseObserver) {
		System.out.println("server - getAllCourses");
		Empty empty = Empty.newBuilder().build();
		CourseResponse response = stub.getAllCourses(empty);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
