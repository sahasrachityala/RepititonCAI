package RepititonCAI;

//these are imports needed for the GUI elements 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

//this is the quiz frame thats used to test out the users knowledge 
//t his will consist of 6 different quetions with three multiple choice options each 
public class QuizFrame extends JFrame implements ActionListener {

	private JLabel titleLabel = new JLabel(" LETS TEST YOUR KNOWLEDGE");

	// this is for setting up the background gif
	private ImageIcon background = new ImageIcon("images/background1.gif");
	// scale the image so it fits the size of the frame
	private ImageIcon scaledBackground = new ImageIcon(
			background.getImage().getScaledInstance(1300, 800, java.awt.Image.SCALE_DEFAULT));
	private JLabel backgroundLabel = new JLabel(scaledBackground);

	// Add labels for each of the questions
	private JLabel question1 = new JLabel(
			"<html> " + " Which is the best loop for when <br>" + " you know the number of repeats? </html>");

	private JLabel question2 = new JLabel(
			"<html> " + "Which type of loop will execute <br>" + "at least once? </html>");

	private JLabel question3 = new JLabel(
			"<html> " + "What happens if the condition is <br>" + " FALSE for a while loop? </html>");

	private JLabel question4 = new JLabel(
			"<html> " + "Why do we use count++ inside the <br>" + "body of the loop? </html>");

	private JLabel question5 = new JLabel("<html> " + "If I want to ask the user for input before <br>"
			+ "checking a condition, which loop do I use? </html>");

	private JLabel question6 = new JLabel(
			"<html> " + "What is the purpose of the middle <br>" + " section in a for-loop? </html>");

	// make a panel for each on of the question to hold there seperate radio buttons
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();

	// make a button group for each of the 6 radio button arrays to allow the user
	// to select
	// one option from each of the 6 different questions
	private ButtonGroup ButtonGroup1 = new ButtonGroup();
	private ButtonGroup ButtonGroup3 = new ButtonGroup();
	private ButtonGroup ButtonGroup4 = new ButtonGroup();
	private ButtonGroup ButtonGroup6 = new ButtonGroup();

	// make an array for each one of the questions to hold the radio buttons
	// set the value to 3 since there are only three radio button option for each
	private JRadioButton[] RadioButtonArray1 = new JRadioButton[3];
	private JRadioButton[] RadioButtonArray3 = new JRadioButton[3];
	private JRadioButton[] RadioButtonArray4 = new JRadioButton[3];
    private JRadioButton[] RadioButtonArray6 = new JRadioButton[3];
    
    // Create a JComboBox and add the loop options
 	JComboBox<String> comboBox2 = new JComboBox<>();
    
    // Create an array for JCheckBox elements
    JCheckBox[] checkBoxArray5 = new JCheckBox[3];

	// add a scroll pane for each to make it easier to view all the options clearly
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane4;
	private JScrollPane scrollPane5;
	private JScrollPane scrollPane6;

	// add the bottons to make it easier to navigate from one frame to the other
	private JButton backButton = new JButton("BACK");
	private JButton homeButton = new JButton("HOME");

	// these buttons check users score each time its clicked
	private JButton scoreButton = new JButton("CHECK SCORE");

	// add a label that is used to display the score at the end of the quiz
	private JLabel scoreDisplayLabel = new JLabel("");

	// this is the value that holds the users score
	private int score = 0;

