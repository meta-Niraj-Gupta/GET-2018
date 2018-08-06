package Counselling;

import java.util.ArrayList;
import java.util.List;

public class Students{
	private String studentName;
	private List<String> preferences = new ArrayList<String>();
	private String programAllotted;

	public Students(String studentName, List<String> preferences){
		this.studentName = studentName;
		this.preferences = preferences;
	}

	public String getName(){
		return studentName;
	}

	public List<String> getPreferences(){
		return preferences;
	}

	public void setProgramAllotted(String programAllotted){
		this.programAllotted = programAllotted;
	}

	public String getProgramAllotted(){
		return programAllotted;
	}
}
