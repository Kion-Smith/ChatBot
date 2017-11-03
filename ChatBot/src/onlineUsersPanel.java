import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class onlineUsersPanel extends JPanel
{
	JLabel usersLabel;
	JList usersList;
	DefaultListModel listModel;
	JScrollPane listScroller;
	TitledBorder usersBorder;
	
	public onlineUsersPanel()
	{
		usersBorder =BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ONLINE USERS");
		usersBorder.setTitleJustification(TitledBorder.CENTER); 
		
		usersLabel = new JLabel("Users Online");
		
		listModel = new DefaultListModel();
		usersList = new JList(listModel);
		listScroller = new JScrollPane(usersList);
		
		setBorder(usersBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 250;
		gc.ipady = 450;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(5, 5, 5, 5);
        add(listScroller, gc);
		
	}
	public int getSize(String[] array)
	{
		return array.length;
	}
	public String getElement(String[] array, int i)
	{
		return array[i];
	}

	public JLabel getUsersLabel()
	{
		return usersLabel;
	}

	//setters
	public void setUsersLabel(JLabel j)
	{
		usersLabel = j;
	}
	
}
