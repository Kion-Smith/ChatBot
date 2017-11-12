import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class chatFrame extends JFrame implements ActionListener
{
	private chatPanel cp;
	private userSettingsPanel usp;
	private onlineUsersPanel ou;
	private statusPanel sp;
	
	public static boolean  pressed;//need to fix
	
	
	String userName="";
	String serverName="";
	String nickName="";
	String channel="";
	private String setNickname;
	public chatFrame()
	{
		cp = new chatPanel();
		usp = new userSettingsPanel();
		ou = new onlineUsersPanel();
		sp = new statusPanel();
		
		cp.getSendButton().addActionListener(this);
		cp.getClearButton().addActionListener(this);
		
		usp.getConnectButton().addActionListener(this);
		usp.getDisconnectButton().addActionListener(this);
		
		
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx =0;
		gc.gridy =0;
		gc.ipadx=180;
		gc.ipady = 70;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 10, 0, 10);
		add(cp,gc);

		gc.gridx =0;
		gc.gridy =1;
		gc.gridwidth = 2;
		gc.ipadx = 0;
		gc.ipady  = -10;
		add(usp,gc);

		gc.gridx =1;
		gc.gridy =0;
		add(ou,gc);
		
		gc.gridx =1;
		gc.gridy =1;
		add(sp,gc);
		
		
	}

	public void actionPerformed(ActionEvent e)
	{
		
		
		try
		{
			if(e.getSource() ==usp.getConnectButton() )
			{
				System.out.println("Connected");
				//isPressed = true;
				 setUsername(usp.getUsernameTextField().getText() );
				 setServer(usp.getServerTextField().getText() );
				 setNickname(usp.getNicknameTextField().getText());
				 setChannel(usp.getChannelTextField().getText());
				setIsPressed(true);
				//isPressed = false;
				
			}
			else if(e.getSource() == usp.getDisconnectButton())
			{
				
				ou.getUsersOnline().setText(null);
				
				ChatBotMain.sendString(ChatBotMain.writer,"QUIT "+cp.getMessageTextArea().getText()+"\n");
				setIsPressed(false);
				sp.getCurrentChannelTF().setText("Not Connected");
				sp.getCurrentServerTF().setText("Not Connected");
				sp.getIsConnectedTFd().setText("Offline");
				
			}
			
			if(e.getSource() == cp.getClearButton())
			{
				cp.getChatBoxTextArea().setText(null);
			}
			
			if(e.getSource() == cp.getSendButton())
			{
				if(!(cp.getMessageTextArea().getText().equals("")))
				{
					//String temp = "#KionsTestChatRoom";
        			ChatBotMain.sendString(ChatBotMain.writer,"PRIVMSG "+channel+" :"+cp.getMessageTextArea().getText()+"\n");
					cp.getChatBoxTextArea().append("<"+userName+">"+cp.getMessageTextArea().getText() +"\n");
					cp.getMessageTextArea().setText(null);
				}
				
			}
			
		}
		catch(Exception ex)
		{
			
		}
		
	}

	
	public boolean getIsPressed()
	{
		return pressed;
	}
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
	
	public boolean userInformation(String un,String nn, String sn, String cn)
	{
		return false;
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
}
