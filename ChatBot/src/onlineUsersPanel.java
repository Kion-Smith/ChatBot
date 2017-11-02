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
		usersTextArea= new JTextArea();
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
