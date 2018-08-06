package Counselling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProgramCounselling{
	public static List<Students> students = new ArrayList<Students>();
	public static List<ProgramsOffered> programsOffered = new ArrayList<ProgramsOffered>();
	
	public static List<Students> readStudentPreferencesViaExcelSheet(){
	    try{
	        FileInputStream file = new FileInputStream(new File("C:\\Users\\User14\\Downloads\\StudentPreference.xlsx"));
	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        while(rowIterator.hasNext()){
	            Row row = rowIterator.next();
	            //For each row, iterate through all the columns
	            Iterator<Cell> cellIterator = row.cellIterator();
	            String name = ((XSSFCell) cellIterator.next()).getStringCellValue();
	            List<String> preferences = new ArrayList<String>();
	            while(cellIterator.hasNext()){
	                XSSFCell cell = (XSSFCell) cellIterator.next();
					preferences.add(cell.getStringCellValue());
	            }
	            students.add(new Students(name, preferences));
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return students;
	}
	
	public static List<ProgramsOffered> readProgramOfferedViaExcelSheet(){
	    try{
	        FileInputStream file = new FileInputStream(new File("C:\\Users\\User14\\Downloads\\programNameAndCapacity.xlsx"));
	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        //Iterate through each rows one by one
			Iterator<Row> rows = sheet.rowIterator();

			while(rows.hasNext()){
				XSSFRow row =(XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();
				String name = ((XSSFCell) cells.next()).getStringCellValue();
				int capacity = (int) ((XSSFCell) cells.next()).getNumericCellValue();
				programsOffered.add(new ProgramsOffered(name, capacity));
			}
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return programsOffered;
	}
	

	private static final String FILE_NAME = "C:\\Users\\User14\\Downloads\\ResultOfStudentCounselling.xlsx";

    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        List<ProgramsOffered> programs = null;
		programs = readProgramOfferedViaExcelSheet();
		CollegeOfferingProgram college;
		try{
			college = new CollegeOfferingProgram(programs);			
			for(Students student : readStudentPreferencesViaExcelSheet())
				college.enqueueStudent(student);			
        
			int rowCount = 0;
		    for (Students aBook : college.counselling()) {
		        Row row = sheet.createRow(rowCount++);
		        writeBook(aBook, row);
		    }
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
        try{
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    
    private static void writeBook(Students student, Row row){
        Cell cell = row.createCell(0);
        cell.setCellValue(student.getName());
     
        cell = row.createCell(1);
        cell.setCellValue(student.getProgramAllotted());
    }
}

