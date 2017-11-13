/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 *  weather api class
 *  	-gets json information and return the weather in a city using zip codes or city names
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class weatherAPI 
{
	public weatherAPI()
	{
		
	}
	
	public String webRequest(String city)
	{
		//create url with city
		String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=6f5cb0dac2efcecee28d199be78da4cb";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(weatherURL);
			//make connection to api
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//request for get 
			conn.setRequestMethod("GET");
			//read the string
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				//add to result string
				result.append(line);
			}
			rd.close();
			
			//get json info and return
			String weather = parseJson(result.toString());
			return weather;
		}
		catch(Exception e)
		{
			
			return "Error :" + e;
		
		}

	}
	
	public String parseJson(String json)
	{
		//create master json object
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		
		//get city name
		JsonObject weatherObject  = MasterWeatherObject.getAsJsonObject();
		String city = weatherObject.get("name").getAsString();
		
		//get country name
		JsonObject sysObject = MasterWeatherObject.getAsJsonObject("sys");
		String country= sysObject.get("country").getAsString();
		
		//get weather type (ex cloudy,rain,ect.)
		JsonObject weatherTypeObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = weatherTypeObject.getAsJsonArray("weather");
		weatherTypeObject =jarray.get(0).getAsJsonObject();
		String weatherType = weatherTypeObject.get("description").getAsString();
		
		//get wind speed
		JsonObject windObject = MasterWeatherObject.getAsJsonObject("wind");
		double speed= windObject.get("speed").getAsDouble();
		
		//get temperatures
		JsonObject tempObject = MasterWeatherObject.getAsJsonObject("main");
		double curTemp= tempObject.get("temp").getAsDouble();
		double humidity= tempObject.get("humidity").getAsDouble();
		double lowTemp= tempObject.get("temp_min").getAsDouble();
		double maxTemp= tempObject.get("temp_max").getAsDouble();
		
		//covert from kelvin to celcius
		curTemp = convertKtoF(curTemp);
		lowTemp = convertKtoF(lowTemp);
		maxTemp = convertKtoF(maxTemp);
			
		return "The temperature in "+city+", "+country+" it is "+curTemp+"c with "+ weatherType+". The low is "+lowTemp+"c with a high of "+ maxTemp+
				"c. The humidty is "+humidity+"% and the wind speed is "+speed+"mph";
		
	}
	public double convertKtoF(double temp)
	{
		temp = ((temp *9)/5)-459.67;
		temp = (double) Math.ceil(temp);
		return temp;
	}
}
