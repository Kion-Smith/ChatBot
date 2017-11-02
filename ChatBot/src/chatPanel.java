import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		chatBoxTextArea = new JTextArea(40,20);
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
		add(clearButton,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(chatBoxTextArea, gc);
		
		gc.gridx =0;
		gc.gridy = 2;
		add(messageTextArea, gc);
		
		//gc.fill = gc.HORIZONTAL;
		gc.gridx = 1;
		gc.gridy = 1;
		add(chatScrollPane,gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(messageScrollPane,gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(sendButton, gc);

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
