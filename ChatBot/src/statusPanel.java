import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class statusPanel extends JPanel 
{
	private JLabel currentServerLabel,isConnectedLabel,currentChannelLabel;
	private JTextField currentServerTF,isConnectedTF,currentChannelTF;
	private TitledBorder statusBorder;
	
	public statusPanel()
	{
		statusBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "STATUS");
		
		currentServerLabel = new JLabel("Current Server");
		currentChannelLabel = new JLabel("Current Channel");
		isConnectedLabel = new JLabel("Connection Status");
		
		currentChannelTF= new JTextField(20);
		currentServerTF= new JTextField(20);
		isConnectedTF= new JTextField(20);
		
		setBorder(statusBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 100;
		gc.insets = new Insets(0,5,10,10);
		add(isConnectedLabel,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0,-12,10,10);
		add(currentServerLabel,gc);
		
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0,-5,10,10);
		add(currentChannelLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0,-80,10,10);
		add(currentServerTF,gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(isConnectedTF,gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.insets = new Insets(0,-80,10,10);
		add(currentChannelTF,gc);
	}
	//getters
	public JLabel getCurrentServerLabel()
	{
		return currentServerLabel;
	}
	public JLabel getCurrentChannelLabel()
	{
		return currentChannelLabel;
	}
	public JLabel getIsConnectedLabel()
	{
		return isConnectedLabel;
	}
	public JTextField getCurrentChannelTF()
	{
		return currentChannelTF;
	}
	public JTextField getCurrentServerTF()
	{
		return currentServerTF;
	}
	public JTextField getIsConnectedTFd()
	{
		return isConnectedTF;
	}
	public TitledBorder getStatusBorder()
	{
		return statusBorder;
	}
	
	//setters
	public void setCurrentServerLabel(JLabel j)
	{
		currentServerLabel = j;
	}
	public void setCurrentChannelLabel(JLabel j)
	{
		currentChannelLabel = j;
	}
	public void setIsConnectedLabel(JLabel j)
	{
		isConnectedLabel = j;
	}
	public void setCurrentChannelTF(JTextField j)
	{
		currentChannelTF = j;
	}
	public void setCurrentServerTF(JTextField j)
	{
		currentServerTF = j;
	}
	public void setIsConnectedTFd(JTextField j)
	{
		isConnectedTF = j;
	}
	public void getStatusBorder(TitledBorder b)
	{
		statusBorder= b;
	}
	   
}
