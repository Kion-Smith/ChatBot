import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class statusPanel extends JPanel 
{
	JLabel currentServerLabel,isConnectedLabel,currentChannelLabel;
	JTextField currentServerTF,isConnectedTF,currentChannelTF;
	Border sortingBorder;
	public statusPanel()
	{
		Border sortingBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "STATUS");
		
		currentServerLabel = new JLabel("Current Server");
		currentChannelLabel = new JLabel("Current Channel");
		isConnectedLabel = new JLabel("Connection Status");
		
		currentChannelTF= new JTextField(20);
		currentServerTF= new JTextField(20);
		isConnectedTF= new JTextField(20);
		
		setBorder(sortingBorder);
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
}
