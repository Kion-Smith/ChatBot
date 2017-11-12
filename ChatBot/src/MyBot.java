import org.jibble.pircbot.*;

public class MyBot extends PircBot
{
	public MyBot()
	{
		this.setName("KionBot");
	}
	
	public void onMessage(String channel, String sender,String login, String hostname, String message) 
	{
		weatherAPI w= new weatherAPI();
		newsAPI n = new newsAPI();
		
		if(message.equalsIgnoreCase("!help"))
		{
			sendMessage(channel,"You can get the weather from any where by using !weather [location]");
			sendMessage(channel,"You can get the top article from several articles by using !news [news publication]");
			sendMessage(channel,"You can use the !help command to see this again");
			
		}
		else if(message.contains("!weather "))
		{
			String location;
			try
			{
				location = message.substring(message.indexOf("r")+2);
				sendMessage(channel,w.webRequest(location));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(message.contains("!news "))
		{
			String website;
			try
			{
				
				website = message.substring(message.indexOf("s")+2);	
				sendMessage(channel,n.websiteExist(website));

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
