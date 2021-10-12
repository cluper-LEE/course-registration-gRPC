package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cluper.course_registration.Course;

import config.EConst;
import models.MCourse;

public class DCourse {
	public ArrayList<Course> getAllCourses(){
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.COURSE_FILE_NAME.getValue())))) {
			ArrayList<Course> courses = new ArrayList<>();
			MCourse mCourse = new MCourse();
			while(mCourse.read(reader)) {
				courses.add(mCourse.build());
			}
			return courses;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean add(Course course) {
		return this.add(course, true);
	}
	public boolean add(Course course, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.COURSE_FILE_NAME.getValue()), append))){
			MCourse mCourse = new MCourse();
			return mCourse.add(writer, course);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addAll(ArrayList<Course> courseList, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.COURSE_FILE_NAME.getValue()), append))){
			MCourse mCourse = new MCourse();
			courseList.forEach((course) -> mCourse.add(writer, course));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String courseId) {
		ArrayList<Course> courseList = this.getAllCourses();
		for(Course course : courseList) {
			if(course.getCourseId().equals(courseId)) {
				courseList.remove(course);
				this.addAll(courseList, false);
				return true;
			}
		}
		return false;
	}
}
