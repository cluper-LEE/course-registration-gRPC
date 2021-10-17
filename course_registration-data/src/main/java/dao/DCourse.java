package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cluper.course_registration.Course;

import config.EConst;
import models.MCourse;

public class DCourse {
	public List<Course> findAll(List<String> courseIdList){
		List<Course> reservedList = new ArrayList<>();
		for(String courseId : courseIdList) {
			reservedList.add(this.findOne(courseId));
		}
		return reservedList;
	}
	public List<Course> findAll() {
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.COURSE_FILE_NAME.getValue())))) {
			List<Course> courses = new ArrayList<>();
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
	public Course findOne(String courseId) {
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.COURSE_FILE_NAME.getValue())))) {
			MCourse mCourse = new MCourse();
			while(mCourse.read(reader)) {
				if(mCourse.getCourseId().equals(courseId)) {
					return mCourse.build();
				}
			}
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
			return mCourse.write(writer, course);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addAll(List<Course> courseList, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.COURSE_FILE_NAME.getValue()), append))){
			MCourse mCourse = new MCourse();
			courseList.forEach((course) -> mCourse.write(writer, course));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String courseId) {
		List<Course> courseList = this.findAll();
		for(Course course : courseList) {
			if(course.getCourseId().equals(courseId)) {
				courseList.remove(course);
				this.addAll(courseList, false);
				return true;
			}
		}
		return false;
	}
	public boolean exists(String courseId) {
		return this.findOne(courseId)==null ? false : true;
	}
}
