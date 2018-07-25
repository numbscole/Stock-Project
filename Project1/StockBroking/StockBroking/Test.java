// Designed by: Nick Scoles
// Course: O-O Software Development Java
//

package StockBroking;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Data datDataTho = new Data();
		Data datDataTho = new Data("dow_jones_index1_3.data");
		System.out.println(datDataTho);
		System.out.println(datDataTho.getWeekCount());
		System.out.println(datDataTho.getStockCount());
		System.out.println(datDataTho.printWeek());
		for (int i = 0; i < datDataTho.getStockCount(); i++)
			System.out.println(datDataTho.getStockName(i));
		System.out.println("Broker Joe Created");
		Predictor joe = new Predictor(datDataTho);
		joe.setPortfolioAmount(1000);
		System.out.println("Joe: I got $" + joe.getPortfolioAmount());
		joe.predict();
		System.out.println("Joe: I got $" + joe.getPortfolioAmount());
	}

}