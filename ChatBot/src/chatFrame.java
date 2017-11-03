import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class chatFrame extends JFrame implements ActionListener
{
	chatPanel cp;
	userSettingsPanel usp;
	onlineUsersPanel ou;
	statusPanel sp;
	
	public chatFrame()
	{
		cp = new chatPanel();
		usp = new userSettingsPanel();
		ou = new onlineUsersPanel();
		sp = new statusPanel();
		
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx =0;
		gc.gridy =0;
		gc.ipadx=180;
		gc.ipady = 70;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 10, 0, 10);
		add(cp,gc);

		gc.gridx =0;
		gc.gridy =1;
		gc.gridwidth = 2;
		gc.ipadx = 0;
		gc.ipady  = -10;
		add(usp,gc);

		gc.gridx =1;
		gc.gridy =0;
		add(ou,gc);
		
		gc.gridx =1;
		gc.gridy =1;
		add(sp,gc);
	}

	public void actionPerformed(ActionEvent e)
	{
		
		
	}
}
