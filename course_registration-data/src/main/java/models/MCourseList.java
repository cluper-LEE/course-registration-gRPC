package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MCourseList {
	protected ArrayList<MCourse> vCourse;

	public MCourseList(String sCourseFileName) throws FileNotFoundException, IOException {
		BufferedReader objCourseFile = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(sCourseFileName)));
		this.vCourse = new ArrayList<MCourse>();
		while (objCourseFile.ready()) {
			String stuInfo = objCourseFile.readLine();
			if (!stuInfo.equals("")) {
				this.vCourse.add(new MCourse(stuInfo));
			}
		}
		objCourseFile.close();
	}

	public ArrayList<MCourse> getAllCourseRecords() {
		return this.vCourse;
	}

	public boolean isRegisteredCourse(String sCID) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			MCourse objCourse = (MCourse) this.vCourse.get(i);
			if (objCourse.match(sCID)) {
				return true;
			}
		}
		return false;
	}
	
	public MCourse get(String courseId) {
		MCourse target = null;
		for(MCourse mCourse : this.vCourse) {
			if(mCourse.getCourseId().equals(courseId)) {
				target = mCourse;
				break;
			}
		}
		return target;
	}
}
