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
		if (message.equalsIgnoreCase("time")) 
		{
			String time = new java.util.Date().toString();
			sendMessage(channel, "Kion" + ": The time is now " + time);
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
