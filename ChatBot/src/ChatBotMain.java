import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
/*THINGS TO DO
 * Get two apis to use
 * add in functionality of buttons and other junk
 * add setters and getters for all variables
 */
public class ChatBotMain
{
	static String lineTest;
	public static BufferedWriter writer;
	public static void main(String [] args) throws Exception
	{
		
		String channel = "#KionsTestChatRoom";
		String server  = "irc.freenode.net";
		Socket socket = new Socket(server, 6667);
		
		chatFrame cf = new chatFrame();
		cf.setTitle("IRC Chat");
		cf.setSize(1000, 650);
		cf.setResizable(false);
		cf.setVisible(true);
		cf.setLocationRelativeTo(null);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//b.messages(channel, reader.readLine());
		
	
		/*
		userBot u = new userBot("MyNameJeff");
		u.setVerbose(true);
		u.connect("irc.freenode.net");
		u.joinChannel(channel);
		Not needed
		*/
		MyBot b = new MyBot();
		b.setVerbose(true);
		b.connect("irc.freenode.net");
		b.joinChannel(channel);
		//sends current time
			/*
		
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
        
      //  
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true );
        BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
         */
		
		writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
		BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
        // Log on to the server.
        writer.write("NICK " + "other" + "\r\n");
        writer.write("USER " + "other" + " 8 * : Java IRC Hacks Bot\r\n");
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
        
        //  sendString(writer,"PRIVMSG "+channel+" :"+cf.getChatPanel().getMessageTextArea().getText()+"\n");
        
		///Join the channel.
		
        writer.write("JOIN " + channel + "\r\n");
        writer.flush( );
        
        // Keep reading lines from the server.
         
       // String meme = "USERS " + channel + "\r\n";
        //writer.write(meme);
		 line = null;	
        while ((line = reader.readLine( )) != null) 
        {
        	
        	System.out.println(line);
        	if(line.contains("!") && line.contains("JOIN"))
        	{
        		String userName = line.substring(0+1,line.indexOf("!"));
        		String newMes = "<"+userName+"> joined "+ channel;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		//cf.getChatPanel().getChatBoxTextArea().append(line +"\n");
        	}
        	if(line.contains("!") && line.contains("MSG"))
        	{
        		String userName = line.substring(0 +1,line.indexOf("!"));
        		String message = line.substring(line.indexOf(" :"));
        		String newMes = "<"+userName+">"+message;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		
        		//cf.getChatPanel().getChatBoxTextArea().append(line +"\n");  
        	}
        	if(line.contains("353") && line.contains("@ "+channel))
        	{
        		String usersOnline = line.substring((line.indexOf("@ #KionsTestChatRoom :")));
        		usersOnline = usersOnline.substring(usersOnline.indexOf(":")+1);
        		
        		System.out.println(usersOnline);

  
        	}

         
        }
    }
	static void sendString(BufferedWriter bw, String str) {
	    try {
	      bw.write(str + "\r\n");
	      bw.flush();
	    }
	    catch (Exception e) {
	      System.out.println("Exception: "+e);
	    }
	  }
	
	
}
