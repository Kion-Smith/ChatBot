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
	static ArrayList<String> currentUsers;
	static String lineTest;
	public static BufferedWriter writer;
	public static void main(String [] args) throws Exception
	{
	//	currentUsers = new ArrayList<String>();
		
		//String channel = "#KionsTestChatRoom";
		//String server  = "irc.freenode.net";
		
		
		chatFrame cf = new chatFrame();
		cf.setTitle("IRC Chat");
		cf.setSize(1000, 650);
		cf.setResizable(false);
		cf.setVisible(true);
		cf.setLocationRelativeTo(null);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
       //  Log on to the server.
		boolean isRunning = true;
		int ran =0;
		
		while(isRunning)
		{
			System.out.print("");
		if(cf.getIsPressed())
		{
			ran =1;
			String username =cf.getUserSettingsPanel().getUsernameTextField().getText();
			String nickname  = cf.getUserSettingsPanel().getNicknameTextField().getText();
			String channel = cf.getUserSettingsPanel().getChannelTextField().getText();
			String server  = cf.getUserSettingsPanel().getServerTextField().getText();
			
			Socket socket = new Socket(server, 6667);
			MyBot b = new MyBot();
			b.setVerbose(true);
			b.connect("irc.freenode.net");
			b.joinChannel(channel);
			b.onMessage(channel,b.getName(),"KionsBot","Kion","!help");
			
			
			writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
			BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
			
			//System.out.println("isa");
		currentUsers = new ArrayList<String>();
        writer.write("NICK " + username + "\r\n");
        writer.write("USER " + nickname + " 8 * : Java IRC Hacks Bot\r\n");
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
        ///	System.out.println( b.getUsers(channel) );
        	cf.getStatusPanel().getCurrentChannelTF().setText(channel);
        	cf.getStatusPanel().getCurrentServerTF().setText(server);
        	cf.getStatusPanel().getIsConnectedTFd().setText("Online");
        	
        	//System.out.println(line);
        	if(line.contains("!") && line.contains("JOIN"))
        	{
        		
        		String userName = line.substring(0+1,line.indexOf("!"));
        		String newMes = "<"+userName+"> joined "+ channel;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		
        		if(!currentUsers.contains(userName) )
    			{
    				currentUsers.add(userName);
    				cf.getOnlineUsersPanel().getUsersOnline().append(userName+"\n");
    				
    			}
        	}
        	if(line.contains("!") && (line.contains("LEAVE") || line.contains("QUIT")) )
        	{
        		String userName = line.substring(0+1,line.indexOf("!"));
        		String newMes = "<"+userName+"> Left "+ channel;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		if(username.equals(userName))
        		{
        			b.quitServer();
        		}
        		
    			currentUsers.remove(userName);
    			
    			cf.getOnlineUsersPanel().getUsersOnline().setText(null);
    			for(int i =0;i<currentUsers.size();i++)
    			{
    				System.out.print(currentUsers.get(i));
    				cf.getOnlineUsersPanel().getUsersOnline().append( currentUsers.get(i)+"\n");
    			}
    			
        	}
        	if(line.contains("!") && line.contains("MSG"))
        	{
        		String userName = line.substring(0 +1,line.indexOf("!"));
        		String message = line.substring(line.indexOf(" :"));
        		String newMes = "<"+userName+">"+message;
        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
        		
        	}
        	if(line.contains("353") && line.contains("@ "+channel))
        	{
        		String usersOnline = line.substring((line.indexOf("@ "+channel+" :")));
        		usersOnline = usersOnline.substring(usersOnline.indexOf(":")+1);

        		String[] usersListString = usersOnline.split(" ");
        		
        		for(int i =0;i<usersListString.length;i++)
        		{

        			if(!currentUsers.contains(usersListString[i]+"") )
        			{
        				cf.getOnlineUsersPanel().getUsersOnline().append(usersListString[i]+"\n");
        				currentUsers.add(usersListString[i]+"");

        				
        			}

        		}

  
        	}
        
         
        }	
		}//end if
		else if(!cf.getIsPressed() && ran>0)
		{
			for(int i =0;i<currentUsers.size();i++)
			{
				currentUsers.remove(i);
			}
			cf.getOnlineUsersPanel().getUsersOnline().setText(null);
			cf.getStatusPanel().getCurrentChannelTF().setText("Not Connected");
			cf.getStatusPanel().getCurrentServerTF().setText("Not Connected");
			cf.getStatusPanel().getIsConnectedTFd().setText("Offline");
		}//end else
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
