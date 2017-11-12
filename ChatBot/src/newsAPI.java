import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class newsAPI 
{
	public newsAPI()
	{
		
	}
	public String websiteExist(String website)
	{
		String newsURL = "https://newsapi.org/v1/sources?language=en";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(newsURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				result.append(line);
			}
			rd.close();
			
			String news = validateInput(result.toString(),website);
			if(!news.isEmpty())
			{
				return webRequest(website);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "No site by that name";
	}
	
	public String webRequest(String website)
	{
		String newsURL = "https://newsapi.org/v1/articles?source="+website+"&apiKey=1d7ce62430d14280acfac4fe5fbea951";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(newsURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				result.append(line);
			}
			rd.close();
			
			
			String news = parseJson(result.toString());
			return news;
			
		}
		catch(Exception e)
		{

			return "Invalid input: "+e;
		
		}

	}
	public String parseJson(String json)
	{
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		JsonObject websiteObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = websiteObject.getAsJsonArray("articles");
		String output="";
		
		websiteObject =jarray.get(0).getAsJsonObject();
		String author = websiteObject.get("author").getAsString();
		String title =websiteObject.get("title").getAsString();
		String link =websiteObject.get("url").getAsString();
		
		output = "Title::"+title+" || Written by:: "+author+" || LINK::"+link;
	
		if(!output.isEmpty())
		{
			return output;
		}
		else
		{
			return "Top article could not be found";
		}
	}
	public String validateInput(String json,String input)
	{
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		
		JsonObject websitesObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = websitesObject.getAsJsonArray("sources");
		
		for(int i = 0;i<jarray.size();i++)
		{
			websitesObject =jarray.get(i).getAsJsonObject();
	
			
			if(websitesObject.get("id").getAsString().equals(input)||websitesObject.get("name").getAsString().equals(input))
			{
				return websitesObject.get("id").getAsString();
				
			}
		}
		
		
		return "Invalid input";
		
	}
	
}
