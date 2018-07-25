package project1;

import java.io.*;

public class DataTest 
{

	public static void main(String[] args) throws IOException
	{
		Data dat = new Data("./dow_jones_index.data");
		BasicPredictor stockMan = new Broker(dat);
		stockMan.setPortfolioAmount(10000);
		stockMan.predict();
		System.out.println("type 1 final amount $"+stockMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker1 stockerMan = new Broker1(dat);
		stockerMan.setPortfolioAmount(10000);
		stockerMan.predict();
		System.out.println("type 2 final amount $"+stockerMan.getPortfolioAmount());
		
		System.out.println("--------------------------------\n--------------------------------");
		Broker2 stockestMan = new Broker2(dat);
		stockestMan.setPortfolioAmount(10000);
		stockestMan.predict();
		System.out.println("type 3 final amount $"+stockestMan.getPortfolioAmount());
		
		System.out.println(dat.getStockCount());
		System.out.println(dat.getWeekCount());
		System.out.println(dat.getStocksWeek(1, 1));
		System.out.println(dat.getStockSymbol(2));
		System.out.println(dat.getStockName(2));
		System.out.println(dat.getWeekDate(3));		
		System.out.println(stockMan.rankStocks(3));
		
	}

}
