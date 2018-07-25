package StockBroking;

public interface StockDataADT {
	public int getStockCount();	//return number of stocks
	public int getWeekCount(); // return number of weeks
	public Week getStocksWeek(int dat1, int dat2); //return a Week given index of which stock and index of which week
	public String getStockName(int data);	//return the name of a stock given its index
	public String getWeekDate(int data);	//return the string representation of a week given its index
	public void passFile(String filename);
}