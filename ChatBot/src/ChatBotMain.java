
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
		b.joinChannel("#testtesttest");
		//sends current time
		b.onMessage( "#testtesttest",  "Sender", "test",  "user",  "time");
	}
}
