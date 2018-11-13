package appmain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientMainForm extends JFrame
{
	
	public JButton b;
	public JTextField passWord;
	
	public ClientMainForm()
	{
		
		this.setTitle("Client");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(null);
		
		passWord = new JTextField();
		passWord.setEditable(false);
		passWord.setBounds(70,50,150,40);
		add(passWord);
		
		b = new JButton("Generate Password");
		b.setBounds(70,100,150,40);
		add(b);
		
		setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
		}
	}
}

