package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import Model.Scout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

public class ScoutScreen extends JFrame {

	private JPanel contentPane;
	private JButton signOutButton;
	private JTable findPlayersTable;
	private JTable interestTable;
	private JButton findPlayersButton;
	private JButton showPlayersButton;
	private JButton addPlayerButton;
	private JPanel panel;
	private DefaultTableModel findPlayersModel;
	private DefaultTableModel interestPlayersModel;
	private JButton removePlayerButton;
	private JTextField teamNameField;
	private JTextField AgeField;
	private JSpinner roleSpinner;
	private JSpinner AgeSpinner;
	private JButton filterByTeamButton;
	private JButton filterByAgeButton;
	private JButton goalsSort;
	private JButton assistsButton;
	private JButton playingTimeButton;
	private JButton filterByRoleButton;
	private JLabel filterTitle;
	private	JLabel sortTitle;
	private JLabel messageArea;
	private JLabel nameColumn;
	private JLabel teamColumn;
	private JLabel roleColumn;
	private JLabel goalsColumn;
	private JLabel assistColumn;
	private JLabel playingTimeColumn;
	private JLabel idColumn;
	private JLabel yellowCards;
	private JLabel redCards;
	private JLabel ageColumn;

	public ScoutScreen(Scout myScouter) {
		System.out.println("Created scout screen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 799, 568);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 840, 840);
		contentPane.add(panel);
		panel.setLayout(null);
		
		signOutButton = new JButton("");
		signOutButton.setContentAreaFilled(false);
		signOutButton.setBorderPainted(false);
		signOutButton.setBorder(null);
		signOutButton.setOpaque(false);
		signOutButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/signOutButton.png")));
		signOutButton.setBounds(677, 11, 107, 47);
		
		ageColumn = new JLabel("Age");
		ageColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		ageColumn.setHorizontalAlignment(SwingConstants.CENTER);
		ageColumn.setForeground(Color.WHITE);
		ageColumn.setBounds(670, 168, 46, 14);
		ageColumn.setVisible(false);
		
		JLabel scoutTitle = new JLabel("Scout");
		scoutTitle.setForeground(Color.WHITE);
		scoutTitle.setFont(new Font("Arial", Font.BOLD, 18));
		scoutTitle.setBounds(29, 32, 153, 43);
		panel.add(scoutTitle);
		panel.add(ageColumn);
		
		redCards = new JLabel("Red");
		redCards.setHorizontalAlignment(SwingConstants.CENTER);
		redCards.setForeground(Color.RED);
		redCards.setFont(new Font("Arial", Font.PLAIN, 12));
		redCards.setBounds(615, 168, 46, 14);
		panel.add(redCards);
		
		yellowCards = new JLabel("Yellow");
		yellowCards.setHorizontalAlignment(SwingConstants.CENTER);
		yellowCards.setForeground(Color.YELLOW);
		yellowCards.setFont(new Font("Arial", Font.PLAIN, 12));
		yellowCards.setBounds(558, 168, 46, 14);
		panel.add(yellowCards);
		
		idColumn = new JLabel("ID");
		idColumn.setHorizontalTextPosition(SwingConstants.CENTER);
		idColumn.setHorizontalAlignment(SwingConstants.CENTER);
		idColumn.setForeground(Color.WHITE);
		idColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		idColumn.setBounds(720, 168, 61, 14);
		panel.add(idColumn);
		
		playingTimeColumn = new JLabel("Play time");
		playingTimeColumn.setVerticalAlignment(SwingConstants.TOP);
		playingTimeColumn.setHorizontalTextPosition(SwingConstants.CENTER);
		playingTimeColumn.setHorizontalAlignment(SwingConstants.CENTER);
		playingTimeColumn.setForeground(Color.WHITE);
		playingTimeColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		playingTimeColumn.setBounds(484, 168, 75, 20);
		panel.add(playingTimeColumn);
		
		assistColumn = new JLabel("Assists");
		assistColumn.setForeground(Color.WHITE);
		assistColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		assistColumn.setBounds(438, 168, 46, 14);
		panel.add(assistColumn);
		
		goalsColumn = new JLabel("Goals");
		goalsColumn.setForeground(Color.WHITE);
		goalsColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		goalsColumn.setBounds(386, 168, 46, 14);
		panel.add(goalsColumn);
		
		roleColumn = new JLabel("Role");
		roleColumn.setForeground(Color.WHITE);
		roleColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		roleColumn.setBounds(330, 168, 46, 14);
		panel.add(roleColumn);
		
		teamColumn = new JLabel("Team");
		teamColumn.setForeground(Color.WHITE);
		teamColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		teamColumn.setBounds(270, 168, 46, 14);
		panel.add(teamColumn);
		
		nameColumn = new JLabel("Name");
		nameColumn.setFont(new Font("Arial", Font.PLAIN, 12));
		nameColumn.setForeground(Color.WHITE);
		nameColumn.setBounds(210, 168, 46, 14);
		panel.add(nameColumn);
		
		messageArea = new JLabel("");
		messageArea.setHorizontalTextPosition(SwingConstants.CENTER);
		messageArea.setHorizontalAlignment(SwingConstants.CENTER);
		messageArea.setForeground(Color.WHITE);
		messageArea.setFont(new Font("Arial", Font.PLAIN, 16));
		messageArea.setBounds(370, 423, 268, 43);
		panel.add(messageArea);
		
		filterByTeamButton = new JButton("");
		filterByTeamButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/filterByTeamButton.png")));
		filterByTeamButton.setOpaque(false);
		filterByTeamButton.setContentAreaFilled(false);
		filterByTeamButton.setBorderPainted(false);
		filterByTeamButton.setBorder(null);
		filterByTeamButton.setBounds(625, 50, 90, 43);
		panel.add(filterByTeamButton);
		filterByTeamButton.setVisible(false);
		
		filterByRoleButton = new JButton("");
		filterByRoleButton.setOpaque(false);
		filterByRoleButton.setContentAreaFilled(false);
		filterByRoleButton.setBorder(null);
		filterByRoleButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/filterByRole.png")));
		filterByRoleButton.setBounds(625, 85, 90, 43);
		panel.add(filterByRoleButton);
		filterByRoleButton.setVisible(false);
				
		filterByAgeButton = new JButton("");
		filterByAgeButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/þþfilterByAgeButton.png")));
		filterByAgeButton.setOpaque(false);
		filterByAgeButton.setContentAreaFilled(false);
		filterByAgeButton.setBorderPainted(false);
		filterByAgeButton.setBorder(null);
		filterByAgeButton.setBounds(625, 120, 90, 43);
		panel.add(filterByAgeButton);
		filterByAgeButton.setVisible(false);
		
		teamNameField = new JTextField();
		teamNameField.setText("Team");
		teamNameField.setBounds(500, 62, 118, 20);
		panel.add(teamNameField);
		teamNameField.setColumns(10);
		teamNameField.setVisible(false);
		
		roleSpinner = new JSpinner();
		roleSpinner.setModel(new SpinnerListModel(new String[] {"Goalkeeper", "Centre-back", "Sweeper", "Full-back", "Wing-back", "Centre midfield", "Defensive midfield", "Attacking midfield", "Wide midfield", "Centre forward", "Second striker", "Winger"}));
		roleSpinner.setBorder(null);
		roleSpinner.setBounds(500, 98, 118, 20);
		panel.add(roleSpinner);
		roleSpinner.setVisible(false);
		
		AgeSpinner = new JSpinner();
		AgeSpinner.setModel(new SpinnerListModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
		AgeSpinner.setBorder(null);
		AgeSpinner.setBounds(500, 130, 118, 20);
		panel.add(AgeSpinner);
		AgeSpinner.setVisible(true);
		
		playingTimeButton = new JButton("");
		playingTimeButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/playingTimeButton.png")));
		playingTimeButton.setOpaque(false);
		playingTimeButton.setContentAreaFilled(false);
		playingTimeButton.setBorderPainted(false);
		playingTimeButton.setBorder(null);
		playingTimeButton.setBounds(300, 62, 118, 20);
		panel.add(playingTimeButton);
		playingTimeButton.setVisible(false);
		
		assistsButton = new JButton("");
		assistsButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/assistsButton.png")));
		assistsButton.setOpaque(false);
		assistsButton.setContentAreaFilled(false);
		assistsButton.setBorderPainted(false);
		assistsButton.setBorder(null);
		assistsButton.setBounds(300, 90, 118, 20);
		panel.add(assistsButton);
		assistsButton.setVisible(false);
		
		goalsSort = new JButton("");
		goalsSort.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/goalsButton.png")));
		goalsSort.setOpaque(false);
		goalsSort.setContentAreaFilled(false);
		goalsSort.setBorderPainted(false);
		goalsSort.setBorder(null);
		goalsSort.setBounds(300, 120, 118, 20);
		panel.add(goalsSort);
		goalsSort.setVisible(false);
		
		filterTitle = new JLabel("Filters:");
		filterTitle.setForeground(Color.WHITE);
		filterTitle.setFont(new Font("Arial", Font.BOLD, 16));
		filterTitle.setBounds(434, 39, 61, 19);
		panel.add(filterTitle);
		filterTitle.setVisible(false);
		
		
		sortTitle = new JLabel("Sort by:");
		sortTitle.setForeground(Color.WHITE);
		sortTitle.setFont(new Font("Arial", Font.BOLD, 16));
		sortTitle.setBounds(240, 39, 61, 19);
		panel.add(sortTitle);
		sortTitle.setVisible(false);
		
		removePlayerButton = new JButton("");
		removePlayerButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/removeButton.png")));
		removePlayerButton.setOpaque(false);
		removePlayerButton.setContentAreaFilled(false);
		removePlayerButton.setBorderPainted(false);
		removePlayerButton.setBorder(null);
		removePlayerButton.setBounds(224, 430, 107, 47);
		panel.add(removePlayerButton);
		removePlayerButton.setVisible(false);
		
		addPlayerButton = new JButton("");
		addPlayerButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/addButton.png")));
		addPlayerButton.setOpaque(false);
		addPlayerButton.setContentAreaFilled(false);
		addPlayerButton.setBorderPainted(false);
		addPlayerButton.setBorder(null);
		addPlayerButton.setBounds(662, 430, 107, 47);
		panel.add(addPlayerButton);
		addPlayerButton.setVisible(false);
		findPlayersModel = new DefaultTableModel();
		findPlayersTable = new JTable(findPlayersModel) 
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) 
			{                
                return false;               
            };
		};
		findPlayersTable.setSelectionBackground(Color.GREEN);
		findPlayersTable.setBackground(new Color(51, 204, 204));
		findPlayersTable.setForeground(Color.BLACK);
		findPlayersModel.addColumn("Name");
		findPlayersModel.addColumn("Team");
		findPlayersModel.addColumn("Role");
		findPlayersModel.addColumn("Goals");
		findPlayersModel.addColumn("Assists");
		findPlayersModel.addColumn("Playing time");
		findPlayersModel.addColumn("Yellow cards");
		findPlayersModel.addColumn("Red cards");
		findPlayersModel.addColumn("Age");
		findPlayersModel.addColumn("ID");
		findPlayersTable.setBorder(null);
		panel.add(findPlayersTable);		
		findPlayersTable.setVisible(false);
		
		interestPlayersModel = new DefaultTableModel();
		interestTable = new JTable(interestPlayersModel)
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) 
			{                
                return false;               
            };
		};
		interestTable.setSelectionBackground(Color.RED);
		interestTable.setBackground(new Color(51, 204, 204));
		interestTable.setForeground(Color.BLACK);
		interestTable.setBorder(null);
		interestPlayersModel.addColumn("Name");
		interestPlayersModel.addColumn("Team");
		interestPlayersModel.addColumn("Role");
		interestPlayersModel.addColumn("Goals");
		interestPlayersModel.addColumn("Assists");
		interestPlayersModel.addColumn("Playing time");
		interestPlayersModel.addColumn("Yellow cards");
		interestPlayersModel.addColumn("Red cards");
		interestPlayersModel.addColumn("Age");
		interestPlayersModel.addColumn("ID");

		panel.add(interestTable);
		interestTable.setVisible(false);
		
		showPlayersButton = new JButton("");
		showPlayersButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/showPlayersButton.png")));
		showPlayersButton.setOpaque(false);
		showPlayersButton.setContentAreaFilled(false);
		showPlayersButton.setBorderPainted(false);
		showPlayersButton.setBorder(null);
		showPlayersButton.setBounds(662, 466, 107, 47);
		panel.add(showPlayersButton);
		
		findPlayersButton = new JButton("");
		findPlayersButton.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/findPlayersButton.png")));
		findPlayersButton.setOpaque(false);
		findPlayersButton.setContentAreaFilled(false);
		findPlayersButton.setBorderPainted(false);
		findPlayersButton.setBorder(null);
		findPlayersButton.setBounds(224, 466, 107, 47);
		panel.add(findPlayersButton);
		findPlayersTable.setBounds(200, 186, 581, 243);
		interestTable.setBounds(200, 186, 581, 243);

		panel.add(signOutButton);
		nameColumn.setVisible(false);
		teamColumn.setVisible(false);
		roleColumn.setVisible(false);
		goalsColumn.setVisible(false);
		assistColumn.setVisible(false);
		playingTimeColumn.setVisible(false);
		idColumn.setVisible(false);
		yellowCards.setVisible(false);
		redCards.setVisible(false);
		
		JLabel scoutName = new JLabel(myScouter.getScoutName());
		scoutName.setForeground(Color.WHITE);
		scoutName.setFont(new Font("Arial", Font.BOLD, 18));
		scoutName.setBounds(28, 59, 153, 43);
		panel.add(scoutName);
		
		JLabel teamName = new JLabel(myScouter.getMyTeam().getTeamName());
		teamName.setForeground(Color.WHITE);
		teamName.setFont(new Font("Arial", Font.PLAIN, 15));
		teamName.setBounds(28, 99, 178, 35);
		panel.add(teamName);
		
		JLabel rightSideBg = new JLabel("");
		rightSideBg.setFont(new Font("Arial", Font.PLAIN, 11));
		rightSideBg.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/scoutRightBackground.png")));
		rightSideBg.setBounds(177, 0, 637, 532);
		panel.add(rightSideBg);
		
		JLabel leftBackground = new JLabel("");
		leftBackground.setBounds(0, 0, 412, 534);
		panel.add(leftBackground);
		leftBackground.setIcon(new ImageIcon(ScoutScreen.class.getResource("/view/res/basicLeftBG.png")));

	}
	public void setWindowVisible(boolean flag) {
		this.setVisible(flag);
	}
	public void showFindPlayersTable() {
		findPlayersTable.setVisible(true);
		interestTable.setVisible(false);
		teamNameField.setVisible(true);
		roleSpinner.setVisible(true);
		filterByTeamButton.setVisible(true);
		filterByAgeButton.setVisible(true);
		filterByRoleButton.setVisible(true);
		goalsSort.setVisible(true);
		assistsButton.setVisible(true);
		playingTimeButton.setVisible(true);
		filterTitle.setVisible(true);
		sortTitle.setVisible(true);
		addPlayerButton.setVisible(true);
		removePlayerButton.setVisible(false);
		messageArea.setVisible(false);
		nameColumn.setVisible(true);
		teamColumn.setVisible(true);
		roleColumn.setVisible(true);
		goalsColumn.setVisible(true);
		assistColumn.setVisible(true);
		playingTimeColumn.setVisible(true);
		idColumn.setVisible(true);
		yellowCards.setVisible(true);
		redCards.setVisible(true);
		ageColumn.setVisible(true);
	}
	public void showInterestTable() {
		interestTable.setVisible(true);
		findPlayersTable.setVisible(false);
		teamNameField.setVisible(false);
		roleSpinner.setVisible(false);
		filterByTeamButton.setVisible(false);
		filterByRoleButton.setVisible(false);
		goalsSort.setVisible(false);
		assistsButton.setVisible(false);
		playingTimeButton.setVisible(false);
		filterTitle.setVisible(false);
		sortTitle.setVisible(false);
		addPlayerButton.setVisible(false);
		removePlayerButton.setVisible(true);
		messageArea.setVisible(false);
		teamColumn.setVisible(true);
		roleColumn.setVisible(true);
		goalsColumn.setVisible(true);
		assistColumn.setVisible(true);
		playingTimeColumn.setVisible(true);
		idColumn.setVisible(true);
		yellowCards.setVisible(true);
		redCards.setVisible(true);
		ageColumn.setVisible(true);
		nameColumn.setVisible(true);

	}
	public void addItemToFindPlayersTable(String name, String team, String role, int goals, int assists, int playingTime, int yellowCards, int redCards,String age, int id) {
		findPlayersModel.insertRow(0, new Object[] {name, team, role, goals, assists, playingTime,yellowCards, redCards, age, id});
	}
	public void addItemToInterestTable(String name, String team, String role, int goals, int assists, int playingTime, int yellowCards, int redCards, String age, int id) {
		interestPlayersModel.insertRow(0, new Object[] {name, team, role, goals, assists, playingTime, yellowCards, redCards, age, id});
	}
	public int getSelectedRowInFindPlayersTable() {
		return findPlayersTable.getSelectedRow();
	}
	public int getSelectedColumInFindPlayersTable() {
		return findPlayersTable.getSelectedColumn();
	}
	public Object getValueFromFindPlayersTable(int row, int column) {
		try 
		{
			return findPlayersTable.getValueAt(row, column);
		}
		catch(Exception e)
		{
			return null;
		}
		finally {
			System.out.println("Didn't selected an item from list");
		}
	}
	public int getSelectedRowInInterestTable() {
		return interestTable.getSelectedRow();
	}
	public int getSelectedColumInInterestTable() {
		return interestTable.getSelectedColumn();
	}
	public void initFindPlayersTable() {
		findPlayersModel.setRowCount(0);
	}
	public void initInterestTable() {
		interestPlayersModel.setRowCount(0);
	}
	public void setMessage(String messageToDisplay) {
		messageArea.setVisible(true);
		messageArea.setText(messageToDisplay);
	}
	public void setVisibleOfAddButton(boolean flag) {
		addPlayerButton.setVisible(flag);
	}
	public void setVisibleOfRemoveButton(boolean flag) {
		removePlayerButton.setVisible(flag);
	}
	public Object getValueFromInterestTable(int row, int column) {
		try 
		{
			return interestTable.getValueAt(row, column);
		}
		catch(Exception e)
		{
			return null;
		}
		finally {
			System.out.println("Didn't selected an item from list");
		}
	}
	public void addSignOutListener(ActionListener signOutButtonListner) {
		signOutButton.addActionListener(signOutButtonListner);
	}
	public void addFindPlayersListener(ActionListener findPlayersListner) {
		findPlayersButton.addActionListener(findPlayersListner);
	}
	public void addShowPlayersListener(ActionListener showPlayersListner) {
		showPlayersButton.addActionListener(showPlayersListner);
	}
	public void addAddPlayerListener(ActionListener addPlayerListner) {
		addPlayerButton.addActionListener(addPlayerListner);
	}
	public void addRemovePlayerListener(ActionListener removePlayerListner) {
		removePlayerButton.addActionListener(removePlayerListner);
	}
	public void addFilterByTeamListener(ActionListener filterByTeamListner) {
		filterByTeamButton.addActionListener(filterByTeamListner);
	}
	public void addFilterByRoleListener(ActionListener filterByRoleListner) {
		filterByRoleButton.addActionListener(filterByRoleListner);
	}
	public void addFilterByAgeListener(ActionListener filterByAgeListner) {
		filterByAgeButton.addActionListener(filterByAgeListner);
	}
	public void addSortByGoalsListener(ActionListener sortByGoalsListner) {
		goalsSort.addActionListener(sortByGoalsListner);
	}
	public void addSortByAssistsListener(ActionListener sortByAssistsListner) {
		assistsButton.addActionListener(sortByAssistsListner);
	}
	public void addSortByPlayingTimeListener(ActionListener sortByPlayingTimeListner) {
		playingTimeButton.addActionListener(sortByPlayingTimeListner);
	}
	public String getPlayerRole() {
		return (String) roleSpinner.getValue();
	}
	public String getTeamName() {
		return teamNameField.getText();
	}
	public String getAge() {
		return (String) AgeSpinner.getValue();
	}
}
