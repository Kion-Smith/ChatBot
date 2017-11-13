/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 *  Bot class
 *  	-all the properties for the bot
 *  	- send messages for the bot
 */
import org.jibble.pircbot.*;

public class MyBot extends PircBot
{
	//default constructor
	public MyBot()
	{
		this.setName("KionBot");
	}
	//Overridden method of on message
	public void onMessage(String channel, String sender,String login, String hostname, String message) 
	{
		//instantiates api's
		weatherAPI w= new weatherAPI();
		newsAPI n = new newsAPI();
		
		//if help message is evoked
		if(message.equalsIgnoreCase("!help"))
		{
			//send help info to server
			sendMessage(channel,"You can get the weather from any where by using !weather [location]");
			sendMessage(channel,"You can get the top article from several articles by using !news [news publication]");
			sendMessage(channel,"You can use the !help command to see this again");
			
		}
		//weater api command
		else if(message.contains("!weather "))
		{
			String location;
			try
			{
				location = message.substring(message.indexOf("r")+2);// get location name
				//send message from api output
				sendMessage(channel,w.webRequest(location));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		//Time api command
		else if(message.contains("!news "))
		{
			String website;
			try
			{
				//get website
				website = message.substring(message.indexOf("s")+2);	
				//send message from api outpu
				sendMessage(channel,n.websiteExist(website));

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
