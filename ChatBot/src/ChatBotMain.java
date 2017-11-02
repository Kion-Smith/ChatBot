import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class ChatBotMain
{
	public static void main(String [] args) throws Exception
	{
		
		String channel = "#KionsChatTestRoom";
		String server  = "irc.freenode.net";
		//Socket socket = new Socket(server, 6667);
		
		chatFrame cf = new chatFrame();
		cf.setTitle("IRC Chat");
		cf.setSize(1024, 768);
		//cf.setResizable(false);
		cf.setVisible(true);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//b.messages(channel, reader.readLine());
		userBot u = new userBot("Neon");
		u.setVerbose(true);
		u.connect("irc.freenode.net");
		u.joinChannel(channel);
		
		MyBot b = new MyBot();
		b.setVerbose(true);
		b.connect("irc.freenode.net");
		b.joinChannel(channel);
		//sends current time
		
		
		b.onMessage("#KionsChatTestRoom",  "Kion", "test",  "user",  "time");
		
		
		//if(reader.equals(""))
		//{
			
		//}
	
		
		//MyBot b = new MyBot();
		//b.setVerbose(true);
		//b.joinChannel(channel);
	
		
		/*
        String nick = "person1";
        String login = "TestPeople";


        // The channel which the bot will join.
      //  String channel = "#irchacks";
        
        // Connect directly to the IRC server.
        
      //  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true );
        BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
        
        // Log on to the server.
        writer.write("NICK " + nick + "\r\n");
        writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");
        writer.flush( );
        
        // Read lines from the server until it tells us we have connected.
        String line = null;
        while ((line = reader.readLine( )) != null)
        {
            if (line.indexOf("004") >= 0) 
            {
                // We are now logged in.
                break;
            }
            else if (line.indexOf("433") >= 0) 
            {
                System.out.println("Nickname is already in use.");
                return;
            }
            
        }
        
        // Join the channel.
        writer.write("JOIN " + channel + "\r\n");
        writer.flush( );
        
        // Keep reading lines from the server.
        while ((line = reader.readLine( )) != null) 
        {
        	if(line.contains("Hello"))
        	{
        		Scanner kb = new Scanner(System.in);
        		System.out.println("tp message");
        		line = kb.nextLine();
        		writer.write(line);
        		writer.flush();
        	}
            if (line.toLowerCase( ).startsWith("PING "))
            {
                // We must respond to PINGs to avoid being disconnected.
                writer.write("PONG " + line.substring(5) + "\r\n");
                writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
                writer.flush( );
            }
            else {
                // Print the raw line received by the bot.
                System.out.println(line);
            }
        }*/
    }
		
	
	
}
