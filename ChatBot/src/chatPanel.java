/*Name: Kion Smith
 * NetID: kls160430
 * CS2336-502
 * 
 * 
 *  chat panel class
 *  	-creates everything inside the chat box
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class chatPanel extends JPanel
{
	//all elements for panel
	private JButton sendButton, clearButton;
	private JTextArea chatBoxTextArea,messageTextArea;
	private JScrollPane chatScrollPane,messageScrollPane;//add setters and getters
	private TitledBorder chatBorder;
	
	public chatPanel()
	{
		//instantiates button
		sendButton = new JButton("SEND");
		clearButton = new JButton("CLEAR");
		
		//instantiates textareas
		chatBoxTextArea = new JTextArea(5,20);
		messageTextArea= new JTextArea(5,20);
		
		//instantiates scroll pane
		chatScrollPane = new JScrollPane(chatBoxTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		messageScrollPane = new JScrollPane(messageTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//instantiates border
		chatBorder = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "CHATROOM");

		//add line wrap to textarea, and set chat box to uneditable
		chatBoxTextArea.setEditable(false);
		chatBoxTextArea.setLineWrap(true);
		messageTextArea.setLineWrap(true);
		
		//set layout
		setBorder(chatBorder);
		setLayout(new GridBagLayout() );
		GridBagConstraints gc = new GridBagConstraints();
		
		//Add chatScrollPane
		//set location within the panel
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTHWEST;//set anchor
		gc.fill = GridBagConstraints.BOTH;//set fill
		gc.weightx = 1;//set weight
		gc.weighty = 1;
		gc.ipadx=300;//set padding
		gc.ipady =240;
		gc.insets = new Insets(15,15,0,0);//create insets space
		add(chatScrollPane,gc);

		//Add messageScrollPane
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.ipadx = 300;
		gc.ipady = 50;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(15, 15, 15, 0);
		add(messageScrollPane, gc);
		
		//Add sendButton
		gc.fill = GridBagConstraints.REMAINDER;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.ipadx = 56;
		gc.ipady = 50;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(40, 50, -40, -50);
		add(sendButton, gc);
		
		//Add clearButton
		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 50;
		gc.ipady = 5;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(290, 50, -290, -50);
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
	public JScrollPane getChatScrollPane()
	{
		return chatScrollPane;
	}
	public JScrollPane getMessageScrollPane()
	{
		return messageScrollPane;
	}
	public TitledBorder getChatBorder()
	{
		return chatBorder;
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
	
	public void setChatScrollPane(JScrollPane j)
	{
		chatScrollPane = j;
	}
	public void setMessageScrollPane(JScrollPane j)
	{
		messageScrollPane = j;
	}
	public void setChatBorder(TitledBorder b)
	{
		chatBorder =b;
	}
}
