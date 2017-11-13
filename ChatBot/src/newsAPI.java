/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 *   news api class
 *  	-validates user input if similar to name of news website
 *  	-gets json object and prints out the first popular article
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class newsAPI 
{
	public newsAPI()
	{
		
	}
	//make sure it exists
	public String websiteExist(String website)
	{
		//go to sources url
		String newsURL = "https://newsapi.org/v1/sources?language=en";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(newsURL);
			//make connection to server
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//request a get
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				result.append(line);
			}
			rd.close();
			//if user input is close then validate and make it right
			String news = validateInput(result.toString(),website);
			//if news is not empty get the info
			if(!news.isEmpty())
			{
				return webRequest(news);
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
		//create url using wbesite information
		String newsURL = "https://newsapi.org/v1/articles?source="+website+"&apiKey=1d7ce62430d14280acfac4fe5fbea951";
		StringBuilder result = new StringBuilder();
		
		try
		{
			URL  url = new URL(newsURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//request a get
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = rd.readLine())!= null)
			{
				result.append(line);
			}
			rd.close();
			
			//parse json information
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
		//create master object
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		
		//create array object
		JsonObject websiteObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = websiteObject.getAsJsonArray("articles");
		String output="";
		
		//get top story
		websiteObject =jarray.get(0).getAsJsonObject();
		String author = websiteObject.get("author").getAsString();
		String title =websiteObject.get("title").getAsString();
		String link =websiteObject.get("url").getAsString();
		
		//set to userinfo to output string
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
		//create master object
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject MasterWeatherObject = jelement.getAsJsonObject();
		
		//create array object
		JsonObject websitesObject = MasterWeatherObject.getAsJsonObject();
		JsonArray jarray = websitesObject.getAsJsonArray("sources");
		
		//check array 
		for(int i = 0;i<jarray.size();i++)
		{
			websitesObject =jarray.get(i).getAsJsonObject();
	
			//if the website input is id or name set to id
			if(websitesObject.get("id").getAsString().equals(input)||websitesObject.get("name").getAsString().equals(input))
			{
				return websitesObject.get("id").getAsString();
				
			}
		}
		
		return "Invalid input";
		
	}
	
}
