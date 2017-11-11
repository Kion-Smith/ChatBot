//Test class

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
		//System.out.println(weather.webRequest("Dallas"));
		
		if (message.equalsIgnoreCase("time")) 
		{
			String time = new java.util.Date().toString();
			sendMessage(channel, "Kion" + ": The time is now " + time);
		}
		else if(message.contains("!weather "))
		{
			String temp;
			try
			{
				temp = message.substring(message.indexOf("r")+2);
				System.out.println(temp);
				//System.out.println( );
				
				sendMessage(channel,w.webRequest(temp));
			}
			catch(Exception e)
			{
				
			}
			
		}
		else if (message.equalsIgnoreCase("Hello")) 
		{
			sendMessage(channel, "Hello Kion!");
		}
		else if(message.equalsIgnoreCase("Bye bot"))
		{
			sendMessage(channel, "Bye Kion!");
		}
	}
}
