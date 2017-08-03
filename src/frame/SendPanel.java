package frame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import send.*;
import javax.swing.JScrollPane;

public class SendPanel extends JPanel {
	private JTextField textField_sender;
	private JTextField textField_receiver;
	private JTextField textField_subject;
	private JTextArea textArea_content;
	private MainFrame mf;
	
	/**
	 * Create the panel.
	 */
	public SendPanel(MainFrame mf) {
		this.mf = mf;
		setLayout(null);
		
		JLabel label = new JLabel("\u53D1\u4EF6\u4EBA \uFF1A");
		label.setBounds(33, 33, 67, 15);
		add(label);
		
		JLabel label_1 = new JLabel("\u6536\u4EF6\u4EBA \uFF1A");
		label_1.setBounds(33, 74, 67, 15);
		add(label_1);
		
		textField_sender = new JTextField();
		textField_sender.setText("wangbin@test.com");
		textField_sender.setBounds(110, 33, 289, 21);
		add(textField_sender);
		textField_sender.setColumns(10);
		
		textField_receiver = new JTextField();
		textField_receiver.setText("wangbin@test.com");
		textField_receiver.setColumns(10);
		textField_receiver.setBounds(110, 74, 289, 21);
		add(textField_receiver);
		
		JLabel label_2 = new JLabel("\u6807 \u9898 \uFF1A");
		label_2.setBounds(33, 112, 54, 15);
		add(label_2);
		
		textField_subject = new JTextField();
		textField_subject.setText("�����?");
		textField_subject.setBounds(110, 112, 289, 21);
		add(textField_subject);
		textField_subject.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5185 \u5BB9 \uFF1A");
		label_3.setBounds(33, 156, 54, 15);
		add(label_3);
		
		JButton button_send = new JButton("\u53D1\u9001\u90AE\u4EF6");
		button_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		         //�������Ҫ�������ʼ�  
			      MailSenderInfo mailInfo = new MailSenderInfo();   
			      mailInfo.setMailServerHost(UserInfo.host);
			      mailInfo.setMailServerPort(UserInfo.smtp_port);   
			      mailInfo.setValidate(true);   
			      mailInfo.setUserName(UserInfo.user);   
			      mailInfo.setPassword(UserInfo.password);//������������   
			      
			      mailInfo.setFromAddress(textField_sender.getText());   
			      mailInfo.setToAddress(textField_receiver.getText());   
			      mailInfo.setSubject(textField_subject.getText());   
			      mailInfo.setContent(textArea_content.getText().trim());   
			      /*
			      mailInfo.setMailServerHost("localhost");
			      mailInfo.setMailServerPort("25");
			      mailInfo.setValidate(true);
			      mailInfo.setUserName("wangbin@test.com");
			      mailInfo.setPassword("wangbin");
			      mailInfo.setFromAddress("wangbin@test.com");
			      mailInfo.setToAddress("wangbin@test.com");
			      mailInfo.setSubject("Here you are");
			      mailInfo.setContent("You are ready!");
			      */			      
			      //�������Ҫ�������ʼ�  
			      SimpleMailSender sms = new SimpleMailSender();  
			      if(sms.sendTextMail(mailInfo))//���������ʽ
			      {
			    	  JOptionPane.showMessageDialog(SendPanel.this, "�ʼ����ͳɹ���");
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(SendPanel.this, "�ʼ�����ʧ�ܣ�\n��鿴�û��������롢�ռ�����Ϣ�Ƿ���ȷ��");
			      }
			      //sms.sendHtmlMail(mailInfo);//����html��ʽ  
			}
		});
		button_send.setBounds(162, 296, 135, 25);
		add(button_send);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 156, 290, 130);
		add(scrollPane);
		
		textArea_content = new JTextArea();
		textArea_content.setText("�⼸�������е㲻�ã�����С��!");
		scrollPane.setViewportView(textArea_content);
	}
}
