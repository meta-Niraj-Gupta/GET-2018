package VirtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to represent the root directory and the directories which are created inside the root.
 */
public class Directory {
	private final String name;
	private final Date dateOfCreation;
	private List<Directory> listOfSubDirectory;


	/**
	 * Parameterized Constructor
	 * @param name : The name of the directory to be created.
	 * @param dateOfCreation : The date at which the directory is created.
	 */
	public Directory(String name, Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
		this.name = name;
		this.listOfSubDirectory = new ArrayList<Directory>();
	}


	public List<Directory> getListOfSubDirectory() {
		return listOfSubDirectory;
	}


	public void setListOfSubDirectory(List<Directory> listOfSubDirectory) {
		this.listOfSubDirectory = listOfSubDirectory;
	}


	public String getName() {
		return name;
	}


	public Date getDateOfCreation() {
		return dateOfCreation;
	}
}
