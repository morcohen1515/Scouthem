package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;

public class SignInScreen extends JFrame{

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JLabel successMessage;
	private JButton loginButton;
	private JButton signUpButton;

	public SignInScreen() {
		System.out.println("Created login screen");
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 799, 568);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 840, 840);
		contentPane.add(panel);
		panel.setLayout(null);
		
		signUpButton = new JButton("");
		signUpButton.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/SIGNUP.png")));
		signUpButton.setContentAreaFilled(false);
		signUpButton.setBorderPainted(false);
		signUpButton.setBorder(null);
		signUpButton.setBounds(607, 33, 112, 47);
		panel.add(signUpButton);
		
		JButton signInButton = new JButton("");
		signInButton.setOpaque(false);
		signInButton.setContentAreaFilled(false);
		signInButton.setBorderPainted(false);
		signInButton.setBorder(null);
		signInButton.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/SIGNIN.png")));
		signInButton.setBounds(542, 33, 112, 47);
		panel.add(signInButton);
		
		loginButton = new JButton("");
		loginButton.setBackground(Color.WHITE);
		loginButton.setContentAreaFilled(false);
		loginButton.setForeground(Color.WHITE);
		loginButton.setOpaque(false);
		loginButton.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/SIGNIN1.png")));
		loginButton.setBorderPainted(false);
		loginButton.setBorder(null);
		loginButton.setBounds(376, 415, 135, 41);
		panel.add(loginButton);
		
		successMessage = new JLabel("");
		successMessage.setFont(new Font("Arial", Font.PLAIN, 18));
		successMessage.setForeground(Color.RED);
		successMessage.setBounds(395, 459, 204, 24);
		panel.add(successMessage);
		
		password = new JPasswordField();
		password.setText("Enter Password");
		password.setBorder(null);
		password.setOpaque(false);
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Arial", Font.PLAIN, 11));
		password.setBounds(395, 320, 325, 34);
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				password.setText("");
			}
		});
		panel.add(password);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(395, 365, 325, 3);
		panel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 188, 325, 3);
		panel.add(separator);
		
		userName = new JTextField();
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userName.setText("");
			}
		});
		userName.setBorder(null);
		userName.setOpaque(false);
		userName.setForeground(Color.LIGHT_GRAY);
		userName.setText("Enter Username");
		userName.setBounds(395, 143, 325, 34);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(395, 285, 105, 24);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(395, 118, 105, 24);
		panel.add(lblNewLabel_4);
		
		
		JLabel rightBackground = new JLabel("");
		rightBackground.setHorizontalAlignment(SwingConstants.CENTER);
		rightBackground.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/basicRightBG.png")));
		rightBackground.setBounds(340, 0, 420, 543);
		panel.add(rightBackground);
		

		JLabel leftBackground = new JLabel("");
		leftBackground.setHorizontalAlignment(SwingConstants.CENTER);
		leftBackground.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/leftSideLogin.png")));
		leftBackground.setBounds(0, 0, 420, 543);
		panel.add(leftBackground);
	}
	public String getUserName(){return userName.getText();}
	public String getPassword(){return password.getText();}
	public void setLoginMessage() {
			successMessage.setText("User doesn't exist");
	}
	public void addLoginListner(ActionListener loginButtonListner) {
		loginButton.addActionListener(loginButtonListner);

	}
	public void addSignUpListner(ActionListener signUpButtonListner) {
		signUpButton.addActionListener(signUpButtonListner);

	}
	public void setWindowVisible(boolean flag) {
		this.setVisible(flag);
	}
}
