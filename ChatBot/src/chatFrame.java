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
	
	public chatFrame()
	{
		cp = new chatPanel();
		usp = new userSettingsPanel();
		ou = new onlineUsersPanel();
		
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		//gc.fill = GridBagConstraints.BOTH;
		//gc.anchor =GridBagConstraints.FIRST_LINE_START;
		gc.gridx =0;
		gc.gridy =0;
		gc.ipadx=29;
		gc.anchor = GridBagConstraints.NORTHWEST;
	    gc.insets = new Insets(11, 10, 0, 0);
		add(cp,gc);
		
		gc.gridx =0;
		gc.gridy =1;
		gc.gridwidth = 2;
		gc.ipadx = 24;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(21, 10, 11, 10);
		add(usp,gc);
		
		gc.anchor =GridBagConstraints.FIRST_LINE_END;
		gc.gridx =1;
		gc.gridy =0;
		gc.ipadx = 101;
		gc.ipady = -15;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(11, 6, 0, 10);
		add(ou,gc);
	}

	public void actionPerformed(ActionEvent e)
	{
		
		
	}
}
