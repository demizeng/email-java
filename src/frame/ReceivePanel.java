package frame;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import receive.ReciveMail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

public class ReceivePanel extends JPanel {
	private MainFrame mf;	
	public RPG rpg;
	/**
	 * Create the panel.
	 */
	public ReceivePanel(MainFrame mf) {
		this.mf = mf;
		setLayout(null);
		
		JButton button_flush = new JButton("\u5237\u65B0\u90AE\u4EF6\u5217\u8868");
		button_flush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flushPanel();
			}
		});
		button_flush.setBounds(10, 10, 117, 25);
		add(button_flush);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 450, 250);
		add(scrollPane);
		
		rpg = new RPG();
		scrollPane.add(rpg);
		rpg.setVisible(true);
		//flushPanel();
	}
	
	public void flushPanel()
	{
		rpg.flushList();
	}
}
