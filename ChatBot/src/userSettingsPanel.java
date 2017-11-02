import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class userSettingsPanel extends JPanel
{
	JLabel userNameLabel,nickNameLabel,serverLabel,channelLabel;
	JTextField userNameTextField,nickNameTextField,serverTextField,channelTextField;
	JButton connectButton,disconnectButton;
	Border sortingBorder;
	
	public userSettingsPanel()
	{
		userNameLabel = new JLabel("Username");
		nickNameLabel= new JLabel("Nickname");
		serverLabel = new JLabel("Server");
		channelLabel= new JLabel("Channel");;
		
		userNameTextField = new JTextField(20);
		nickNameTextField= new JTextField(20);
		serverTextField= new JTextField(20);
		channelTextField= new JTextField(20);
		
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
		
		sortingBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		setBorder(sortingBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy =0;
		add(userNameLabel,gc);
		
		gc.gridx =1;
		gc.gridy =0;
		add(userNameTextField,gc);
		
		gc.gridx =2;
		gc.gridy =0;
		add(nickNameLabel,gc);
		
		gc.gridx =3;
		gc.gridy =0;
		add(nickNameTextField,gc);
		
		gc.gridx = 1;
		gc.gridy =1;
		add(serverLabel,gc);
		
		gc.gridx =1;
		gc.gridy =1;
		add(serverTextField,gc);
		
		gc.gridx =2;
		gc.gridy =1;
		add(channelLabel,gc);
		
		gc.gridx =3;
		gc.gridy =1;
		add(channelTextField,gc);
		
		gc.gridx =4;
		gc.gridy =0;
		add(connectButton,gc);
		
		gc.gridx =5;
		gc.gridy =0;
		add(disconnectButton,gc);
		

		
		
	}
	
	public JLabel getUsernameLabel()
	{
		return userNameLabel;
	}
	public JLabel getNicknameLabel()
	{
		return nickNameLabel;
	}
	public JLabel getServerLabel()
	{
		return serverLabel;
	}
	public JLabel getChannelLabel()
	{
		return channelLabel;
	}
	public JTextField getUsernameTextField()
	{
		return userNameTextField;
	}
	public JTextField getNicknameTextField()
	{
		return nickNameTextField;
	}
	public JTextField getServerTextField()
	{
		return serverTextField;
	}
	public JTextField getChannelTextField()
	{
		return channelTextField;
	}
	public JButton getConnectButton()
	{
		return connectButton;
	}
	public JButton getDisconnectButton()
	{
		return disconnectButton;
	}
	
	public void setUsernameLabel(JLabel j)
	{
		userNameLabel = j;
	}
	public void setNicknameLabel(JLabel j)
	{
		nickNameLabel = j;
	}
	public void setServerLabel(JLabel j)
	{
		serverLabel = j;
	}
	public void setChannelLabel(JLabel j)
	{
		channelLabel = j;
	}
	public void setUsernameTextField(JTextField j)
	{
		userNameTextField = j;
	}
	public void setNicknameTextField(JTextField j)
	{
		nickNameTextField = j;
	}
	public void setServerTextField(JTextField j)
	{
		serverTextField = j;
	}
	public void setChannelTextField(JTextField j)
	{
		channelTextField = j;
	}
	public void setConnectButton(JButton j)
	{
		 connectButton = j;
	}
	public void setDisconnectButton(JButton j)
	{
		 disconnectButton=j;
	}
}
