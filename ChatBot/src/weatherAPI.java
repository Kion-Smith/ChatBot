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

		String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=6f5cb0dac2efcecee28d199be78da4cb";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(weatherURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				result.append(line);
			}
			rd.close();
			
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
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		
		JsonObject weatherObject  = MasterWeatherObject.getAsJsonObject();
		String city = weatherObject.get("name").getAsString();
		
		JsonObject sysObject = MasterWeatherObject.getAsJsonObject("sys");
		String country= sysObject.get("country").getAsString();
		
		JsonObject weatherTypeObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = weatherTypeObject.getAsJsonArray("weather");
		weatherTypeObject =jarray.get(0).getAsJsonObject();
		String weatherType = weatherTypeObject.get("description").getAsString();
		
		JsonObject windObject = MasterWeatherObject.getAsJsonObject("wind");
		double speed= windObject.get("speed").getAsDouble();
		
		JsonObject tempObject = MasterWeatherObject.getAsJsonObject("main");
		double curTemp= tempObject.get("temp").getAsDouble();
		double humidity= tempObject.get("humidity").getAsDouble();
		double lowTemp= tempObject.get("temp_min").getAsDouble();
		double maxTemp= tempObject.get("temp_max").getAsDouble();
		
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
