/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 *  status panel class
 *  	-creates all elements inside status panel
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class statusPanel extends JPanel 
{
	//all elements for panel
	private JLabel currentServerLabel,isConnectedLabel,currentChannelLabel;
	private JTextField currentServerTF,isConnectedTF,currentChannelTF;
	private TitledBorder statusBorder;
	
	public statusPanel()
	{
		//Instantiate border
		statusBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "STATUS");
		
		//Instantiate label
		currentServerLabel = new JLabel("Current Server");
		currentChannelLabel = new JLabel("Current Channel");
		isConnectedLabel = new JLabel("Connection Status");
		
		//Instantiate text field
		currentChannelTF= new JTextField(20);
		currentServerTF= new JTextField(20);
		isConnectedTF= new JTextField(20);
		
		//set default text to fields
		currentChannelTF.setText("No Channel");
		currentServerTF.setText("No Server");
		isConnectedTF.setText("Offline");
		
		//make text fields uneditable
		currentChannelTF.setEditable(false);
		currentServerTF.setEditable(false);
		isConnectedTF.setEditable(false);
		
		//set border and layout
		setBorder(statusBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		//add connection label
		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 100;
		gc.insets = new Insets(0,5,10,10);
		add(isConnectedLabel,gc);
		
		//add currentserrver label
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0,-12,10,10);
		add(currentServerLabel,gc);
		
		//add currentchanel label
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0,-5,10,10);
		add(currentChannelLabel,gc);
		
		//add  connected textfield
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0,-80,10,10);
		add(isConnectedTF,gc);
		
		//add  currentserver textfield
		gc.gridx = 1;
		gc.gridy = 1;
		add(currentServerTF,gc);
		
		//add  currentchannel textfield
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
