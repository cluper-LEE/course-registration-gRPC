package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.cluper.course_registration.Registration;

import config.EConst;
import models.MRegistration;

public class DRegistration {
	public ArrayList<Registration> getAllRegistrations(){
		try(BufferedReader reader = new BufferedReader(new FileReader(new File(EConst.REGISTRATION_FILE_NAME.getValue())))) {
			ArrayList<Registration> registrations = new ArrayList<>();
			MRegistration mRegistration = new MRegistration();
			while(mRegistration.read(reader)) {
				registrations.add(mRegistration.build());
			}
			return registrations;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	} 
	public boolean add(Registration registration) {
		return this.add(registration, true);
	}
	private boolean add(Registration registration, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.REGISTRATION_FILE_NAME.getValue()), append))){
			MRegistration mRegistration = new MRegistration();
			return mRegistration.add(writer, registration);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addAll(ArrayList<Registration> registrationList, boolean append) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(EConst.REGISTRATION_FILE_NAME.getValue()), append))){
			MRegistration mRegistration = new MRegistration();
			registrationList.forEach((student) -> mRegistration.add(writer, student));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String registrationId) {
		ArrayList<Registration> registrationList = this.getAllRegistrations();
		for(Registration registration : registrationList) {
			if(registration.getStudentId().equals(registrationId)) {
				registrationList.remove(registration);
				this.addAll(registrationList, false);
				return true;
			}
		}
		return false;
	}
	public boolean update(Registration registration) {
		Registration exRegistration = this.findOne(registration.getStudentId());
		if(exRegistration==null) {			
			return false;
		}
		boolean result;
		result = this.delete(registration.getStudentId());
		if (!result) {
			return false;
		}
		result = this.add(registration);
		if (!result) {
			return false;
		}
		return true;
	}
	public Registration findOne(String registrationId) {
		ArrayList<Registration> registrationList = this.getAllRegistrations();
		for(Registration registration : registrationList) {
			if(registration.getStudentId().equals(registrationId)) {
				return registration;
			}
		}
		return null;
	}
	public boolean addOrUpdate(Registration registration) {
		Registration exRegistration = this.findOne(registration.getStudentId());
		if(exRegistration != null) {
			this.update(registration);
		} else {
			this.add(registration);
		}
		return true;
	}
}
