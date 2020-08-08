package View;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Model.Player;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

public class AddGameScreen extends JFrame {

	private JPanel contentPane;
	private JButton addButton; 
	private JButton backButton;
	private JSpinner goalsValue;
	private JSpinner assistsValue;
	private JSpinner totalPlayingTimeValue;
	private JCheckBox redCardValue;
	private JCheckBox yellowCardValue;

	public AddGameScreen(Player myPlayer) {
		System.out.println("Created add game screen");
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
		
		assistsValue = new JSpinner();
		assistsValue.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		assistsValue.setBorder(null);
		assistsValue.setBounds(527, 186, 45, 23);
		panel.add(assistsValue);
		
		goalsValue = new JSpinner();
		goalsValue.setModel(new SpinnerNumberModel(0, 0, 90, 1));
		goalsValue.setBorder(null);
		goalsValue.setBounds(527, 149, 45, 23);
		panel.add(goalsValue);
		
		redCardValue = new JCheckBox("");
		redCardValue.setContentAreaFilled(false);
		redCardValue.setBorder(null);
		redCardValue.setBounds(539, 322, 20, 23);
		panel.add(redCardValue);
		
		yellowCardValue = new JCheckBox("");
		yellowCardValue.setBorder(null);
		yellowCardValue.setContentAreaFilled(false);
		yellowCardValue.setBounds(539, 288, 20, 23);
		panel.add(yellowCardValue);
		
		totalPlayingTimeValue = new JSpinner();
		totalPlayingTimeValue.setBorder(null);
		totalPlayingTimeValue.setModel(new SpinnerNumberModel(1, 1, 90, 1));
		totalPlayingTimeValue.setBounds(539, 86, 45, 23);
		panel.add(totalPlayingTimeValue);
		
		JLabel gameStatsTitle = new JLabel("Game Statistics");
		gameStatsTitle.setForeground(Color.WHITE);
		gameStatsTitle.setBounds(387, 32, 196, 43);
		panel.add(gameStatsTitle);
		gameStatsTitle.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel totalPlayingTimeTitle = new JLabel("Total playing time");
		totalPlayingTimeTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		totalPlayingTimeTitle.setForeground(Color.WHITE);
		totalPlayingTimeTitle.setBounds(387, 86, 146, 35);
		panel.add(totalPlayingTimeTitle);
		
		JLabel redTitle = new JLabel("Red");
		redTitle.setForeground(Color.RED);
		redTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		redTitle.setBounds(387, 310, 66, 35);
		panel.add(redTitle);
		
		JLabel cardsTitle = new JLabel("Cards");
		cardsTitle.setForeground(Color.WHITE);
		cardsTitle.setFont(new Font("Arial", Font.BOLD, 16));
		cardsTitle.setBounds(387, 251, 66, 35);
		panel.add(cardsTitle);
		
		JLabel yellowCardsTitle = new JLabel("Yellow");
		yellowCardsTitle.setForeground(Color.YELLOW);
		yellowCardsTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		yellowCardsTitle.setBounds(387, 280, 66, 35);
		panel.add(yellowCardsTitle);
		
		JLabel assistsTitle = new JLabel("Assists");
		assistsTitle.setForeground(Color.WHITE);
		assistsTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		assistsTitle.setBounds(387, 186, 66, 35);
		panel.add(assistsTitle);
		
		JLabel goalsTitle = new JLabel("Goals");
		goalsTitle.setForeground(Color.WHITE);
		goalsTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		goalsTitle.setBounds(387, 140, 66, 35);
		panel.add(goalsTitle);
		
		addButton = new JButton("");
		addButton.setIcon(new ImageIcon(AddGameScreen.class.getResource("/view/res/addButton.png")));
		addButton.setOpaque(false);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		addButton.setBorder(null);
		addButton.setBounds(616, 475, 118, 35);
		panel.add(addButton);
		
		backButton = new JButton("");
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBorderPainted(false);
		backButton.setOpaque(false);
		backButton.setIcon(new ImageIcon(AddGameScreen.class.getResource("/view/res/backButton.png")));
		backButton.setBounds(25, 475, 118, 35);
		panel.add(backButton);
		
		JLabel addGameTitle = new JLabel("Add Game");
		addGameTitle.setForeground(Color.WHITE);
		addGameTitle.setFont(new Font("Arial", Font.BOLD, 38));
		addGameTitle.setBounds(53, 54, 194, 35);
		panel.add(addGameTitle);
		JLabel rightSideBG = new JLabel("");
		rightSideBG.setIcon(new ImageIcon(AddGameScreen.class.getResource("/view/res/basicRightBG.png")));
		rightSideBG.setBounds(340, 0, 420, 532);
		panel.add(rightSideBG);
		
		JLabel leftSideBG = new JLabel("");
		leftSideBG.setBounds(0, 0, 412, 534);
		panel.add(leftSideBG);
		leftSideBG.setIcon(new ImageIcon(AddGameScreen.class.getResource("/view/res/basicLeftBG.png")));
		leftSideBG.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public int getGoalsCount() {
		return (Integer)goalsValue.getValue();
	}
	public int getAssistsCount() {
		return (Integer)assistsValue.getValue();
	}
	public int gettotalPlayingTimeValue() {
		return (Integer)totalPlayingTimeValue.getValue();
	}
	public int getYellowCardCount() {
		if (yellowCardValue.isSelected()) {
			return 1;
		}
		return 0;
	}
	public int getRedCardCount() {
		if (redCardValue.isSelected()) {
			return 1;
		}
		return 0;
	}
	public void setWindowVisible(boolean flag) {
		this.setVisible(flag);
	}
	public void addAddGameListner(ActionListener addGameListner) {
		addButton.addActionListener(addGameListner);
	}
	public void addBackButtonListner(ActionListener backButtonListner) {
		backButton.addActionListener(backButtonListner);
	}
}
