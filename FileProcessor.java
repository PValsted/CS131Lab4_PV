import java.io.*;
import java.util.*;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		this.setFileName(fileName);
		this.setStringLength(stringLength);
	}//end preferred constructor
	
	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile() {

		StringTooLongException exception = new StringTooLongException("String is too long!");
		ArrayList<String> stringList=new ArrayList<String>();
		
		try {	
			File file=new File(fileName);
			Scanner input=new Scanner(file);
			String line;
			
			while(input.hasNextLine()) {
				line=input.nextLine();
				if (line.length()>stringLength)
					throw exception;
				else stringList.add(line);
			}
			System.out.println(stringList);
			input.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(StringTooLongException e) {
			System.out.println(e.getMessage());
		}
		
	}//end processFile

	public String getFileName() {
		return fileName;
	}//end getFileName

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}//end setFileName

	public int getStringLength() {
		return stringLength;
	}//end getStringLength

	public void setStringLength(int stringLength) {
		if (stringLength>=5)
			this.stringLength = stringLength;
		else {
			this.stringLength = 5;
			System.out.println("StringLength can't be less than 5, set to 5 by default.");
		}
	}//end setStringLength
	
}//end class