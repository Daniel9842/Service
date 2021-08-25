package edu.escuelaing.arep;

/**
 * this class is in charge of storing the url with the requested identification
 * @author Daniel Santiago Ducuara Ardila
 */
public class AlphaHttpStockService extends HttpStockService{

	public String stock = "fb";
	/**
	 * this method returns the url
	 * @return the url to get the json object
	 */
	@Override
	public String getURL() {
		return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=3A320OI0SQZ06SKJ";
	}
	/**
	 * this method updates the indicator of the requested company
	 */
	@Override
	public void setStock(String stock) {
		this.stock = stock;
	}

}
