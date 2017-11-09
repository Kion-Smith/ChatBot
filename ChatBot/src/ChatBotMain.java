import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
/*THINGS TO DO
 * Get two apis to use
 * regex for finding patterns within api 
 * images dont work
 * open weather is good one,try
 * ADD GSON
 * 
 * goo.gl/v8dPyY
 * https://docs.google.com/presentation/d/1KRw7n8qOwK-k5XPZDqUCaAD33X0n7W1E048YRYvlDRw/edit#slide=id.g2a9e3de2a4_0_0
 */
public class ChatBotMain
{
	static LinkedList<String> currentUsers;
	static String lineTest;
	public static BufferedWriter writer;
	public static void main(String [] args) throws Exception
	{
		currentUsers = new LinkedList<String>();
		
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
	
*/
		
		writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
		BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
        // Log on to the server.
        writer.write("NICK " + "otherPerson123" + "\r\n");
        writer.write("USER " + "otherPerson123" + " 8 * : Java IRC Hacks Bot\r\n");
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
         
       
        while ((line = reader.readLine( )) != null) 
        {
        	int temp = 1;
        	
        	System.out.println(line);
        	if(line.contains("!") && line.contains("JOIN"))
        	{
        		String userName = line.substring(0+1,line.indexOf("!"));
        		String newMes = "<"+userName+"> joined "+ channel;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		
        		if(!currentUsers.contains(userName) )
    			{
    				currentUsers.add(userName);
    				//cf.getOnlineUsersPanel().getListModel().addElement(userName);
    				System.out.println(userName +"...................");
    			}
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

        		String[] usersListString = usersOnline.split(" ");
        		
        		for(int i =0;i<usersListString.length;i++)
        		{
        			System.out.println(usersListString[i]);
        			if(!currentUsers.contains(usersListString[i]) )
        			{
        				currentUsers.add(usersListString[i]);
        				//cf.getOnlineUsersPanel().getListModel().addElement( usersListString[i] );
        				
        				System.out.println(usersListString[i] +"...................");
        			}
        			//cf.getOnlineUsersPanel().getListModel().addElement(usersListString[i]);
        		}
        		
        		temp = 0;
        		if(temp == 0)
        		{
        			for(int i =0;i<currentUsers.size();i++)
        			{
        				System.out.println(currentUsers.get(i) +"IN THE LIST");
        				cf.getOnlineUsersPanel().getListModel().addElement( currentUsers.get(i) );
        			}
        		}
        			
        			//cf.getOnlineUsersPanel().getListModel().addElement(b.getName());
        		

  
        	}
        	
        	if(true)
    		{
    			for(int i =0;i<currentUsers.size();i++)
        		{
        			System.out.println(currentUsers.get(i) +"IN THE LIST");
        			cf.getOnlineUsersPanel().getListModel().addElement( currentUsers.get(i) );
        		}
    		}

         
        }
    }
	static void sendString(BufferedWriter bw, String str) 
	{
	    try 
	    {
	      bw.write(str + "\r\n");
	      bw.flush();
	    }
	    catch (Exception e) {
	      System.out.println("Exception: "+e);
	    }
	  }
	
	
}
