package frame;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import receive.ReciveMail;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

public class RPG extends JPanel {

	/**
	 * Create the panel.
	 */
	JList list ;
	JTextArea textArea;
	
	public RPG() {
		setLayout(null);
		setBounds(0, 0, 497, 276);
		setVisible(true);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 450, 250);
		splitPane.setDividerLocation(100);
		add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Properties props = new Properties();
		        Session session = Session.getDefaultInstance(props);
		        URLName urlname = new URLName("pop3", UserInfo.host,
		        		Integer.parseInt(UserInfo.pop3_port), null, UserInfo.user, UserInfo.password);
		        try{
			        Store store = session.getStore(urlname);
			        store.connect();
			        Folder folder = store.getFolder("INBOX");
			        folder.open(Folder.READ_ONLY);
			        Message msgs[] = folder.getMessages();
			        int count = msgs.length;
			        System.out.println("Message Count:"+count);
			        ReciveMail rm = null;
			        StringBuffer sb = new StringBuffer();
			        int i = list.getSelectedIndex(); 
			        rm = new ReciveMail( (MimeMessage)(msgs[i]) );
			        sb.append(rm.recive(msgs[i],i));
			        folder.close(true);
			        store.close();
			        RPG.this.textArea.setText(sb.toString());
		        }catch(Exception e){
		        	e.printStackTrace();
		        }	
			}
		});
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

	}
	
	public void flushList()
	{
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props);
        URLName urlname = new URLName("pop3", UserInfo.host,
        		Integer.parseInt(UserInfo.pop3_port), null, UserInfo.user, UserInfo.password);
        try{
	        Store store = session.getStore(urlname);
	        store.connect();
	        Folder folder = store.getFolder("INBOX");
	        folder.open(Folder.READ_ONLY);
	        Message msgs[] = folder.getMessages();
	        int count = msgs.length;
	        System.out.println("Message Count:"+count);
	        ReciveMail rm = null;
	        StringBuffer sb = new StringBuffer();
	        DefaultListModel dlm = new DefaultListModel();
	        
	        for(int i=0;i<count;i++){
	            rm = new ReciveMail((MimeMessage) msgs[i]);
	            dlm.add(i, rm.getSubject());
	        }
	        list.setModel(dlm);
	        folder.close(true);
	        store.close();
	        JOptionPane.showMessageDialog(RPG.this, "邮件列表更新成功！");
        }catch(Exception e){
        	e.printStackTrace();
        }		
	}
}
