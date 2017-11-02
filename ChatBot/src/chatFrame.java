import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class chatFrame extends JFrame implements ActionListener
{
	chatPanel cp;
	userSettingsPanel usp;
	onlineUsersPanel ou;
	
	public chatFrame()
	{
		cp = new chatPanel();
		usp = new userSettingsPanel();
		ou = new onlineUsersPanel();
		
		
		add(cp);
		add(usp);
		add(ou);
	}

	public void actionPerformed(ActionEvent e)
	{
		
		
	}
}
