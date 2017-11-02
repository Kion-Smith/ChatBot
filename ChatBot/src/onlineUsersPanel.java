import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class onlineUsersPanel extends JPanel
{
	JLabel usersLabel;
	JTextArea usersTextArea;
	public onlineUsersPanel()
	{
		usersLabel = new JLabel("Users Online");
		usersTextArea= new JTextArea(5,40);
		
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx =0;
		gc.gridy =0;
		add(usersLabel,gc);
		
		gc.gridx =0;
		gc.gridy =1;
		add(usersTextArea,gc);
		
	}

	public JLabel getUsersLabel()
	{
		return usersLabel;
	}
	public JTextArea getUsersTextArea()
	{
		return usersTextArea;
	}
	//setters
	public void setUsersLabel(JLabel j)
	{
		usersLabel = j;
	}
	public void setUsersTextArea(JTextArea j)
	{
		usersTextArea = j;
	}
}
