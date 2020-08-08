package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.Player;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;

public class PlayerScreen extends JFrame {

	private JPanel contentPane;
	private JButton signOutButton;
	private JButton addGameButton;

	public PlayerScreen(Player myPlayer) {
		System.out.println("Created player screen");
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
		
		JLabel playingNum = new JLabel(String.valueOf(myPlayer.getTotalPlayingTime()));
		playingNum.setForeground(Color.WHITE);
		playingNum.setFont(new Font("Arial", Font.BOLD, 15));
		playingNum.setBounds(522, 82, 96, 34);
		panel.add(playingNum);
		
		JLabel heightTitle = new JLabel("Height");
		heightTitle.setForeground(Color.WHITE);
		heightTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		heightTitle.setBounds(38, 188, 66, 35);
		panel.add(heightTitle);
		
		JLabel weightTitle = new JLabel("Weight");
		weightTitle.setForeground(Color.WHITE);
		weightTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		weightTitle.setBounds(38, 170, 66, 23);
		panel.add(weightTitle);
		
		JLabel ageTitle = new JLabel("Age");
		ageTitle.setForeground(Color.WHITE);
		ageTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		ageTitle.setBounds(38, 140, 66, 28);
		panel.add(ageTitle);
		
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
		
		addGameButton = new JButton("");
		addGameButton.setContentAreaFilled(false);
		addGameButton.setBorderPainted(false);
		addGameButton.setBorder(null);
		addGameButton.setOpaque(false);
		addGameButton.setBounds(617, 464, 101, 35);
		panel.add(addGameButton);
		addGameButton.setIcon(new ImageIcon(PlayerScreen.class.getResource("/view/res/addGameButton.png")));
		
		JLabel playerName = new JLabel(myPlayer.getPlayerName());
		playerName.setForeground(Color.WHITE);
		playerName.setFont(new Font("Arial", Font.BOLD, 37));
		playerName.setBounds(38, 32, 292, 43);
		panel.add(playerName);
		
		JLabel teamName = new JLabel(myPlayer.getMyTeam().getTeamName());
		teamName.setForeground(Color.WHITE);
		teamName.setFont(new Font("Arial", Font.PLAIN, 20));
		teamName.setBounds(35, 109, 226, 35);
		panel.add(teamName);
		
		JLabel playerAge = new JLabel(String.valueOf(myPlayer.getAge()));
		playerAge.setForeground(Color.WHITE);
		playerAge.setFont(new Font("Arial", Font.PLAIN, 17));
		playerAge.setBounds(117, 150, 55, 14);
		panel.add(playerAge);
		
		JLabel gameStats = new JLabel("Game Statistics");
		gameStats.setForeground(Color.WHITE);
		gameStats.setBounds(387, 32, 196, 43);
		panel.add(gameStats);
		gameStats.setFont(new Font("Arial", Font.BOLD, 25));
		
		signOutButton = new JButton("");
		signOutButton.setContentAreaFilled(false);
		signOutButton.setBorderPainted(false);
		signOutButton.setBorder(null);
		signOutButton.setOpaque(false);
		signOutButton.setIcon(new ImageIcon(PlayerScreen.class.getResource("/view/res/signOutButton.png")));
		signOutButton.setBounds(624, 13, 107, 47);
		panel.add(signOutButton);
		
		JLabel totalPlayingTime = new JLabel("Total playing time");
		totalPlayingTime.setFont(new Font("Arial", Font.PLAIN, 16));
		totalPlayingTime.setForeground(Color.WHITE);
		totalPlayingTime.setBounds(387, 86, 146, 35);
		panel.add(totalPlayingTime);
		
		JLabel goalsNum = new JLabel(String.valueOf(myPlayer.getGoals()));
		goalsNum.setFont(new Font("Arial", Font.BOLD, 15));
		goalsNum.setForeground(Color.WHITE);
		goalsNum.setBounds(463, 141, 96, 34);
		panel.add(goalsNum);
		
		JLabel yellowCards = new JLabel(String.valueOf(myPlayer.getYellowCard()));
		yellowCards.setForeground(Color.WHITE);
		yellowCards.setFont(new Font("Arial", Font.BOLD, 15));
		yellowCards.setBounds(463, 288, 55, 23);
		panel.add(yellowCards);
		
		JLabel redCards = new JLabel(String.valueOf(myPlayer.getRedCard()));
		redCards.setFont(new Font("Arial", Font.BOLD, 15));
		redCards.setForeground(Color.WHITE);
		redCards.setBounds(463, 320, 46, 14);
		panel.add(redCards);
		
		JLabel assistsCount = new JLabel(String.valueOf(myPlayer.getNumOfAssists()));
		assistsCount.setFont(new Font("Arial", Font.BOLD, 15));
		assistsCount.setForeground(Color.WHITE);
		assistsCount.setBounds(463, 186, 96, 41);
		panel.add(assistsCount);
		
		JLabel playerHeight = new JLabel(String.valueOf(myPlayer.getHeight()));
		playerHeight.setForeground(Color.WHITE);
		playerHeight.setFont(new Font("Arial", Font.PLAIN, 17));
		playerHeight.setBounds(117, 198, 46, 14);
		panel.add(playerHeight);
		
		JLabel playerWeight = new JLabel(String.valueOf(myPlayer.getWeight()));
		playerWeight.setForeground(Color.WHITE);
		playerWeight.setFont(new Font("Arial", Font.PLAIN, 17));
		playerWeight.setBounds(117, 175, 46, 14);
		panel.add(playerWeight);
		
		JLabel playerPosition = new JLabel(myPlayer.getRole());
		playerPosition.setFont(new Font("Arial", Font.PLAIN, 20));
		playerPosition.setForeground(Color.WHITE);
		playerPosition.setBounds(38, 86, 196, 23);
		panel.add(playerPosition);
		
		JLabel rightSideBg = new JLabel("");
		rightSideBg.setIcon(new ImageIcon(PlayerScreen.class.getResource("/view/res/basicRightBG.png")));
		rightSideBg.setBounds(340, 0, 420, 532);
		panel.add(rightSideBg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 412, 534);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PlayerScreen.class.getResource("/view/res/basicLeftBG.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public void setWindowVisible(boolean flag) {
		this.setVisible(flag);
	}
	public void addSignOutListener(ActionListener signOutButtonListner) {
		signOutButton.addActionListener(signOutButtonListner);
	}
	public void addGameListener(ActionListener addGameButtonListner) {
		addGameButton.addActionListener(addGameButtonListner);
	}
}
