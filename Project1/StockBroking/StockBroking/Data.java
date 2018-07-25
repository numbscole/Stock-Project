// Designed by: Nick Scoles
// Course: O-O Software Development Java
// Creates an ArrayList for all of the Companies and all of the weeks
//	
package StockBroking;

import java.util.ArrayList;

public class Data implements StockDataADT{
	private ArrayList<Company> myCompanies = new ArrayList<Company>(); // ArrayList of all of the Companies
	private ArrayList<Week> myWeeks = new ArrayList<Week>();	// ArrayList of all of the Weeks
	private String myFileName;	// Name of the file to be read
	
	public Data() {	}
	public Data(String filename)
	{
		passFile(filename);
		initialize();
	}	
	public void passFile(String filename) {
		myFileName = filename;
	}
	public Company getStock(int index) {
		return myCompanies.get(index);
	}
	public int getStockCount() {
		return myCompanies.size();
	}
	public int getWeekCount() {
		return myWeeks.size();
	}
	public Week getStocksWeek(int dat1, int dat2) {
		return myCompanies.get(dat1).getWeek(dat2);
	}
	public String getStockName(int data) {
		return myCompanies.get(data).getName();
	}
	public String getWeekDate(int data) {
		return myWeeks.get(data).getDate();
	}
	//Data's toString to be called during a print command
	public String toString() {
		String allTheStuff = myFileName;
		return allTheStuff;
	}
	//test to print weeks
	public String printWeek() {
		return myWeeks.toString();
	}
	private void initialize(){
		StockIO empIO = new StockIO(myFileName);
		Week t;
		int count = -1;	// Create index for companies 
		
		// Search through file until no more weeks are created
		while(( t = empIO.getNext()) != null) 
		{
			if(empIO.newCompanyDetector()) {
				Company toAdd = new Company(t.getName()); 
				myCompanies.add(toAdd); // Add new company to Data's Company ArrayList
				count = count + 1;	// Increase index for company
			}
			myWeeks.add(t);	// Add new week to Data's Week ArrayList
			myCompanies.get(count).addWeek(t);	// Add new week to Companies Week ArrayList
		}
	}

}