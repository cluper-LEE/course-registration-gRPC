package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cluper.course_registration.Student;

import config.EConst;
import models.MStudent;

public class DStudent {
	public ArrayList<Student> findAll(){
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.STUDENT_FILE_NAME.getValue())))) {
			ArrayList<Student> students = new ArrayList<>();
			MStudent mStudent = new MStudent();
			while(mStudent.read(reader)) {
				students.add(mStudent.build());
			}
			return students;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Student findOne(String studentId){
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.STUDENT_FILE_NAME.getValue())))) {
			MStudent mStudent = new MStudent();
			while(mStudent.read(reader)) {
				if(mStudent.getStudentId().equals(studentId)) {
					return mStudent.build();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean add(Student student) {
		return this.add(student, true);
	}
	public boolean add(Student student, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.STUDENT_FILE_NAME.getValue()), append))){
			MStudent mStudent = new MStudent();
			return mStudent.add(writer, student);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addAll(ArrayList<Student> studentList, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.STUDENT_FILE_NAME.getValue()), append))){
			MStudent mStudent = new MStudent();
			studentList.forEach((student) -> mStudent.add(writer, student));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String studentId) {
		ArrayList<Student> studentList = this.findAll();
		for(Student student : studentList) {
			if(student.getStudentId().equals(studentId)) {
				studentList.remove(student);
				this.addAll(studentList, false);
				return true;
			}
		}
		return false;
	}
	public boolean exists(String studentId) {
		return (this.findOne(studentId)==null) ? false : true;
	}
}
