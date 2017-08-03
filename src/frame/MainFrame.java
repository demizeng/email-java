package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public JTextField textField_server;
	public JTextField textField_port;
	public JTextField textField_user;
	public JPasswordField passwordField_password;

	/**
	 * Launch the application.
	 */
	public static void createMainFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon("./res/icon.png").getImage());
					frame.setTitle("简易电子邮件客户端");
					JOptionPane.showMessageDialog(frame, "登录成功！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 525, 371);
		contentPane.add(tabbedPane);
		tabbedPane.add("发送", new SendPanel(this));
		tabbedPane.add("接受", new ReceivePanel(this));
	}
}
