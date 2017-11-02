import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class userSettingsPanel extends JPanel
{
	JLabel userNameLabel,nickNameLabel,serverLabel,channelLabel;
	JTextField userNameTextField,nickNameTextField,serverTextField,channelTextField;
	JButton connectButton,disconnectButton;
	public userSettingsPanel()
	{
		userNameLabel = new JLabel("Username");
		nickNameLabel= new JLabel("Nickname");
		serverLabel = new JLabel("Server");
		channelLabel= new JLabel("Channel");;
		
		userNameTextField = new JTextField();
		nickNameTextField= new JTextField();
		serverTextField= new JTextField();
		channelTextField= new JTextField();
		
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
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
