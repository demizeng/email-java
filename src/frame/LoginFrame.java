package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLocalhost;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtWangbintestcom;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("简易邮件客户端_登录界面");
		
		JLabel label = new JLabel("\u90AE\u4EF6\u670D\u52A1\u5668 \uFF1A");
		label.setBounds(68, 30, 94, 15);
		contentPane.add(label);
		
		JLabel lblsmtp = new JLabel("smtp \u7AEF \u53E3 \uFF1A");
		lblsmtp.setBounds(68, 55, 94, 15);
		contentPane.add(lblsmtp);
		
		JLabel lblPop = new JLabel("pop3 \u7AEF \u53E3 \uFF1A");
		lblPop.setBounds(68, 83, 94, 15);
		contentPane.add(lblPop);
		
		JLabel label_3 = new JLabel("\u7528  \u6237  \u540D \uFF1A");
		label_3.setBounds(68, 112, 94, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u767B \u5F55 \u5BC6 \u7801\uFF1A");
		label_4.setBounds(68, 143, 94, 15);
		contentPane.add(label_4);
		
		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		txtLocalhost.setBounds(166, 27, 161, 21);
		contentPane.add(txtLocalhost);
		txtLocalhost.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("25");
		textField_1.setColumns(10);
		textField_1.setBounds(166, 52, 161, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("110");
		textField_2.setColumns(10);
		textField_2.setBounds(166, 80, 161, 21);
		contentPane.add(textField_2);
		
		txtWangbintestcom = new JTextField();
		txtWangbintestcom.setText("wangbin@test.com");
		txtWangbintestcom.setColumns(10);
		txtWangbintestcom.setBounds(166, 112, 161, 21);
		contentPane.add(txtWangbintestcom);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 140, 161, 21);
		passwordField.setText("wangbin");
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveUserInfo();
				MainFrame.createMainFrame();
				LoginFrame.this.dispose();
			}
		});
		button.setBounds(136, 177, 124, 25);
		contentPane.add(button);
	}
	
	public void saveUserInfo()
	{
		UserInfo.host = txtLocalhost.getText();
		UserInfo.smtp_port = textField_1.getText();
		UserInfo.pop3_port = textField_2.getText();
		UserInfo.user = txtWangbintestcom.getText();
		UserInfo.password = passwordField.getText();
	}
}
