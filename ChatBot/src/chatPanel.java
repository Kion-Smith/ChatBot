import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class chatPanel extends JPanel
{
	JButton sendButton, clearButton;
	JTextArea chatBoxTextArea,messageTextArea;
	
	public chatPanel()
	{
		sendButton = new JButton("SEND");
		clearButton = new JButton("CLEAR");
		chatBoxTextArea = new JTextArea();
		messageTextArea= new JTextArea();
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