	// this is the contructer frame
	public QuizFrame() {

		// setup the survey frame
		setLayout(null);
		setTitle("SURVEY FRAME!");
		setSize(1300, 800);

		// add background image
		backgroundLabel.setSize(1300, 800);
		backgroundLabel.setBounds(0, 0, 1300, 800);
		backgroundLabel.setLayout(null);
		backgroundLabel.setVisible(true);
		add(backgroundLabel);

		// add the title and specify bounds, color, etc
		titleLabel.setBounds(400, 20, 540, 50);
		titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 35));
		titleLabel.setForeground(Color.white);
		titleLabel.setBackground(new Color(118, 128, 166));
		titleLabel.setOpaque(true);
		titleLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(titleLabel);

		// QUESTION LABELS
		// Add the question labels and specify bounds, color, etc for each one
		question1.setBounds(80, 90, 300, 50);
		question1.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question1.setForeground(Color.white);
		question1.setBackground(new Color(79, 90, 130));
		question1.setOpaque(true);
		question1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question1);

		question2.setBounds(520, 90, 280, 50);
		question2.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question2.setForeground(Color.white);
		question2.setBackground(new Color(79, 90, 130));
		question2.setOpaque(true);
		question2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question2);

		question3.setBounds(950, 90, 280, 50);
		question3.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question3.setForeground(Color.white);
		question3.setBackground(new Color(79, 90, 130));
		question3.setOpaque(true);
		question3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question3);

		question4.setBounds(80, 390, 300, 50);
		question4.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question4.setForeground(Color.white);
		question4.setBackground(new Color(79, 90, 130));
		question4.setOpaque(true);
		question4.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question4);

		question5.setBounds(510, 390, 370, 50);
		question5.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question5.setForeground(Color.white);
		question5.setBackground(new Color(79, 90, 130));
		question5.setOpaque(true);
		question5.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question5);

		question6.setBounds(950, 390, 280, 50);
		question6.setFont(new java.awt.Font("Times New Roman", 0, 20));
		question6.setForeground(Color.white);
		question6.setBackground(new Color(79, 90, 130));
		question6.setOpaque(true);
		question6.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(question6);

		// PANELS
		// add the panels that hold radio buttons and text fields and setup bounds
		panel1.setBounds(100, 150, 200, 100);
		panel1.setBackground(Color.BLACK);
		backgroundLabel.add(panel1);

		panel2.setBounds(550, 150, 200, 100);
		panel2.setBackground(Color.BLACK);
		backgroundLabel.add(panel2);

		panel3.setBounds(1000, 150, 200, 100);
		panel3.setBackground(Color.BLACK);
		backgroundLabel.add(panel3);

		panel4.setBounds(100, 450, 200, 100);
		panel4.setBackground(Color.BLACK);
		backgroundLabel.add(panel4);

		panel5.setBounds(550, 450, 200, 100);
		panel5.setBackground(Color.BLACK);
		backgroundLabel.add(panel5);

		panel6.setBounds(1000, 450, 200, 100);
		panel6.setBackground(Color.BLACK);
		backgroundLabel.add(panel6);

		// add the score button that calaculates if user passed or not
		scoreButton.setBounds(300, 700, 250, 40);
		scoreButton.setFont(new java.awt.Font("Times New Roman", 0, 30));
		scoreButton.setForeground(Color.BLACK);
		scoreButton.setBackground(Color.WHITE);
		scoreButton.setOpaque(true);
		scoreButton.addActionListener(this);
		backgroundLabel.add(scoreButton);

		// add the display label which is always changing as this is where the score
		// will be displayed
		scoreDisplayLabel.setBounds(600, 700, 350, 30);
		scoreDisplayLabel.setFont(new java.awt.Font("Times New Roman", 0, 20));
		scoreDisplayLabel.setForeground(Color.BLACK);
		scoreDisplayLabel.setBackground(new Color(111, 111, 157));
		scoreDisplayLabel.setOpaque(true);
		backgroundLabel.add(scoreDisplayLabel);

		// ad back button which will take user back to previous page
		backButton.setBounds(50, 700, 100, 30);
		backButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(111, 111, 157));
		backButton.setOpaque(true);
		backButton.addActionListener(this);
		backgroundLabel.add(backButton);

		// add the home button which takes user back to main page
		homeButton.setBounds(1150, 700, 100, 30);
		homeButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		homeButton.setForeground(Color.BLACK);
		homeButton.setBackground(new Color(111, 111, 157));
		homeButton.setOpaque(true);
		homeButton.addActionListener(this);
		backgroundLabel.add(homeButton);

		// make methods for the contents in each panel to make it easier to accsess
		setupQuestion1();
		setupQuestion2();
		setupQuestion3();
		setupQuestion4();
		setupQuestion5();
		setupQuestion6();

		// set the menubar from the mainframe to allow it to appear on this frame too
		setJMenuBar(MainFrame.menubar);

		// set visible to tru so all the content in constructer frame show up
		setVisible(true);
	}

	// this is the method with the GUI elements for the first question
	private void setupQuestion1() {
		// setup the values for each element of the array
		RadioButtonArray1[0] = new JRadioButton(" do - while loop");
		RadioButtonArray1[1] = new JRadioButton(" for loop");
		RadioButtonArray1[2] = new JRadioButton(" while loop");

		// use a for loop to display the full lengnth of the array in the panel
		for (int index = 0; index < RadioButtonArray1.length; index++) {
			ButtonGroup1.add(RadioButtonArray1[index]);
			RadioButtonArray1[index].setBounds(25, index * 30, 10, 100);
			RadioButtonArray1[index].setForeground(Color.WHITE);
			RadioButtonArray1[index].setFont(new java.awt.Font("Times New Roman", 10, 30));
			panel1.add(RadioButtonArray1[index]);
		}

		// add a scroll pane
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(80, 150, 300, 200);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setViewportView(panel1);
		backgroundLabel.add(scrollPane1);

	}

	// this is the method with the GUI elements for the second question
	// this will be a combo box
	private void setupQuestion2() {

		comboBox2.addItem("while loop");
		comboBox2.addItem("do-while loop");
		comboBox2.addItem("for loop");

		// Set up the properties for the JComboBox
		comboBox2.setBounds(25, 0, 300, 100);
		comboBox2.setForeground(Color.WHITE);
		comboBox2.setFont(new java.awt.Font("Times New Roman", 10, 30));

		// Add the JComboBox to the panel
		panel2.add(comboBox2);

		// Add a scroll pane 
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(520, 150, 300, 200);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setViewportView(panel2);
		backgroundLabel.add(scrollPane2);
	}

	// this is the method with the GUI elements for the third question
	private void setupQuestion3() {

		// setup the values for each element of the array
		RadioButtonArray3[0] = new JRadioButton(" loop will repeat until its true");
		RadioButtonArray3[1] = new JRadioButton(" nothing will happen");
		RadioButtonArray3[2] = new JRadioButton(" the loop will end");

		// use a for loop to display the full lengnth of the array in the panel
		for (int index = 0; index < RadioButtonArray3.length; index++) {
			ButtonGroup3.add(RadioButtonArray3[index]);
			RadioButtonArray3[index].setBounds(25, index * 30, 10, 100);
			RadioButtonArray3[index].setForeground(Color.WHITE);
			RadioButtonArray3[index].setFont(new java.awt.Font("Times New Roman", 10, 30));
			panel3.add(RadioButtonArray3[index]);
		}

		// add a scroll pane
		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(950, 150, 300, 200);
		scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setViewportView(panel3);
		backgroundLabel.add(scrollPane3);
	}

	// this is the method with the GUI elements for the fourth question
	private void setupQuestion4() {

		// setup the values for each element of the array
		RadioButtonArray4[0] = new JRadioButton(" so the count value goes up when each loop occours");
		RadioButtonArray4[1] = new JRadioButton(" to give the loop a condition");
		RadioButtonArray4[2] = new JRadioButton(" so the code can print an output");

		// use a for loop to display the full lengnth of the array in the panel
		for (int index = 0; index < RadioButtonArray4.length; index++) {
			ButtonGroup4.add(RadioButtonArray4[index]);
			RadioButtonArray4[index].setBounds(25, index * 30, 10, 100);
			RadioButtonArray4[index].setForeground(Color.WHITE);
			RadioButtonArray4[index].setFont(new java.awt.Font("Times New Roman", 10, 30));
			panel4.add(RadioButtonArray4[index]);
		}

		// add a scroll pane
		scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(80, 450, 300, 200);
		scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane4.setViewportView(panel4);
		backgroundLabel.add(scrollPane4);
	}

	// this is the method with the GUI elements for the fifth question
	//this questions used JcheckBoxes instead
	private void setupQuestion5() {

	    // Setup the values for each element of the array
	    checkBoxArray5[0] = new JCheckBox("do-while loop");
	    checkBoxArray5[1] = new JCheckBox("for loop");
	    checkBoxArray5[2] = new JCheckBox("while loop");

	    // Use a for loop to display the full length of the array in the panel
	    for (int index = 0; index < checkBoxArray5.length; index++) {
	        checkBoxArray5[index].setBounds(25, index * 30, 300, 150);
	        checkBoxArray5[index].setForeground(Color.WHITE);
	        checkBoxArray5[index].setFont(new java.awt.Font("Times New Roman", 10, 30));
	        panel5.add(checkBoxArray5[index]);
	    }

	    // Add a scroll pane
	    scrollPane5 = new JScrollPane();
	    scrollPane5.setBounds(520, 450, 300, 200);
	    scrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane5.setViewportView(panel5);
	    backgroundLabel.add(scrollPane5);
	}

	// this is the method with the GUI elements for the sixth question
	private void setupQuestion6() {

		// setup the values for each element of the array
		RadioButtonArray6[0] = new JRadioButton(" to increment each time the loop occours");
		RadioButtonArray6[1] = new JRadioButton(" to tell the program the starting number");
		RadioButtonArray6[2] = new JRadioButton(" to give the program the condition of when to stop the code");

		// use a for loop to display the full lengnth of the array in the panel
		for (int index = 0; index < RadioButtonArray6.length; index++) {
			ButtonGroup6.add(RadioButtonArray6[index]);
			RadioButtonArray6[index].setBounds(25, index * 30, 10, 100);
			RadioButtonArray6[index].setForeground(Color.WHITE);
			RadioButtonArray6[index].setFont(new java.awt.Font("Times New Roman", 10, 30));
			panel6.add(RadioButtonArray6[index]);
		}

		// add a scroll pane
		scrollPane6 = new JScrollPane();
		scrollPane6.setBounds(950, 450, 300, 200);
		scrollPane6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane6.setViewportView(panel6);
		backgroundLabel.add(scrollPane6);
	}

	// this is the actionListner method that is used to give commands to each of the
	// buttons, labels, etc
	@Override
	public void actionPerformed(ActionEvent event) {

		// if user clicks the score button then checks to see how many of the answers
		// they clicked were correct
		// set score to 0 at the beggening
		if (event.getSource() == scoreButton) {
			score = 0;

			// each time they click the correct answer from each radio button group
			// the score will increase by 1 for each
			if (RadioButtonArray1[1].isSelected()) {
				score++;
			}

			if ("do-while loop".equals(comboBox2.getSelectedItem())) {
                score++;
			}

			if (RadioButtonArray3[2].isSelected()) {
				score++;
			}

			if (RadioButtonArray4[0].isSelected()) {
				score++;
			}

			if (checkBoxArray5[0].isSelected()) {
				score++;
			}

			if (RadioButtonArray6[2].isSelected()) {
				score++;
			}

			// check to see if user passed or failed based on the number they scored
			if (score >= 3) {
				scoreDisplayLabel.setText("YOU PASSED! YOUR SCORE IS : " + score);
			} else {
				scoreDisplayLabel.setText("YOU FAILED! YOUR SCORE IS : " + score);
			}
			scoreDisplayLabel.repaint();
		}

		// check if the source of the event is backButton
		if (event.getSource() == backButton) {
			setVisible(false);
			new ActivityFrame();
		}

		// check if the source of the event is homeButton
		if (event.getSource() == homeButton) {
			setVisible(false);
			new MainFrame();
		}
	}
}