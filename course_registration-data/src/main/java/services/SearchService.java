package services;

import java.util.ArrayList;
import java.util.List;

import com.cluper.course_registration.AddCourseRequest;
import com.cluper.course_registration.AddCourseResponse;
import com.cluper.course_registration.AddStudentRequest;
import com.cluper.course_registration.AddStudentResponse;
import com.cluper.course_registration.CancelReservationRequest;
import com.cluper.course_registration.CancelReservationResponse;
import com.cluper.course_registration.Course;
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
import com.cluper.course_registration.Reservation;
import com.cluper.course_registration.ResponseMessage;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;
import com.cluper.course_registration.Student;

import dao.DCourse;
import dao.DReservation;
import dao.DStudent;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

public class SearchService extends SearchServiceImplBase{
	private DStudent dStudent;
	private DCourse dCourse;
	private DReservation dRegistration;
	
	public SearchService() {
		this.dStudent = new DStudent();
		this.dCourse = new DCourse();
		this.dRegistration = new DReservation();
	}

	@Override
	public void getAllStudents(GetAllStudentsRequest request, StreamObserver<GetAllStudentsResponse> responseObserver) {
		ArrayList<Student> studentsList = this.dStudent.findAll();
		if(studentsList != null) {
			GetAllStudentsResponse response = GetAllStudentsResponse.newBuilder().addAllStudents(studentsList).build();
			responseObserver.onNext(response);
		}
		responseObserver.onCompleted();			
	}
	@Override
	public void getAllCourses(GetAllCoursesRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
		List<Course> courseList = this.dCourse.findAll();
		if(courseList != null) {
			GetAllCoursesResponse response = GetAllCoursesResponse.newBuilder().addAllCourses(courseList).build();
			responseObserver.onNext(response);
		}
		responseObserver.onCompleted();
	}
	@Override
	public void addStudent(AddStudentRequest request, StreamObserver<AddStudentResponse> responseObserver) {
		Student student = request.getStudent();
		if(this.studentAlreadyExists(responseObserver, student.getStudentId()) || 
				this.courseNotFound(responseObserver, student.getCourseIdList())) {
			return;
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		AddStudentResponse.Builder responseBuilder = AddStudentResponse.newBuilder();
		if(this.dStudent.add(student)) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void deleteStudent(DeleteStudentRequest request, StreamObserver<DeleteStudentResponse> responseObserver) {
		if(this.studentNotFound(responseObserver, request.getStudentId())) {
			return;
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		DeleteStudentResponse.Builder responseBuilder = DeleteStudentResponse.newBuilder();
		if(this.dStudent.delete(request.getStudentId())) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void addCourse(AddCourseRequest request, StreamObserver<AddCourseResponse> responseObserver) {
		Course course = request.getCourse();
		if(this.courseAlreadyExists(responseObserver, course.getCourseId()) || 
				this.courseNotFound(responseObserver, course.getPrerequisiteList())) {
			return;
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		AddCourseResponse.Builder responseBuilder = AddCourseResponse.newBuilder();
		if(this.dCourse.add(course)) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void deleteCourse(DeleteCourseRequest request, StreamObserver<DeleteCourseResponse> responseObserver) {
		if(this.courseNotFound(responseObserver, request.getCourseId())) {
			return;
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		DeleteCourseResponse.Builder responseBuilder = DeleteCourseResponse.newBuilder();
		if(this.dCourse.delete(request.getCourseId())) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void makeReservation(MakeReservationRequest request, StreamObserver<MakeReservationResponse> responseObserver) {
		Reservation reservation = request.getReservation();
		if(this.studentNotFound(responseObserver, reservation.getStudentId())) {
			return;
		}
		Student student = this.dStudent.findOne(reservation.getStudentId());
		List<String> completedList = student.getCourseIdList();
		for(String courseId : reservation.getCourseIdList()) {
			Course course = this.dCourse.findOne(courseId);
			if(this.courseNotFound(responseObserver, courseId) || 
					this.failedPrecondition(responseObserver, completedList.containsAll(course.getPrerequisiteList()))) {
				return;
			}
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		MakeReservationResponse.Builder responseBuilder = MakeReservationResponse.newBuilder();
		if(this.dRegistration.createOrAppend(reservation)) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void cancelReservation(CancelReservationRequest request, StreamObserver<CancelReservationResponse> responseObserver) {
		Reservation reservation = request.getReservation();
		if(this.studentNotFound(responseObserver, reservation.getStudentId())) {
			return;
		}
		ResponseMessage.Builder responseMessageBuilder = ResponseMessage.newBuilder();
		CancelReservationResponse.Builder responseBuilder = CancelReservationResponse.newBuilder();
		if(this.dRegistration.deleteCourse(reservation)) {
			responseMessageBuilder.setSuccess(true).setMessage("SUCCESS");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());
		} else {
			responseMessageBuilder.setSuccess(false).setMessage("FAIL");
			responseBuilder.setResponseMessage(responseMessageBuilder.build());		
		}
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
	}
	@Override
	public void getReservedCourses(GetReservedCoursesRequest request,
			StreamObserver<GetReservedCoursesResponse> responseObserver) {
		if(this.studentNotFound(responseObserver, request.getStudentId())) {
			return;
		}
		Reservation reservation = this.dRegistration.findOne(request.getStudentId());
		GetReservedCoursesResponse.Builder responseBuilder = GetReservedCoursesResponse.newBuilder();
		if(reservation != null) {
			List<Course> reservedList = this.dCourse.findAll(reservation.getCourseIdList());
			responseObserver.onNext(responseBuilder.addAllCourses(reservedList).build());			
		} else {
			responseObserver.onNext(responseBuilder.build());
		}
		responseObserver.onCompleted();
	}

	
	/////// to handle exceptions ///////
	private boolean reservationNotFound(StreamObserver<GetReservedCoursesResponse> responseObserver, String studentId) {
		if(!this.dRegistration.exists(studentId)) {
			Status status = Status.Code.NOT_FOUND.toStatus().withDescription("Resevation of  " + studentId +" not found");
			responseObserver.onError(status.asException());
			return true;
		}
		return false;
	}
	private boolean courseNotFound(StreamObserver<?> responseObserver, String courseId) {
		if(!this.dCourse.exists(courseId)) {
			Status status = Status.Code.NOT_FOUND.toStatus().withDescription("Course " + courseId +" not found");
			responseObserver.onError(status.asException());
			return true;
		}
		return false;
	}
	private boolean courseNotFound(StreamObserver<?> responseObserver, List<String> courseIdList) {
		for(String courseId : courseIdList) {
			if(this.courseNotFound(responseObserver, courseId)) {
				return true;
			}
		}
		return false;
	}
	private boolean studentNotFound(StreamObserver<?> responseObserver, String studentId) {
		if(!this.dStudent.exists(studentId)) {
			Status status = Status.Code.NOT_FOUND.toStatus().withDescription("Student " + studentId +" not found");
			responseObserver.onError(status.asException());
			return true;
		}
		return false;
	}
	private boolean studentAlreadyExists(StreamObserver<?> responseObserver, String studentId) {
		if(this.dStudent.exists(studentId)) {
			Status status = Status.Code.ALREADY_EXISTS.toStatus().withDescription("Student " + studentId + " already exists");
			responseObserver.onError(status.asException());
			return true;
		}
		return false;
	}
	private boolean courseAlreadyExists(StreamObserver<?> responseObserver, String courseId) {
		if(this.dCourse.exists(courseId)) {
			Status status = Status.Code.ALREADY_EXISTS.toStatus().withDescription("Course " + courseId + " already exists");
			responseObserver.onError(status.asException());
			return true;
		}
		return false;
	}
	private boolean failedPrecondition(StreamObserver<?> responseObserver, boolean condition) {
		if(!condition) {
			StatusException statusException = Status.Code.FAILED_PRECONDITION.toStatus().withDescription("Rejected due to prerequisite conditions").asException();
			responseObserver.onError(statusException);
			return true;
		}
		return false;
	}
}
