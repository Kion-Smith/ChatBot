/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 * Chat Frame class
 *  	-instantiates the panels and add them to the jframe
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class chatFrame extends JFrame implements ActionListener
{
	//all the panel objects
	private chatPanel cp;
	private userSettingsPanel usp;
	private onlineUsersPanel ou;
	private statusPanel sp;
	
	private boolean pressed;//if connect button is pressed
	
	//chat frames user setting objects
	private String userName="";
	private String serverName="";
	private String nickName="";
	private String channel="";

	public chatFrame()
	{
		//instantiates panel
		cp = new chatPanel();
		usp = new userSettingsPanel();
		ou = new onlineUsersPanel();
		sp = new statusPanel();
		
		//add action listener to the buttons
		cp.getSendButton().addActionListener(this);
		cp.getClearButton().addActionListener(this);
		usp.getConnectButton().addActionListener(this);
		usp.getDisconnectButton().addActionListener(this);
		
		//set the layout
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		//set fill to max
		//ADD CHAT PANEL
		gc.fill = GridBagConstraints.BOTH;
		//set location within the panel
		gc.gridx =0;
		gc.gridy =0;
		//pad chat panel
		gc.ipadx=180;
		gc.ipady = 70;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 10, 0, 10);
		add(cp,gc);

		//ADD user setting panel 
		gc.gridx =0;
		gc.gridy =1;
		gc.gridwidth = 2;
		gc.ipadx = 0;
		gc.ipady  = -10;
		add(usp,gc);

		//ADD onlineusers panel
		gc.gridx =1;
		gc.gridy =0;
		add(ou,gc);
		
		//ADD satus  panel
		gc.gridx =1;
		gc.gridy =1;
		add(sp,gc);
		
		
	}
	//get actions
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//if button connect is pressed
			if(e.getSource() ==usp.getConnectButton() )
			{
				//set user info to true, and set user info
				 setUsername(usp.getUsernameTextField().getText() );
				 setServer(usp.getServerTextField().getText() );
				 setNickname(usp.getNicknameTextField().getText());
				 setChannel(usp.getChannelTextField().getText());
				setIsPressed(true);
				
			}
			//if button disconnect is pressed
			else if(e.getSource() == usp.getDisconnectButton())
			{	
				//set area to default and set pressed to fasle
				ou.getUsersOnline().setText(null);
				
				ChatBotMain.sendString(ChatBotMain.writer,"QUIT "+cp.getMessageTextArea().getText()+"\n");
				setIsPressed(false);
				sp.getCurrentChannelTF().setText("Not Connected");
				sp.getCurrentServerTF().setText("Not Connected");
				sp.getIsConnectedTFd().setText("Offline");
				
			}
			//clear text box
			if(e.getSource() == cp.getClearButton())
			{
				cp.getChatBoxTextArea().setText(null);
			}
			//send messages
			if(e.getSource() == cp.getSendButton())
			{
				if(!(cp.getMessageTextArea().getText().equals("")))
				{
					//use chatbotmain to and global writer to send message
        			ChatBotMain.sendString(ChatBotMain.writer,"PRIVMSG "+channel+" :"+cp.getMessageTextArea().getText()+"\n");
					cp.getChatBoxTextArea().append("<"+userName+">"+cp.getMessageTextArea().getText() +"\n");
					cp.getMessageTextArea().setText(null);
				}
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	//getters
	public boolean getIsPressed()
	{
		return pressed;
	}
	public String getUsername()
	{
		return userName;
	}
	
	public String getNickname()
	{
		return nickName;
	}
	public String getServer()
	{
		return serverName;
	}
	public String getChannel()
	{
		return channel;
	}
	public chatPanel getChatPanel()
	{
		return cp;
	}
	public onlineUsersPanel getOnlineUsersPanel()
	{
		return ou;
	}
	public userSettingsPanel getUserSettingsPanel()
	{
		return usp;
	}
	public statusPanel getStatusPanel()
	{
		return sp;
	}
	
	//setters
	public void setIsPressed(boolean b)
	{
		pressed =b;
	}
	public void setUsername(String un)
	{
		userName = un;
	}
	
	public void setNickname(String nn)
	{
		nickName = nn;
	}
	public void setServer(String sn)
	{
		serverName = sn;
	}
	public void setChannel(String cn)
	{
		channel = cn;
	}
}
