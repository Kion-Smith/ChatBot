import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class onlineUsersPanel extends JPanel
{
	private JLabel usersLabel;
	private JScrollPane userScrollPane;
	private TitledBorder usersBorder;
	private JTextArea usersOnline;
	
	public onlineUsersPanel()
	{
		usersBorder =BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ONLINE USERS");
		usersBorder.setTitleJustification(TitledBorder.CENTER); 
		
		usersLabel = new JLabel("Users Online");
		
		usersOnline = new JTextArea(5,20);
		usersOnline.setEditable(false);
		userScrollPane = new JScrollPane(usersOnline);
		
		//userScrollPane = new JScrollPane(usersList);
		
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
        add(userScrollPane, gc);
		
	}
	
	public JLabel getUsersLabel()
	{
		return usersLabel;
	}
	public TitledBorder getUsersBorder()
	{
		return usersBorder;
	}
	public JScrollPane getUserScrollPane()
	{
		return userScrollPane;
	}
	public JTextArea getUsersOnline()
	{
		return usersOnline;
	}
	

	//setters
	public void setUsersLabel(JLabel j)
	{
		usersLabel = j;
	}
	public void setUsersBorder(TitledBorder b)
	{
		usersBorder =b;
	}
	public void setUserScrollPane(JScrollPane j)
	{
		userScrollPane = j;
	}
	public void setUsersOnline(JTextArea j)
	{
		 usersOnline =j;
	}

	
	
}
