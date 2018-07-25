// Designed by: Nick Scoles
// Course: O-O Software Development Java
// Handles money and determines when to buy and sell stock
//

package StockBroking;

public class Predictor implements PredictorADT {
	private double myMoney;	// Variable containing Predictor's money
	private Data myInfo;	// Create Data variable to scan through data
	private int boughtStocks;	// Keep up with how many stocks recently bought
	
	public Predictor() {
		myInfo = null;
	}
	public Predictor(Data dat) {
		myInfo = dat;
	}
	public void setPortfolioAmount(double money) {
		myMoney = money;
	}
	public double getPortfolioAmount() {
		return Math.round(myMoney*100)/100;
//		return  Math.round(myMoney * 100) / 100;
	}
	public void setDataSet(StockDataADT t) {
	}
	public void predict() {
		System.out.println("Thinking about an investment..");
		Company temp;	// Create Company variable to look through weeks
		boughtStocks = 0;	// Initialize boughtStocks at 0

		// Look through companies
		for(int i = 0; i < myInfo.getStockCount(); i++) {
			temp = myInfo.getStock(i);	// Set temp to current company
			// Look through the weeks
			for (int k = 1; k < temp.weekSize(); k++) {
				algorithm(i, k);	// Determine if and how many stocks to buy this week for one company
				if(boughtStocks != 0)	// If we bought stocks, then sell them at the close of the same week
					sell(myInfo.getStocksWeek(i, k), boughtStocks);				
			}
		}
	}
	private void buy(Week data) {
		myMoney = myMoney - data.getOpen();
		
		//Can't buy stock with negative money
		if (myMoney < 0)		
			myMoney = myMoney + data.getOpen();
		else {
			// Increments number of stocks bought if we bought stock
			boughtStocks = boughtStocks + 1;
		}
	}
	private void sell(Week data, int howMany) {
		// Sells all of the stocks we bought until boughtStocks = 0
		while(boughtStocks != 0) {
			myMoney = myMoney + data.getClose();
			boughtStocks = boughtStocks - 1;
		}
	}
	private void algorithm(int incr1, int incr2) {
		// finds the percent change of the price of stock from the previous week
		double someChange = myInfo.getStocksWeek(incr1, incr2 - 1).getChange();
		// finds the percent change of the volume of stock owners from the previous week
		double volChange = myInfo.getStocksWeek(incr1, incr2 - 1).getVolChange();
		// If a lot of people are rushing to buy, then we should probably buy
		if(volChange >=80) {
			for(int num = 0; num < 5; num++)
				buy(myInfo.getStocksWeek(incr1, incr2));
		}
		// Still a lot of people but not quite as much 80% increase
		else if(volChange >= 70) {
			for(int num = 0; num < 4; num++)
				buy(myInfo.getStocksWeek(incr1, incr2));			
		}	
		// Only happens when we can look back by two weeks
		try {
			//finds the percent change of the price of stock from two weeks ago
			double someChange2 = myInfo.getStocksWeek(incr1, incr2 - 2).getChange();
			// If price drops and too many people react to try and get rid of their stock
			// 	then price is likely to go back up somewhat to balance supply & demand
			// However, if price drops too much, people might be leaving for 
			// 	a more dramatic reason
			if (volChange <= -35 && someChange2 <= -1 && someChange2 >= -4.5) {
				for(int num = 0; num < 7; num++)
					buy(myInfo.getStocksWeek(incr1, incr2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		// If price drops slightly, then it may likely go back up
		if(someChange <= -1 && someChange >= -2.5)
			for(int n = 0; n < 3; n++)
				buy(myInfo.getStocksWeek(incr1, incr2));
	}
}
