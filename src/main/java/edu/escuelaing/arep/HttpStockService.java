package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * this class makes the get call to get the json object
 * @author Daniel Santiago Ducuara Ardila
 */
public abstract class HttpStockService {
    private static final String USER_AGENT = "Mozilla/5.0";
    
    /*
     * return the string with the requested values
     * @return the values
     */
    public String getDataService() throws IOException {
    	String responseData = "";
        URL obj = new URL(getURL());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseData = response.toString();
            System.out.println(responseData);
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return responseData;
    }
    /**
	 * this method returns the url
	 * @return the url to get the json object
	 */
    abstract public String getURL();
    /**
	 * this method updates the indicator of the requested company
	 */
    abstract public void setStock(String stock);
}
