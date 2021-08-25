package edu.escuelaing.arep;

/**
 * this class uses the singleton pattern to instantiate the services.
 * @author Daniel Santiago Ducuara Ardila
 */
public class CurrentServiceInstance {
	private static CurrentServiceInstance _instance = new CurrentServiceInstance();
	private  HttpStockService service;
	
	private CurrentServiceInstance() {
		service = new AlphaHttpStockService();
	}
	/*
	 * this method will return the instance of the class
	 * @return the instance
	 */
	public static CurrentServiceInstance getInstance() {
		return _instance;
	}
	/**
	 * this method returns the service
	 * @return the service used
	 */
	public HttpStockService getService() {
		return service;
	}

}
