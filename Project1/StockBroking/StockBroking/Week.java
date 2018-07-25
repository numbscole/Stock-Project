// Designed by: Nick Scoles
// Course: O-O Software Development Java
// Week object initialized by StockIO
//

package StockBroking;

public class Week {
	private String name, date;	// Contains the name of the Company and date (xx/xx/xxxx)
	private int quarter;	// Integer value for Quarter  
	private int month, day, year;	// Integer values for the month, date and year
	private double open, high, low, close; // Price of Stock on Monday and Friday, 
											// and highest/lowest prices of the week
	private int volume;	//Integer values of number of people who own the stock
	private double percentChange, volPerChange; // percent Change of the price of stock and
												// percent change of the number of people who own the stock

	public Week() {
		name = "";
		date = "";
		quarter = 0;
		month = 0;
		day = 0;
		open = 0;
		high = 0;
		close = 0;
		low = 0;
		volume = 0;
		percentChange = 0;
		volPerChange = 0;
	}
	public Week (String name, int quarter, String date, String openS, String highS, 
			String lowS, String closeS, double percentChange, int volume, double volChange) 
	{	
		this.name = name;
		this.quarter = quarter;
		this.percentChange = percentChange;
		this.volPerChange = volChange;
		String line = openS.replace("$", "");
		// "$xx.xx" becomes "xx.xx" to be converted into a double
		double temp = Double.parseDouble(line);
		this.open = temp;
		
		line = highS.replace("$", "");
		this.high = Double.parseDouble(line);
		
		line = lowS.replace("$", "");
		this.low = Double.parseDouble(line);
		
		line = closeS.replace("$", "");		
		this.close= Double.parseDouble(line);
		this.volume = volume;
		this.date = date;
		
		String[] line2 = date.split("/");
		// "xx/xx/xxxx" becomes "xx, xx, xxxx" to be converted into month, day, year
		this.month = Integer.parseInt(line2[0]);
		this.day = Integer.parseInt(line2[1]);
		this.year = Integer.parseInt(line2[2]);
	}
	public String toString() {
		String info = "Company:" + this.getName() + " week: " + this.getDate();
		return info;
	}
	public String getDate() {
		return date;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public double getOpen() {
		return open;
	}
	public double getClose() {
		return close;
	}
	public double getHigh() {
		return high;
	}
	public double getLow() {
		return low;
	}
	public double getChange() {
		return percentChange;
	}
	public double getVolChange() {
		return volPerChange;
	}
	public int getVolume() {
		return volume;
	}
	public String getName() {
		return name;
	}	
	public int getQuarter() {
		return quarter;
	}
}
