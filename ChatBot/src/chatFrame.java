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
				String userName=usp.getUsernameTextField().getText();
				String serverName=usp.getServerTextField().getText();
				String nickName=usp.getNicknameTextField().getText();
				String channel=usp.getChannelTextField().getText();
				
				
				
			}
			else if(e.getSource() == usp.getDisconnectButton())
			{
				System.out.println("Disconnected");
			}
			
			if(e.getSource() == cp.getClearButton())
			{
				cp.getChatBoxTextArea().setText(null);
			}
			
			if(e.getSource() == cp.getSendButton())
			{
				
				cp.getChatBoxTextArea().append(cp.getMessageTextArea().getText() +"\n");
				cp.getMessageTextArea().setText(null);
				
			}
			
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	public String validateUsername(String un)
	{
		return "";
	}
	
	public String validateNickname(String nn)
	{
		return "";
	}
	public String validateServer(String sn)
	{
		return "";
	}
	public String validateChannel(String cn)
	{
		return "";
	}
	
	public boolean userInformation(String un,String nn, String sn, String cn)
	{
		return false;
	}
	
	public chatPanel getChatPanel()
	{
		return cp;
	}
}
