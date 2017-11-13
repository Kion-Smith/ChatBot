/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 *  Main class
 *  	-Creates user when connect button is pressed
 *  	-instantiates MyBot object and joins server when button is pressed
 *  	-handles users input
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


import javax.swing.JFrame;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class ChatBotMain
{
	public static BufferedWriter writer;// global writer to be used by chatframe and main
	private static  ArrayList<String> currentUsers;// array to hold all current users to add to onlineUsers text area
	
	public static void main(String [] args)
	{
		// instantiate arrayList
		currentUsers = new ArrayList<String>();
		
		//create the jframe
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
			//infinite loop for adding functionality to buttons
			while(isRunning)
			{
				try 
				{
					System.out.print("");
					//if button is pressed then connect items to server
					if(cf.getIsPressed())
					{
						ran =1;
						//set user settings when connect button is pressed
						String username =cf.getUserSettingsPanel().getUsernameTextField().getText();
						String nickname  = cf.getUserSettingsPanel().getNicknameTextField().getText();
						String channel = cf.getUserSettingsPanel().getChannelTextField().getText();
						String server  = cf.getUserSettingsPanel().getServerTextField().getText();
						
						//open socket
						Socket socket = new Socket(server, 6667);
						
						//instantiates bot
						MyBot b = new MyBot();
						try
						{
							b.setVerbose(true);
							b.connect(server);
							b.joinChannel(channel);
							b.onMessage(channel,b.getName(),"KionsBot","Kion","!help");
						}
						// if nickname already exists
						catch(NickAlreadyInUseException e) 
						{
							//print out that the username exits
							cf.getChatPanel().getChatBoxTextArea().setText("(CLIENT): Bot with that name already exists \n");
							b.quitServer();
						}
						//other irc connection problems
						catch(IrcException e)
						{
							e.printStackTrace();
						}
						
						//connect buffered writer and reader to sockets input and output streams
						writer = new BufferedWriter(new OutputStreamWriter( socket.getOutputStream() ) );
						BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() ) );
					
						currentUsers = new ArrayList<String>();// reset array
						//login in user
						writer.write("NICK " + username + "\r\n");
		        		writer.write("USER " + nickname + " 8 * : Java IRC Hacks Bot\r\n");
		        		writer.flush( );
		       
		        		// Read lines from the server until it tells us we have connected.
		        		String line = null;
		        		while ((line = reader.readLine( )) != null)
		        		{
		        			if (line.indexOf("004") >= 0) 
		        			{
			                // Logged in
		        				break;
		        			}
		        			else if (line.indexOf("433") >= 0) 
		        			{
		        				//username  for user is already in use
		        				b.quitServer();
		        				cf.getChatPanel().getChatBoxTextArea().setText("(CLIENT): Username already in use on this channel, you and the bot have been disconected");
		        				cf.setIsPressed(false);
		        			}
			            
		        		}
			        
			        
					///Join the channel.
			        writer.write("JOIN " + channel + "\r\n");
			        writer.flush( );

			       //read server output
			        while ((line = reader.readLine( )) != null) 
			        {
			        	//set the status panel to online
			        	cf.getStatusPanel().getCurrentChannelTF().setText(channel);
			        	cf.getStatusPanel().getCurrentServerTF().setText(server);
			        	cf.getStatusPanel().getIsConnectedTFd().setText("Online");
			        	
			        	//if a new user joins add them
			        	if(line.contains("!") && line.contains("JOIN"))
			        	{
			        		//get username and add a message 
			        		String userName = line.substring(0+1,line.indexOf("!"));
			        		String newMes = "<"+userName+"> joined "+ channel;
			        		
			        		//add to text area
			        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
			        		
			        		//if the username dosent exits already add to array list
			        		if(!currentUsers.contains(userName))
			    			{
			    				currentUsers.add(userName);
			    				cf.getOnlineUsersPanel().getUsersOnline().append(userName+"\n"); // write to text area userOnline
			    				
			    			}
			        	}
			        	//if a user leaves, remove them
			        	if(line.contains("!") && (line.contains("LEAVE") || line.contains("QUIT")) )
			        	{
			        		//get username and add a message
			        		String userName = line.substring(0+1,line.indexOf("!"));
			        		String newMes = "<"+userName+"> Left "+ channel;
			        		//add to text area
			        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
			        		//make bot leave
			        		if(username.equals(userName))
			        		{
			        			b.quitServer();
			        		}
			        		//user leave the server
			    			currentUsers.remove(userName);
			    			//set userOnline to null
			    			cf.getOnlineUsersPanel().getUsersOnline().setText(null);
			    			//print all remaing online users
			    			for(int i =0;i<currentUsers.size();i++)
			    			{
			    				cf.getOnlineUsersPanel().getUsersOnline().append( currentUsers.get(i)+"\n");
			    			}
			    			
			        	}
			        	//get messages from the server
			        	if(line.contains("!") && line.contains("MSG"))
			        	{
			        		//get username and add a message
			        		String userName = line.substring(0 +1,line.indexOf("!"));
			        		String message = line.substring(line.indexOf(" :"));
			        		String newMes = "<"+userName+">"+message;
			        		//get message from server and append
			        		cf.getChatPanel().getChatBoxTextArea().append(newMes +"\n");
			        		
			        	}//get all online users
			        	if(line.contains("353") && line.contains("@ "+channel))
			        	{
			        		//get online users
			        		String usersOnline = line.substring((line.indexOf("@ "+channel+" :")));
			        		usersOnline = usersOnline.substring(usersOnline.indexOf(":")+1);
			        		//put online users into a string[]
			        		String[] usersListString = usersOnline.split(" ");
		        		
		        			for(int i =0;i<usersListString.length;i++)
		        			{
		        				//as long as user dosent exist in arraylist 
		        				if(!currentUsers.contains(usersListString[i]) &&!(username.contains(usersListString[i].substring(1))))
		        				{
		        					//add user to list
		        					cf.getOnlineUsersPanel().getUsersOnline().append(usersListString[i]+"\n");
		        					currentUsers.add(usersListString[i]);
		
		        				
		        				}
		        				
		
		        			}
		
		  
		        		}
		        
		         
			        }	
				}//end of if
				
					
				//if disconnected 
				else if(!cf.getIsPressed() && ran>0)
				{	//remove all users
					for(int i =0;i<currentUsers.size();i++)
					{
						currentUsers.remove(i);
					}
					//set everything back to defaults
					cf.getOnlineUsersPanel().getUsersOnline().setText(null);
					cf.getStatusPanel().getCurrentChannelTF().setText("Not Connected");
					cf.getStatusPanel().getCurrentServerTF().setText("Not Connected");
					cf.getStatusPanel().getIsConnectedTFd().setText("Offline");
				}//end else
			
			}//if server is unknown message,sent client message
			catch(UnknownHostException e)
			{
				cf.getChatPanel().getChatBoxTextArea().setText("(CLIENT): Cannont connect to this server");//cannot connect to server	
			}
			//if error in buffred writing reading senr error messahe
			catch(IOException e)
			{
				cf.getChatPanel().getChatBoxTextArea().setText("(CLIENT): Cannont connect to this server");
			}
			//print out the null pointer
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
				
		}//end of while
    }
	// send messages to server
	static void sendString(BufferedWriter bw, String str) 
	{
	    try 
	    {
	      bw.write(str + "\r\n");
	      bw.flush();
	    }
	    catch (Exception e) 
	    {
	      System.out.println("Exception: "+e);
	    }
	  }
	
	
}
