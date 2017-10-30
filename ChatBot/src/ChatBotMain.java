
public class ChatBotMain
{
	public static void main(String [] args) 
	{
		MyBot b = new MyBot();
		b.setVerbose(true);
		try
		{
			b.connect("irc.freenode.net");
		}
		catch(Exception e)
		{
			
		}
		b.joinChannel("#picrbot");
	}
}
