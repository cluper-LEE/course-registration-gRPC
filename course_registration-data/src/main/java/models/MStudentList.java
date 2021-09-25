package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MStudentList {
	protected ArrayList<MStudent> vStudent;

	public MStudentList(String sStudentFileName) throws FileNotFoundException, IOException {
		BufferedReader objStudentFile = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(sStudentFileName)));
		this.vStudent = new ArrayList<MStudent>();
		while (objStudentFile.ready()) {
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) {
				this.vStudent.add(new MStudent(stuInfo));
			}
		}
		objStudentFile.close();
	}

	public ArrayList<MStudent> getAllStudentRecords() {
		return this.vStudent;
	}

	public boolean isRegisteredStudent(String sSID) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			MStudent objStudent = (MStudent) this.vStudent.get(i);
			if (objStudent.match(sSID)) {
				return true;
			}
		}
		return false;
	}
}
