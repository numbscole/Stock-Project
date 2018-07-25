package StockBroking;

public interface PredictorADT {
	public void setPortfolioAmount(double money); //sets initial amount of cash
	public double getPortfolioAmount();	//returns current amount of cash
	public void setDataSet(StockDataADT t);	//sets the local DataADT object (sets which data is being used)
	public void predict();	//executes the stock prediction based on current cash on hand and data	
}