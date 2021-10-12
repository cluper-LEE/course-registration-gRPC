package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MStudentList {
	protected ArrayList<MStudent> vStudent;
	private String fileName;

	public MStudentList(String sStudentFileName) throws FileNotFoundException, IOException {
		this.fileName = sStudentFileName;
		BufferedReader reader = new BufferedReader(new FileReader(new File(this.fileName)));
		this.vStudent = new ArrayList<MStudent>();
		while (reader.ready()) {
			String stuInfo = reader.readLine();
			if (!stuInfo.equals("")) {
				this.vStudent.add(new MStudent(stuInfo));
			}
		}
		reader.close();
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
	
	// target이 아닌 로컬 경로로 접근하기 - database는 어플리케이션과 분리되어 있다고 가정.
	public boolean add(MStudent mStudent) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.fileName), true));
			writer.append("\n\n\n\n" + mStudent.toString()).close();
			this.vStudent.add(mStudent);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
