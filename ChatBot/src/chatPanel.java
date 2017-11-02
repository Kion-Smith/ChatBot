import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class chatPanel extends JPanel
{
	JButton sendButton, clearButton;
	JTextArea chatBoxTextArea,messageTextArea;
	JScrollPane chatScrollPane,messageScrollPane;//add setters and getters
	Border sortingBorder;
	
	public chatPanel()
	{
		
		sendButton = new JButton("SEND");
		clearButton = new JButton("CLEAR");
		chatBoxTextArea = new JTextArea(5,20);
		messageTextArea= new JTextArea(5,20);
		chatScrollPane = new JScrollPane(chatBoxTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		messageScrollPane = new JScrollPane(messageTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sortingBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		chatBoxTextArea.setEditable(false);
		chatBoxTextArea.setLineWrap(true);
		messageTextArea.setLineWrap(true);
		
		setBorder(sortingBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
	
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.ipadx=309;
		gc.ipady =239;
		gc.insets = new Insets(13,12,0,0);
		add(chatScrollPane,gc);//problem
		
		//gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.ipadx = 309;
		gc.ipady = 49;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(11, 12, 13, 0);
		add(messageScrollPane, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.ipadx = 29;
		gc.ipady = 49;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(11, 6, 13, 12);
		add(sendButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 29;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(235, 6, 0, 12);
	    add(clearButton, gc);
		

	}
	//getters
	public JButton getSendButton()
	{
		return sendButton;
	}
	public JButton getClearButton()
	{
		return clearButton;
	}
	public JTextArea getChatBoxTextArea()
	{
		return chatBoxTextArea;
	}
	public JTextArea getMessageTextArea()
	{
		return messageTextArea;
	}
	//Setters
	public void setSendButton(JButton j)
	{
		 sendButton = j;
	}
	public void setClearButton(JButton j)
	{
		 clearButton=j;
	}
	public void setChatBoxTextArea(JTextArea j)
	{
		 chatBoxTextArea = j;
	}
	public void setMessageTextArea(JTextArea j)
	{
		 messageTextArea = j;
	}
}
