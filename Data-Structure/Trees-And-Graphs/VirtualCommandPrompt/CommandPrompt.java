package VirtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Niraj gupta
 * Class to implement the virtual command prompt which takes commands and perform the operation 
 * as per the issued command.
 */
public class CommandPrompt {
	static List<Directory> directories = new ArrayList<Directory>();
	static String path = ".\\";

	/**
	 * Method to implement the virtual command prompt
	 */
	public static void virtualCommandPrompt(){
		Directory root = new Directory("R:", new Date());
		directories.add(root);
		Scanner scanner = new Scanner(System.in);
		System.out.println("***Welcome to Virtual Command Prompt***");
		String signature = "R:\\";
		System.out.print(signature + ">");
		Directory currentWorkingDirectory = root;

		while(true){
			String commandLine = scanner.nextLine();
			String[] commands = commandLine.split(" ");

			switch(commands[0]){

			//mkdir : To create new directory.
			case "mkdir": 	
				if(commands.length >= 2){
					boolean flag = false;
					for(Directory directory : currentWorkingDirectory.getListOfSubDirectory()){
						if(directory.getName().equals(commands[1])){
							flag = true;
							break;
						}
					}
					if(!flag){
						Directory newDirectory = new Directory(commands[1], new Date());
						directories.add(newDirectory);
						currentWorkingDirectory.getListOfSubDirectory().add(newDirectory);
					}else{
						System.out.println(signature + ">A subdirectory or file " + commands[1] + " already exists.");
					}
				}else{
					System.out.println(signature + ">The syntax of the command is incorrect.");
				}
				System.out.print(signature + ">");
				break;

				//cd : To move to the specified directory
			case "cd":  
				if(commands.length >= 2){
					if(findPath(currentWorkingDirectory, commands[1]) != null){
						for(Directory directory: directories){
							if(directory.getName().equals(commands[1])){
								currentWorkingDirectory = directory;
								if(signature.charAt(signature.length() - 1) != '\\'){
									signature += "\\";
								}
								signature += currentWorkingDirectory.getName();
								break;
							}
						}
					}else{
						System.out.println(signature + "> No such directory exists");
					}
				}else{
					System.out.println(signature + ">The syntax of the command is incorrect.");
				}
				System.out.print(signature + ">");
				break;

				//bk : To move one level up in the directory hierarchy
			case "bk": 
				if(currentWorkingDirectory.getName() != "R:"){
					String[] repositry = signature.split("\\\\");
					for(Directory directory: directories){
						if(directory.getName().equals(repositry[repositry.length - 2])){
							currentWorkingDirectory = directory;
						}
					}
					signature = "R:";
					for(int i = 1; i < repositry.length - 1; i++){
						signature += "\\" + repositry[i];
					}
				}
				System.out.print(signature + ">");
				break;

				//ls : To perform the long listing of the current working directory.
			case "ls": 
				for(Directory subDirectory: currentWorkingDirectory.getListOfSubDirectory()){
					System.out.println(subDirectory.getDateOfCreation() + " " + subDirectory.getName());
				}
				System.out.println(currentWorkingDirectory.getListOfSubDirectory().size() + " Folder(s)");
				System.out.print(signature + ">");
				break;

				//find : To get the path of the specified directory.
			case "find": 
				if(commands.length >= 2){
					path = ".\\";
					String directoryPath = findPath(currentWorkingDirectory, commands[1]);
					if(directoryPath != null){
						StringBuilder pathToFind = new StringBuilder(directoryPath);
						pathToFind.deleteCharAt(pathToFind.length() - 1);
						System.out.println(pathToFind);
					}else{
						System.out.println(signature + ">Directory not found");
					}
				}else{
					System.out.println(signature + ">The syntax of the command is incorrect.");
				}
				System.out.print(signature + ">");
				break;

				//tree : To show the directory hierarchy in tree format.
			case "tree":
				System.out.println(".");
				printTree(currentWorkingDirectory, 0);
				System.out.print(signature + ">");
				break;

				//exit : To quit the command prompt.
			case "exit": 
				System.exit(0); 

			default: 
				System.out.println(signature + ">Command does not exist");
				System.out.print(signature + ">");
			}
		}
	}


	/**
	 * Method to find the path of the current working directory
	 * @param currentWorkingDirectory
	 * @param directoryToBeSearched
	 * @return path
	 */
	private static String findPath(Directory currentWorkingDirectory, String directoryToBeSearched){
		boolean found = false;
		if(currentWorkingDirectory.getName().equals(directoryToBeSearched)){
			found = true;
		}else{
			for(Directory directory : currentWorkingDirectory.getListOfSubDirectory()){
				path += directory.getName() + "\\";
				if(findPath(directory, directoryToBeSearched) != null){
					found = true;
					break;
				}else{
					String[] directories = path.split("\\\\");
					path = ".\\";
					for(int i = 1; i < directories.length - 2; i++){
						path += "\\" + directories[i];
					}
				}
			}
		}
		if(found){
			return path;
		}else{
			return null;
		}
	}


	/**
	 * Method to display the tree of the given directory
	 * @param currentWorkingDirectory
	 * @param nesting is the level of the subfolder
	 */
	private static void printTree(Directory currentWorkingDirectory, int nesting){		
		Iterator<Directory> iterator = currentWorkingDirectory.getListOfSubDirectory().iterator();
		while(iterator.hasNext()){
			for(int i = 0; i < nesting; i++){
				System.out.print("\u2502    ");
			}
			Directory subDirectory = iterator.next();
			if(iterator.hasNext()){
				System.out.println("\u251c\u2500\u2500" + subDirectory.getName());
			}else{
				System.out.println("\u2514\u2500\u2500" + subDirectory.getName());
			}
			if(subDirectory.getListOfSubDirectory().size() != 0){
				printTree(subDirectory, nesting + 1);
			}
		}
	}
}
