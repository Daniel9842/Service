package edu.escuelaing.arep;

/**
 * this class is in charge of storing the url with the requested identification
 * 
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class IEXHttpStockService extends HttpStockService {

	public String stock = "aapl";

	/**
	 * this method returns the url
	 * @return the url to get the json object
	 */
	@Override
	public String getURL() {
		return "https://cloud.iexapis.com/stable/tops?token=pk_82b28c3a3e1445bca56d1b968fdea8f0&symbols="+stock;
	}

	/**
	 * this method updates the indicator of the requested company
	 */
	@Override
	public void setStock(String stock) {
		this.stock = stock;
	}

}
