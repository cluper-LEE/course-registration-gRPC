package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cluper.course_registration.Reservation;

import config.EConst;
import models.MReservation;

public class DReservation {
	public List<Reservation> findAll(){
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.RESERVATION_FILE_NAME.getValue())))) {
			List<Reservation> reservations = new ArrayList<>();
			MReservation mReservation = new MReservation();
			while(mReservation.read(reader)) {
				reservations.add(mReservation.build());
			}
			return reservations;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	} 
	public boolean add(Reservation reservation) {
		return this.add(reservation, true);
	}
	private boolean add(Reservation reservation, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.RESERVATION_FILE_NAME.getValue()), append))){
			MReservation mReservation = new MReservation();
			return mReservation.add(writer, reservation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addAll(List<Reservation> reservationList, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.RESERVATION_FILE_NAME.getValue()), append))){
			MReservation mReservation = new MReservation();
			reservationList.forEach((student) -> mReservation.add(writer, student));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String studentId) { // 신청 기록 삭제
		List<Reservation> reservationList = this.findAll();
		for(Reservation reservation : reservationList) {
			if(reservation.getStudentId().equals(studentId)) {
				reservationList.remove(reservation);
				this.addAll(reservationList, false);
				return true;
			}
		}
		return false;
	}
	public boolean update(Reservation reservation) { // 신청 기록 통으로 업데이트
		Reservation exReservation = this.findOne(reservation.getStudentId());
		this.delete(exReservation.getStudentId());
		this.add(reservation);
		return true;
	}
	public boolean deleteCourse(Reservation reservation) {
		Reservation exReservation = this.findOne(reservation.getStudentId());
		List<String> newList = new ArrayList<>();
		for(String courseId : exReservation.getCourseIdList()) {
			if(!reservation.getCourseIdList().contains(courseId)) {
				newList.add(courseId);
			}
		}
		this.delete(reservation.getStudentId());
		this.add(exReservation.toBuilder().clearCourseId().addAllCourseId(newList).build());
		return true;
	}
	public Reservation findOne(String studentId) {
		List<Reservation> reservationList = this.findAll();
		for(Reservation reservation : reservationList) {
			if(reservation.getStudentId().equals(studentId)) {
				return reservation;
			}
		}
		return null;
	}
	public boolean createOrAppend(Reservation reservation) {
		Reservation exReservation = this.findOne(reservation.getStudentId());
		if(exReservation != null) {
			this.append(reservation);
		} else {
			this.add(reservation);
		}
		return true;
	}
	public boolean append(Reservation reservation) {
		Reservation exReservation = this.findOne(reservation.getStudentId());
		Reservation.Builder builder = exReservation.toBuilder();
		for(String newCourseId : reservation.getCourseIdList()) {
			if(!exReservation.getCourseIdList().contains(newCourseId)) {
				builder.addCourseId(newCourseId);
			}
		}
		this.delete(exReservation.getStudentId());
		this.add(builder.build());
		return true;
	}
	public boolean exists(String studentId) {
		return (this.findOne(studentId)==null) ? false : true;
	}
}
