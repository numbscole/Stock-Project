// Designed by: Nick Scoles
// Course: O-O Software Development Java
// Handles File IO: Reads line a single line to be 
// 	placed into a Week while returning a boolean 
// 	catch to check whether or not a new company is being scanned
// 

package StockBroking;
import java.io.*;
import java.util.*;

public class StockIO {
	private String myFileName;
	private BufferedReader myInfile;
	private Scanner scan;
	private boolean detected;
	
	public StockIO(String filename){
		myFileName = filename;
		openFile();
		scan = new Scanner (myInfile);
	}
	public String toString( )
	{
		return "[" + myFileName + "]";
	}
	public boolean newCompanyDetector() {
		return detected;
	}
	public Week getNext(){
		if (scan == null) {
			return null;
		}
		try {
			detected = false;
			// Initialize change in volume to 0 because
			//	first line of company does not contain change in volume
			double volPerChange = 0;
			String aLine = scan.nextLine();
			
			String[] oneLine = aLine.split(",");
			
			// Initializes quarter to zero
			int quarter = 0;
			// If line does not contain expected stock data,
			//	quarter will remain zero
			try {
				quarter = Integer.parseInt(oneLine[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			// If quarter is zero, we need to skip this line as this
			//	line does not contain expected stock data
			if (quarter == 0) {
				return this.getNext();
			}
			
			// Detects new company
			if(aLine.contains(",,,")) {
				detected = true;
			}
			else {
				// If line does not a new company, set change in volume
				volPerChange = Double.parseDouble(oneLine[9]);
			}

			String name = oneLine[1];
			String date = oneLine[2];
			String openS = oneLine[3];
			String highS = oneLine[4];
			String lowS = oneLine[5];
			String closeS = oneLine[6];

			int volume = Integer.parseInt(oneLine[7]);
			double percentChange = Double.parseDouble(oneLine[8]);

			return new Week(name, quarter, date, openS, highS, lowS, closeS, percentChange, volume, volPerChange); 
		}
		catch (Exception e) {
			closeFile();
			return null;
		}
	}
	private void closeFile( )
	{
		scan.close();
		if (myInfile == null)
			return;
		try
		{
			myInfile.close( );
		}
		catch (IOException e) { }
	}
	private void openFile( )
	{
		myInfile = null;
		try
		{
			FileReader fr = new FileReader(myFileName);
			myInfile = new BufferedReader(fr);

		}
		catch (IOException e) {System.err.println("Didn't open " + myFileName);}
	}

}
