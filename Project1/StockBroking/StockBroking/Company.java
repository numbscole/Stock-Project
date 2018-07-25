// Designed by: Nick Scoles
// Course: O-O Software Development Java
// Company object initialized by Data
//

package StockBroking;
import java.util.ArrayList;
public class Company {
	private ArrayList<Week> myWeeks = new ArrayList<Week>();	//ArrayList of Weeks recorded in this Company
	private String companyName;	//Name of the Company	
	
	public Company (String name) {
		companyName = name;
	}
	public String getName() {
		return companyName;
	}
	public Week getWeek(int num) {
		return myWeeks.get(num);
	}
	public ArrayList<Week> getWeek() {
		return myWeeks;
	}
	public int weekSize() {
		return myWeeks.size();
	}
	public void addWeek(Week sometime) {
		myWeeks.add(sometime);
	}
}
