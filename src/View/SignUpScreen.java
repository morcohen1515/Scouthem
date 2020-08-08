package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;

public class SignUpScreen extends JFrame{

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JButton signUpButtonMenu;
	private JButton signUpButtonAction;
	private JButton signInButton;
	private JTextField scoutNameValue;
	private JTextField scoutIdValue;
	private JTextField scoutTeamNameValue;
	private JTextField playerNameValue;
	private JTextField playerIdValue;
	private JTextField playerTeamNameValue;
	private JLabel errorMessage;
	private JSpinner userTypeValue;
	private JSpinner playerAgeSpinner;
	private JSpinner heightSpinner;
	private JSpinner weightSpinner;
	private JSpinner roleSpinner;
	private JTextField mailValue;

	public SignUpScreen() {
		System.out.println("Created sign up screen");
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
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setFont(new Font("Arial", Font.PLAIN, 20));
		errorMessage.setBounds(394, 458, 279, 47);
		panel.add(errorMessage);
		
		signUpButtonMenu = new JButton("");
		signUpButtonMenu.setIcon(new ImageIcon(SignUpScreen.class.getResource("/view/res/signUpSelected.png")));
		signUpButtonMenu.setContentAreaFilled(false);
		signUpButtonMenu.setBorderPainted(false);
		signUpButtonMenu.setBorder(null);
		signUpButtonMenu.setBounds(607, 33, 112, 47);
		panel.add(signUpButtonMenu);
		
		signInButton = new JButton("");
		signInButton.setOpaque(false);
		signInButton.setContentAreaFilled(false);
		signInButton.setBorderPainted(false);
		signInButton.setBorder(null);
		signInButton.setIcon(new ImageIcon(SignUpScreen.class.getResource("/view/res/signInUnselected.png")));
		signInButton.setBounds(542, 33, 112, 47);
		panel.add(signInButton);
		
		userName = new JTextField();
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userName.setText("");
			}
		});
		
		signUpButtonAction = new JButton("");
		signUpButtonAction.setOpaque(false);
		signUpButtonAction.setContentAreaFilled(false);
		signUpButtonAction.setBorderPainted(false);
		signUpButtonAction.setBorder(null);
		signUpButtonAction.setIcon(new ImageIcon(SignUpScreen.class.getResource("/view/res/SIGNUP.png")));
		signUpButtonAction.setBounds(384, 411, 105, 34);
		panel.add(signUpButtonAction);
		userName.setBorder(null);
		userName.setOpaque(false);
		userName.setForeground(Color.LIGHT_GRAY);
		userName.setText("Enter Username");
		userName.setBounds(395, 141, 105, 34);
		panel.add(userName);
		userName.setColumns(10);
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userName.setText("");
			}
		});
		
		password = new JPasswordField();
		password.setText("Enter Password");
		password.setBorder(null);
		password.setOpaque(false);
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Arial", Font.PLAIN, 11));
		password.setBounds(395, 225, 112, 34);
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				password.setText("");
			}
		});
		panel.add(password);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(new Color(51, 204, 204));
		playerPanel.setForeground(Color.LIGHT_GRAY);
		playerPanel.setBounds(523, 118, 210, 327);
		panel.add(playerPanel);
		playerPanel.setLayout(null);
		playerPanel.setVisible(false);
		
		JPanel scoutPanel = new JPanel();
		scoutPanel.setBackground(new Color(51, 204, 204));
		scoutPanel.setBounds(523, 118, 210, 282);
		panel.add(scoutPanel);
		scoutPanel.setLayout(null);
		scoutPanel.setVisible(false);
		
		userTypeValue = new JSpinner();
		userTypeValue.setBorder(null);
		userTypeValue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (userTypeValue.getValue() == "Player")
				{
					scoutPanel.setVisible(false);
					playerPanel.setVisible(true);
				}
				else if (userTypeValue.getValue() == "Scout") 
				{
					playerPanel.setVisible(false);
					scoutPanel.setVisible(true);

				}
			}
		});
		userTypeValue.setModel(new SpinnerListModel(new String[] {"", "Player", "Scout"}));
		userTypeValue.setBounds(395, 313, 105, 20);
		panel.add(userTypeValue);
		
		JLabel userTypeTitle = new JLabel("User type");
		userTypeTitle.setForeground(Color.WHITE);
		userTypeTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		userTypeTitle.setBounds(395, 270, 105, 24);
		panel.add(userTypeTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordTitle.setForeground(Color.WHITE);
		passwordTitle.setBounds(395, 200, 105, 24);
		panel.add(passwordTitle);
		
		JLabel usernameTitle = new JLabel("Username");
		usernameTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameTitle.setForeground(Color.WHITE);
		usernameTitle.setBounds(395, 118, 105, 24);
		panel.add(usernameTitle);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(UIManager.getColor("window"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/loginRightSidee.png")));
		lblNewLabel_1.setBounds(340, 0, 420, 543);
		panel.add(lblNewLabel_1);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SignInScreen.class.getResource("/view/res/leftSideLogin.png")));
		lblNewLabel.setBounds(0, 0, 420, 543);
		panel.add(lblNewLabel);
		
		
		playerAgeSpinner = new JSpinner();
		playerAgeSpinner.setModel(new SpinnerNumberModel(9, 9, 18, 1));
		playerAgeSpinner.setBorder(null);
		playerAgeSpinner.setBounds(64, 84, 131, 20);
		playerPanel.add(playerAgeSpinner);
		
		JLabel playerTeamTitle = new JLabel("Team");
		playerTeamTitle.setForeground(Color.WHITE);
		playerTeamTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		playerTeamTitle.setBounds(10, 150, 61, 24);
		playerPanel.add(playerTeamTitle);
		
		JLabel ageTitle = new JLabel("Age");
		ageTitle.setForeground(Color.WHITE);
		ageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		ageTitle.setBounds(10, 79, 44, 24);
		playerPanel.add(ageTitle);
		
		JLabel heightTitle = new JLabel("Height");
		heightTitle.setForeground(Color.WHITE);
		heightTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		heightTitle.setBounds(10, 257, 71, 24);
		playerPanel.add(heightTitle);
		
		JLabel weightTitle = new JLabel("Weight");
		weightTitle.setForeground(Color.WHITE);
		weightTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		weightTitle.setBounds(10, 292, 71, 24);
		playerPanel.add(weightTitle);
		
		heightSpinner = new JSpinner();
		heightSpinner.setModel(new SpinnerNumberModel(100, 100, 200, 1));
		heightSpinner.setBorder(null);
		heightSpinner.setBounds(90, 257, 105, 20);
		playerPanel.add(heightSpinner);
		
		weightSpinner = new JSpinner();
		weightSpinner.setModel(new SpinnerNumberModel(35, 35, 100, 1));
		weightSpinner.setBorder(null);
		weightSpinner.setBounds(88, 292, 107, 20);
		playerPanel.add(weightSpinner);
		
		JLabel idTitle = new JLabel("ID");
		idTitle.setForeground(Color.WHITE);
		idTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		idTitle.setBounds(10, 43, 30, 24);
		playerPanel.add(idTitle);
		
		JLabel nameTitle = new JLabel("Name");
		nameTitle.setForeground(Color.WHITE);
		nameTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		nameTitle.setBounds(10, 11, 61, 24);
		playerPanel.add(nameTitle);
		
		JLabel roleTitle = new JLabel("Role");
		roleTitle.setForeground(Color.WHITE);
		roleTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		roleTitle.setBounds(10, 185, 61, 24);
		playerPanel.add(roleTitle);
		
		roleSpinner = new JSpinner();
		roleSpinner.setModel(new SpinnerListModel(new String[] {"Goalkeeper", "Centre-back", "Sweeper", "Full-back", "Wing-back", "Centre midfield", "Defensive midfield", "Attacking midfield", "Wide midfield", "Centre forward", "Second striker", "Winger"}));
		roleSpinner.setBorder(null);
		roleSpinner.setBounds(64, 185, 129, 20);
		playerPanel.add(roleSpinner);
		
		playerNameValue = new JTextField();
		playerNameValue.setBorder(null);
		playerNameValue.setText("Enter Name");
		playerNameValue.setBounds(64, 16, 131, 20);
		playerPanel.add(playerNameValue);
		playerNameValue.setColumns(10);
		playerNameValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				playerNameValue.setText("");
			}
		});
		
		playerIdValue = new JTextField();
		playerIdValue.setText("ID Number");
		playerIdValue.setColumns(10);
		playerIdValue.setBorder(null);
		playerIdValue.setBounds(64, 48, 131, 20);
		playerPanel.add(playerIdValue);
		playerIdValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				playerIdValue.setText("");
			}
		});
		
		playerTeamNameValue = new JTextField();
		playerTeamNameValue.setText("Enter Team name");
		playerTeamNameValue.setColumns(10);
		playerTeamNameValue.setBorder(null);
		playerTeamNameValue.setBounds(71, 154, 124, 20);
		playerPanel.add(playerTeamNameValue);
		
		JLabel mailTitle = new JLabel("E-Mail");
		mailTitle.setForeground(Color.WHITE);
		mailTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		mailTitle.setBounds(10, 114, 61, 24);
		playerPanel.add(mailTitle);
		
		mailValue = new JTextField();
		mailValue.setText("Enter E-Mail");
		mailValue.setColumns(10);
		mailValue.setBorder(null);
		mailValue.setBounds(74, 115, 121, 20);
		playerPanel.add(mailValue);
		mailValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mailValue.setText("");
			}
		});
		playerTeamNameValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				playerTeamNameValue.setText("");
			}
		});
		
				
		JLabel scoutNameTitle = new JLabel("Name");
		scoutNameTitle.setForeground(Color.WHITE);
		scoutNameTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		scoutNameTitle.setBounds(10, 11, 63, 24);
		scoutPanel.add(scoutNameTitle);
		
		scoutNameValue = new JTextField();
		scoutNameValue.setBorder(null);
		scoutNameValue.setText("Enter Name");
		scoutNameValue.setBounds(79, 16, 121, 20);
		scoutPanel.add(scoutNameValue);
		scoutNameValue.setColumns(10);
		scoutNameValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				scoutNameValue.setText("");
			}
		});
		
		scoutIdValue = new JTextField();
		scoutIdValue.setBorder(null);
		scoutIdValue.setText("ID Number");
		scoutIdValue.setColumns(10);
		scoutIdValue.setBounds(79, 51, 121, 20);
		scoutPanel.add(scoutIdValue);
		scoutIdValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				scoutIdValue.setText("");
			}
		});
		
		JLabel scoutIdTitle = new JLabel("ID");
		scoutIdTitle.setForeground(Color.WHITE);
		scoutIdTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		scoutIdTitle.setBounds(10, 47, 105, 24);
		scoutPanel.add(scoutIdTitle);
		
		JLabel scoutTeamTitle = new JLabel("Team");
		scoutTeamTitle.setForeground(Color.WHITE);
		scoutTeamTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		scoutTeamTitle.setBounds(10, 82, 105, 24);
		scoutPanel.add(scoutTeamTitle);
		
		scoutTeamNameValue = new JTextField();
		scoutTeamNameValue.setBorder(null);
		scoutTeamNameValue.setText("Enter Team name");
		scoutTeamNameValue.setColumns(10);
		scoutTeamNameValue.setBounds(79, 82, 121, 20);
		scoutTeamNameValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				scoutTeamNameValue.setText("");
			}
		});
		scoutPanel.add(scoutTeamNameValue);
		scoutPanel.setVisible(false);
		playerPanel.setVisible(false);
	}
	public void setWindowVisible(boolean flag) {
		this.setVisible(flag);
	}
	public String getPlayerEmail() {
		return mailValue.getText();
	}
	public String getUserType() {
		return (String) userTypeValue.getValue();
	}
	public String getUserName() {
		return userName.getText();
	}
	public String getPassword() {
		return password.getText();
	}
	public String getPlayerName() {
		return playerNameValue.getText();
	}
	public String getScoutName() {
		return scoutNameValue.getText();
	}
	public String getPlayerId() {
		return playerIdValue.getText();
	}
	public String getScoutId() {
		return scoutIdValue.getText();
	}
	public String getPlayerTeamName(){
		return playerTeamNameValue.getText();
	}
	public String getScoutTeamName() {
		return scoutTeamNameValue.getText();
	}
	public int getPlayerWeight() {
		return (int) weightSpinner.getValue();
	}
	public int getPlayerHeight() {
		return (int) heightSpinner.getValue();
	}
	public int getPlayerAge() {
		return (int) playerAgeSpinner.getValue();
	}
	public String getPlayerRole() {
		return (String) roleSpinner.getValue();
	}
	public void addSignUpActionListner(ActionListener signUpActionListner) {
		signUpButtonAction.addActionListener(signUpActionListner);
	}
	public void addSignInActionListner(ActionListener signInActionListner) {
		signInButton.addActionListener(signInActionListner);
	}
	public void setErrorMessage(String messageToDisplay) {
		errorMessage.setText(messageToDisplay);
	}
}
