/*
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


import javax.swing.JFrame;

public class ChatBotMain
{
	public static BufferedWriter writer;
	private static  ArrayList<String> currentUsers;
	
	public static void main(String [] args) throws Exception
	{
	
		currentUsers = new ArrayList<String>();
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
					b.connect(server);
					b.joinChannel(channel);
					b.onMessage(channel,b.getName(),"KionsBot","Kion","!help");
				
				
					writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
					BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
				
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
		                //System.out.println("Nickname is already in use.");
	        				b.quitServer();
	        				cf.getChatPanel().getChatBoxTextArea().setText("Username already in use on this channel, you and the bot have been disconected");
	        				cf.setIsPressed(false);
		               // return;
	        			}
		            
	        		}
		        
		        
				///Join the channel.
				
		        writer.write("JOIN " + channel + "\r\n");
		        writer.flush( );
		        
		        // Keep reading lines from the server.
		         
		       
		        while ((line = reader.readLine( )) != null) 
		        {
		        	cf.getStatusPanel().getCurrentChannelTF().setText(channel);
		        	cf.getStatusPanel().getCurrentServerTF().setText(server);
		        	cf.getStatusPanel().getIsConnectedTFd().setText("Online");
		        	
		        	if(line.contains("!") && line.contains("JOIN"))
		        	{
		        		
		        		String userName = line.substring(0+1,line.indexOf("!"));
		        		String newMes = "<"+userName+"> joined "+ channel;
		        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
		        		
		        		if(!currentUsers.contains(userName))
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
	
	        				if(!currentUsers.contains(usersListString[i]) &&!(username.contains(usersListString[i].substring(1))))
	        				{
	        					cf.getOnlineUsersPanel().getUsersOnline().append(usersListString[i]+"\n");
	        					currentUsers.add(usersListString[i]);
	
	        				
	        				}
	        				
	
	        			}
	
	  
	        		}
	        
	         
		        }	
			}//end of if
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
		}//end of while
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
