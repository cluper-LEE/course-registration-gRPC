package services;

import com.cluper.course_registration.AddCourseRequest;
import com.cluper.course_registration.AddCourseResponse;
import com.cluper.course_registration.AddStudentRequest;
import com.cluper.course_registration.AddStudentResponse;
import com.cluper.course_registration.CancelReservationRequest;
import com.cluper.course_registration.CancelReservationResponse;
import com.cluper.course_registration.DeleteCourseRequest;
import com.cluper.course_registration.DeleteCourseResponse;
import com.cluper.course_registration.DeleteStudentRequest;
import com.cluper.course_registration.DeleteStudentResponse;
import com.cluper.course_registration.GetAllCoursesRequest;
import com.cluper.course_registration.GetAllCoursesResponse;
import com.cluper.course_registration.GetAllStudentsRequest;
import com.cluper.course_registration.GetAllStudentsResponse;
import com.cluper.course_registration.GetReservedCoursesRequest;
import com.cluper.course_registration.GetReservedCoursesResponse;
import com.cluper.course_registration.MakeReservationRequest;
import com.cluper.course_registration.MakeReservationResponse;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class SearchService extends SearchServiceImplBase{
	SearchServiceBlockingStub stub;
	
	public SearchService(SearchServiceBlockingStub stub) {
		this.stub = stub;
	}

	@Override
	public void getAllStudents(GetAllStudentsRequest request, StreamObserver<GetAllStudentsResponse> responseObserver) {
		responseObserver.onNext(this.stub.getAllStudents(null));
		responseObserver.onCompleted();
	}

	@Override
	public void addStudent(AddStudentRequest request, StreamObserver<AddStudentResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.addStudent(request));
			responseObserver.onCompleted();
		} catch (StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void deleteStudent(DeleteStudentRequest request, StreamObserver<DeleteStudentResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.deleteStudent(request));
			responseObserver.onCompleted();
		} catch(StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void getAllCourses(GetAllCoursesRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
		responseObserver.onNext(this.stub.getAllCourses(null));
		responseObserver.onCompleted();
	}

	@Override
	public void getReservedCourses(GetReservedCoursesRequest request,
			StreamObserver<GetReservedCoursesResponse> responseObserver) {
		try {			
			responseObserver.onNext(this.stub.getReservedCourses(request));
			responseObserver.onCompleted();
		} catch(StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void addCourse(AddCourseRequest request, StreamObserver<AddCourseResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.addCourse(request));
			responseObserver.onCompleted();
		} catch(StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void deleteCourse(DeleteCourseRequest request, StreamObserver<DeleteCourseResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.deleteCourse(request));
			responseObserver.onCompleted();
		} catch(StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void makeReservation(MakeReservationRequest request,
			StreamObserver<MakeReservationResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.makeReservation(request));
			responseObserver.onCompleted();
		} catch (StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}

	@Override
	public void cancelReservation(CancelReservationRequest request,
			StreamObserver<CancelReservationResponse> responseObserver) {
		try {
			responseObserver.onNext(this.stub.cancelReservation(request));
			responseObserver.onCompleted();
		} catch (StatusRuntimeException e) {
			responseObserver.onError(e);
		}
	}
}
