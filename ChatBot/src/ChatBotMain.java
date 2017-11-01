import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatBotMain
{
	public static void main(String [] args) throws Exception
	{
		
		String channel = "#KionsChatTestRoom";
		String server  = "irc.freenode.net";
		Socket socket = new Socket(server, 6667);
		
		MyBot b = new MyBot();
		b.setVerbose(true);
		try
		{
			b.connect("irc.freenode.net");
		}
		catch(Exception e)
		{
			
		}
		b.joinChannel(channel);
		//sends current time
		
		
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		
		//if(reader.equals(""))
		//{
			b.onMessage("#KionsChatTestRoom",  "Kion", "test",  "user",  "time");
		//}
		
		//b.messages(channel, reader.readLine());
		/*
		 * This is for a users
		
		String name = "My name Bot";
		String loginName = "KionsBot";
		
		String channel = "#KionsChatTestRoom";
		
		
	
		writer.write("Name: " + name);
		writer.flush();
		
		String line = null;
		while((line = reader.readLine( )) != null)
		{
			if(line.indexOf("004") >= 0)
			{
				break;
			}
			else if(line.indexOf("433") >= 0)
			{
				System.out.println("The name is already in use");
				return;
			}
		}
		
		writer.write("join"+ channel);
		writer.flush();
		
		while ((line = reader.readLine( )) != null) 
		{
            if (line.toLowerCase( ).startsWith("PING ")) 
            {
                writer.write("PONG " + line.substring(5) + "\r\n");
                writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
                writer.flush( );
            }
            else 
            {
                System.out.println(line);
            }
        }
		*/
	}
	
}
