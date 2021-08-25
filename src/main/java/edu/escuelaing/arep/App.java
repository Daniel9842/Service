package edu.escuelaing.arep;
import static spark.Spark.*;

import java.io.IOException;

import spark.Request;
import spark.Response;

/**
 * this is the main class of the project that gets the json object
 * @author Daniel Santiago Ducuara Ardila
 *
 */
public class App 
{
	/**
	 * this method calls the static files, and makes a call to the method that returns the json
	 * @param args parameter method main.
	 */
    public static void main( String[] args )
    {
    	staticFiles.location("/public");
    	port(getPort());
        get("/getData", "application/json", (req, res) -> getDataService(req,res));
    }
    
    /**
     * this method takes care of calling another class to obtain the get
     * @param req request parameter
     * @param res response parameter
     * @return the json with the stock market value
     */
	private static String getDataService(Request req, Response res){
		res.type("application/json");
		String response = "null";
		String stock = req.queryParams("st");
		HttpStockService stockService =  CurrentServiceInstance.getInstance().getService();
		if(stock!=null && stock!="") {
			stockService.setStock(stock);
		}
		try {
			response = stockService.getDataService();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	

	/**
	 * this method indicates which port should be used in heroku
	 * @return the port
	 */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
