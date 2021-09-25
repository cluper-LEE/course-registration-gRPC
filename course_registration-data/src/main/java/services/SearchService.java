package services;

import java.io.IOException;
import java.util.ArrayList;

import com.cluper.course_registration.Course;
import com.cluper.course_registration.CourseResponse;
import com.cluper.course_registration.Empty;
import com.cluper.course_registration.Student;
import com.cluper.course_registration.StudentResponse;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceImplBase;

import io.grpc.stub.StreamObserver;
import models.MCourse;
import models.MCourseList;
import models.MStudent;
import models.MStudentList;

public class SearchService extends SearchServiceImplBase{

	@Override
	public void getAllStudents(Empty request, StreamObserver<StudentResponse> responseObserver) {
		
		System.out.println("Inside 'getAllStudents'");
		
		try {
			Course.Builder courseBuilder = Course.newBuilder();
			Student.Builder studentBuilder = Student.newBuilder();
			StudentResponse.Builder response = StudentResponse.newBuilder();
			
			MStudentList mStudentList = new MStudentList("/Students.txt");
			ArrayList<MStudent> mStudents = mStudentList.getAllStudentRecords();
			
			MCourseList mCourseList = new MCourseList("/Courses.txt");
			for(MStudent mStudent: mStudents) {
				studentBuilder.clearCourses();
				ArrayList<String> courseIds = mStudent.getCompletedCoursesList();
				for(String courseId: courseIds) {
					if(mCourseList.isRegisteredCourse(courseId)) {
						MCourse mCourse = mCourseList.get(courseId);
						Course course = courseBuilder.setCourseId(mCourse.getCourseId())
								.setCourseName(mCourse.getCourseName())
								.setProfName(mCourse.getProfName())
								.build();
						studentBuilder.addCourses(course);
					}
				}
				Student student = studentBuilder
						.setStudentId(mStudent.getStudentId())
						.setFirstName(mStudent.getFirstName())
						.setLastName(mStudent.getLastName())
						.build();
				response.addStudents(student);
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAllCourses(Empty request, StreamObserver<CourseResponse> responseObserver) {
		System.out.println("Inside 'getAllCourses'");
		
		try {
			Course.Builder courseBuilder = Course.newBuilder();
			MCourseList mCourseList = new MCourseList("/Courses.txt");
			ArrayList<MCourse> mCourses = mCourseList.getAllCourseRecords();
			
			CourseResponse.Builder courseResponseBuilder = CourseResponse.newBuilder();
			for(MCourse mCourse: mCourses) {
				Course course = courseBuilder
						.setCourseId(mCourse.getCourseId())
						.setCourseName(mCourse.getCourseName())
						.setProfName(mCourse.getProfName())
						.build();
				courseResponseBuilder.addCourse(course);
			}
			responseObserver.onNext(courseResponseBuilder.build());
			responseObserver.onCompleted();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
