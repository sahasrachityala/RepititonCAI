package RepititonCAI;

//these are all the diffent imports for the elments 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

//this is the activity frame which consists of a small game the user will have to play 
// this game is used to further expand the knowledge of the user 
// there will be four tasks that each get the user to aquire a letter and then 
// using those letters the user will have to descaramle and find the secret word 
public class ActivityFrame extends JFrame implements ActionListener {

	// this is for setting up the background gif
	private ImageIcon background = new ImageIcon("images/background1.gif");
	// scale the image so it fits the size of the frame
	private ImageIcon scaledBackground = new ImageIcon(
			background.getImage().getScaledInstance(1300, 800, java.awt.Image.SCALE_DEFAULT));
	private JLabel backgroundLabel = new JLabel(scaledBackground);

	// add the title label
	private JLabel titleLabel = new JLabel("PRACTICE YOUR NEW SKILLS!");
	// add an instructions label to clafiry to the user on what to do
	private JLabel instructionLabel = new JLabel("<html>"
			+ "Fill in the missing blank code. From your answer type in the specific letter shown bellow each task, <br>"
			+ "then with the four letters given, de-scramble the letters to find out the secret word! </html>");

	// setup 4 panels one for each of the different tasks/activities
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();

	// setup the labels for each one of the tasks
	private JLabel task1Label = new JLabel("Task 1: ");
	private JLabel task2Label = new JLabel("Task 2: ");
	private JLabel task3Label = new JLabel("Task 3: ");
	private JLabel task4Label = new JLabel("Task 4: ");

	// setup the labels that will clarify to the user which letter to use from there
	// answer
	// add to the panel under the images
	private JLabel letter1Label = new JLabel(" Select the 1st letter from answer!");
	private JLabel letter2Label = new JLabel(" Select the 2nd letter from answer!");
	private JLabel letter3Label = new JLabel(" Select the 3rd letter from answer!");
	private JLabel letter4Label = new JLabel(" Select the 5th letter from answer!");

	// setup the images of the fill in the blanks in the panel
	private ImageIcon blankIcon1 = new ImageIcon("images/blank1.png");
	private ImageIcon blankImageIcon1 = new ImageIcon(
			blankIcon1.getImage().getScaledInstance(280, 160, java.awt.Image.SCALE_SMOOTH));
	private JLabel blankImage1 = new JLabel(blankImageIcon1);

	private ImageIcon blankIcon2 = new ImageIcon("images/blank2.png");
	private ImageIcon blankImageIcon2 = new ImageIcon(
			blankIcon2.getImage().getScaledInstance(280, 160, java.awt.Image.SCALE_SMOOTH));
	private JLabel blankImage2 = new JLabel(blankImageIcon2);

	private ImageIcon blankIcon3 = new ImageIcon("images/blank3.png");
	private ImageIcon blankImageIcon3 = new ImageIcon(
			blankIcon3.getImage().getScaledInstance(280, 160, java.awt.Image.SCALE_SMOOTH));
	private JLabel blankImage3 = new JLabel(blankImageIcon3);

	private ImageIcon blankIcon4 = new ImageIcon("images/blank4.png");
	private ImageIcon blankImageIcon4 = new ImageIcon(
			blankIcon4.getImage().getScaledInstance(280, 160, java.awt.Image.SCALE_SMOOTH));
	private JLabel blankImage4 = new JLabel(blankImageIcon4);

	// in each of the panels add a button that will allow user to enter the letter
	public static JButton letter1Button = new JButton("Enter the letter: ");
	public static JButton letter2Button = new JButton("Enter the letter: ");
	public static JButton letter3Button = new JButton("Enter the letter: ");
	public static JButton letter4Button = new JButton("Enter the letter: ");

	// setup buttons to let the user guess the secret word and if wrong re guess
	private JButton againButton = new JButton("Again");
	private JButton guessButton = new JButton("Guess");

	// setup the textfeild that allows user to entere there guess of secret word
	private JTextField wordTextField = new JTextField("Guess Word: ");

	// make static variables for the letters that the user guesses
	public static String letter1;
	public static String letter2;
	public static String letter3;
	public static String letter4;

	// this is variable that will hold the user text field guess
	private static String guessWord;

	// call the menu bar so it appears on the activity frame aswell
	public JMenuBar menubar = new JMenuBar();

	// this is the label used to showcase the letters once user enters there guess
	public static JLabel letterDisplayLabel = new JLabel("LETTERS:");

	// add the bottons to make it easier to navigate from one frame to the other
	private JButton backButton = new JButton("BACK");
	private JButton nextButton = new JButton("NEXT");
	
	
	// constructer frame
	// this is used to setup bounds, colour, size, etc for all the GUI elements
	public ActivityFrame() {

		// setup the frame
		setLayout(null);
		setTitle("CONTENT");
		setSize(1300, 800);

		// setup the background labels bounds
		backgroundLabel.setBounds(0, 0, 1300, 800);
		add(backgroundLabel);

		// setup the size, bounds etc for the title label
		titleLabel.setBounds(370, 20, 575, 50);
		titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 40));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(new Color(111, 111, 157));
		titleLabel.setOpaque(true);
		backgroundLabel.add(titleLabel);

		// setup the size, bounds etc for the title label
		instructionLabel.setBounds(350, 85, 640, 35);
		instructionLabel.setFont(new java.awt.Font("Times New Roman", 0, 15));
		instructionLabel.setForeground(Color.WHITE);
		instructionLabel.setBackground(new Color(111, 111, 157));
		instructionLabel.setOpaque(true);
		backgroundLabel.add(instructionLabel);

		// add the panels that hold all the conetents for each task
		panel1.setBounds(210, 130, 400, 240);
		panel1.setBackground(new Color(118, 128, 166));
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		backgroundLabel.add(panel1);

		panel2.setBounds(770, 130, 400, 240);
		panel2.setBackground(new Color(118, 128, 166));
		panel2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(panel2);

		panel3.setBounds(210, 400, 400, 240);
		panel3.setBackground(new Color(118, 128, 166));
		panel3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(panel3);

		panel4.setBounds(770, 400, 400, 240);
		panel4.setBackground(new Color(118, 128, 166));
		panel4.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundLabel.add(panel4);

		// setup the guess button which tells user if there guess is right or wrong
		guessButton.setBounds(1000, 690, 100, 15);
		guessButton.setFont(new java.awt.Font("Times New Roman", 0, 15));
		guessButton.setForeground(Color.BLACK);
		guessButton.setBackground(new Color(111, 111, 157));
		guessButton.setOpaque(true);
		guessButton.addActionListener(this);
		backgroundLabel.add(guessButton);

		// this clears the textfield so user can enter a guess again
		againButton.setBounds(1000, 710, 100, 15);
		againButton.setFont(new java.awt.Font("Times New Roman", 0, 15));
		againButton.setForeground(Color.BLACK);
		againButton.setBackground(new Color(111, 111, 157));
		againButton.setOpaque(true);
		againButton.addActionListener(this);
		backgroundLabel.add(againButton);

		// setup the text field that takes in user guess of secret word
		wordTextField.setBounds(600, 690, 350, 30);
		wordTextField.setFont(new java.awt.Font("Times New Roman", 0, 25));
		wordTextField.setForeground(Color.BLACK);
		wordTextField.setBackground(Color.WHITE);
		wordTextField.setOpaque(true);
		backgroundLabel.add(wordTextField);

		// this is the label that will showcase the letters after the user guesses it
		letterDisplayLabel.setBounds(300, 700, 200, 30);
		letterDisplayLabel.setFont(new java.awt.Font("Times New Roman", 0, 20));
		letterDisplayLabel.setForeground(Color.WHITE);
		letterDisplayLabel.setBackground(new Color(111, 111, 157));
		letterDisplayLabel.setOpaque(true);
		backgroundLabel.add(letterDisplayLabel);

		// add the back and next button and setup there colour, bounds, etc
		backButton.setBounds(50, 700, 100, 30);
		backButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(111, 111, 157));
		backButton.setOpaque(true);
		backButton.addActionListener(this);
		backgroundLabel.add(backButton);

		// add next button and setup the bounds, colour, etc
		nextButton.setBounds(1150, 700, 100, 30);
		nextButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		nextButton.setForeground(Color.BLACK);
		nextButton.setBackground(new Color(111, 111, 157));
		nextButton.setOpaque(true);
		nextButton.addActionListener(this);
		backgroundLabel.add(nextButton);
		
	

		// these are the methods which make the contents for each task
		setupTask1();
		setupTask2();
		setupTask3();
		setupTask4();

		//this allows the menu bar to appear on this frame too
		setJMenuBar(MainFrame.menubar);
		

		setVisible(true);

	}
	

	// this is the method containing all the contents in the first class
	private void setupTask1() {
		// this is the label that shows what task number it is
		task1Label.setBounds(0, 0, 80, 5);
		task1Label.setFont(new java.awt.Font("Times New Roman", 0, 15));
		task1Label.setForeground(Color.WHITE);
		task1Label.setBackground(new Color(111, 111, 157));
		task1Label.setOpaque(true);
		panel1.add(task1Label);

		// setup the bounds for the image
		blankImage1.setBounds(0, 0, 250, 150);
		panel1.add(blankImage1);

		// setup the label that specifies the letter
		letter1Label.setBounds(100, 300, 200, 20);
		letter1Label.setFont(new java.awt.Font("Times New Roman", 0, 20));
		letter1Label.setForeground(Color.WHITE);
		letter1Label.setBackground(new Color(111, 111, 157));
		letter1Label.setOpaque(true);
		panel1.add(letter1Label);

		// setup the button that allows user to enter
		letter1Button.setBounds(100, 350, 220, 20);
		letter1Button.setFont(new java.awt.Font("Times New Roman", 0, 16));
		letter1Button.setBackground(Color.WHITE);
		letter1Button.setOpaque(true);
		letter1Button.addActionListener(this);
		panel1.add(letter1Button);

	}

	// this is the method that conatins all the conetents for second class
	private void setupTask2() {
		// this is the label that shows task number
		task2Label.setBounds(0, 0, 80, 5);
		task2Label.setFont(new java.awt.Font("Times New Roman", 0, 15));
		task2Label.setForeground(Color.WHITE);
		task2Label.setBackground(new Color(111, 111, 157));
		task2Label.setOpaque(true);
		panel2.add(task2Label);

		// setup the bounds for the image that shows the task
		blankImage2.setBounds(0, 0, 250, 150);
		panel2.add(blankImage2);

		// this is the label that tells user about the specific letter needed
		letter2Label.setBounds(100, 300, 200, 20);
		letter2Label.setFont(new java.awt.Font("Times New Roman", 0, 20));
		letter2Label.setForeground(Color.WHITE);
		letter2Label.setBackground(new Color(111, 111, 157));
		letter2Label.setOpaque(true);
		panel2.add(letter2Label);

		// this is the buttons that takes users letter input
		letter2Button.setBounds(100, 350, 220, 20);
		letter2Button.setFont(new java.awt.Font("Times New Roman", 0, 16));
		letter2Button.setBackground(Color.WHITE);
		letter2Button.setOpaque(true);
		letter2Button.addActionListener(this);
		panel2.add(letter2Button);
	}

	// this is the method that conatins all the conetents for third class
	private void setupTask3() {
		// this is the label for the task number
		task3Label.setBounds(0, 0, 80, 5);
		task3Label.setFont(new java.awt.Font("Times New Roman", 0, 15));
		task3Label.setForeground(Color.WHITE);
		task3Label.setBackground(new Color(111, 111, 157));
		task3Label.setOpaque(true);
		panel3.add(task3Label);

		// setup the image within the panel
		blankImage3.setBounds(0, 0, 250, 150);
		panel3.add(blankImage3);

		// setup label that shows the letter user must use
		letter3Label.setBounds(100, 300, 200, 20);
		letter3Label.setFont(new java.awt.Font("Times New Roman", 0, 20));
		letter3Label.setForeground(Color.WHITE);
		letter3Label.setBackground(new Color(111, 111, 157));
		letter3Label.setOpaque(true);
		panel3.add(letter3Label);

		// this button allows user to input there letter guess
		letter3Button.setBounds(100, 350, 220, 20);
		letter3Button.setFont(new java.awt.Font("Times New Roman", 0, 16));
		letter3Button.setBackground(Color.WHITE);
		letter3Button.setOpaque(true);
		letter3Button.addActionListener(this);
		panel3.add(letter3Button);
	}

	// this is the method that conatins all the conetents for fourth class
	private void setupTask4() {
		// this label shows the task number
		task4Label.setBounds(0, 0, 80, 5);
		task4Label.setFont(new java.awt.Font("Times New Roman", 0, 15));
		task4Label.setForeground(Color.WHITE);
		task4Label.setBackground(new Color(111, 111, 157));
		task4Label.setOpaque(true);
		panel4.add(task4Label);

		// dipslay the image insdie the panel
		blankImage4.setBounds(0, 0, 250, 150);
		panel4.add(blankImage4);

		// this lable shows which letter to use
		letter4Label.setBounds(100, 300, 200, 20);
		letter4Label.setFont(new java.awt.Font("Times New Roman", 0, 20));
		letter4Label.setForeground(Color.WHITE);
		letter4Label.setBackground(new Color(111, 111, 157));
		letter4Label.setOpaque(true);
		panel4.add(letter4Label);

		// this buttons allows user to input there guess
		letter4Button.setBounds(100, 350, 220, 20);
		letter4Button.setFont(new java.awt.Font("Times New Roman", 0, 16));
		letter4Button.setBackground(Color.WHITE);
		letter4Button.setOpaque(true);
		letter4Button.addActionListener(this);
		panel4.add(letter4Button);
	}

	// this is the acition litener method which gives commands to each button, etc
	@Override
	public void actionPerformed(ActionEvent event) {

		// if the guess button is clicked recieve the input from the text field
		if (event.getSource() == guessButton) {
			guessWord = wordTextField.getText();

			// output a dialog box depending on the input recived
			// the correct answer is over
			if (guessWord.equalsIgnoreCase("Guess Word: over")) {
				JOptionPane.showMessageDialog(null,
						"YOU GUESSED CORRECT! : SECRET WORD IS OVER BECAUSE LOOPS REPEAT OVER AND OVER AGAIN!");

				// if guess is wrong then a message box will show up telling user to try again
			} else {
				JOptionPane.showMessageDialog(null, "TRY AGAIN");
			}

			// if use clicks again then reset the text field
		} else if (event.getSource() == againButton) {
			wordTextField.setText("Guess Word: ");
		}

		// evertime the guess leter button is clicked make sure an input box pops up
		// asking user to enter there input
		// once the user clicks okay then the letters label at the bottom of the screen
		// will be updated with the new letters only if there guess is correct
		// to display the text as a label i used this link: 
		// https://coderanch.com/t/770557/java/Displaying-variable-text-JLabel

		if (event.getSource() == letter1Button) {
			String letter1 = JOptionPane.showInputDialog("Enter your guess for the first letter!: ");

			// if guess is correct message box will pop up and the label at bottom will be
			// updated
			if (letter1.equals("v")) {
				letterDisplayLabel.setText("LETTERS: " + letter1);
				JOptionPane.showMessageDialog(null, "Correct");

				// if guess is wrong then a message box will show up telling user to try again
			} else {
				JOptionPane.showMessageDialog(null, "Try Again");
			}
		}
		if (event.getSource() == letter2Button) {
			String letter2 = JOptionPane.showInputDialog("Enter your guess for the second letter!: ");
			// if guess is correct message box will pop up and the label at bottom will be
			// updated
			if (letter2.equals("o")) {
				letterDisplayLabel.setText("LETTERS: " + "v" + letter2);
				JOptionPane.showMessageDialog(null, "Correct");

				// if guess is wrong then a message box will show up telling user to try again
			} else {
				JOptionPane.showMessageDialog(null, "Try Again");
			}
		}

		if (event.getSource() == letter3Button) {
			String letter3 = JOptionPane.showInputDialog("Enter your guess for the second letter!: ");
			// if guess is correct message box will pop up and the label at bottom will be
			// updated
			if (letter3.equals("r")) {
				letterDisplayLabel.setText("LETTERS: " + "v" + "o" + letter3);
				JOptionPane.showMessageDialog(null, "Correct");

				// if guess is wrong then a message box will show up telling user to try again
			} else {
				JOptionPane.showMessageDialog(null, "Try Again");
			}
		}

		if (event.getSource() == letter4Button) {
			String letter4 = JOptionPane.showInputDialog("Enter your guess for the second letter!: ");
			// if guess is correct message box will pop up and the label at bottom will be
			// updated
			if (letter4.equals("e")) {
				letterDisplayLabel.setText("LETTERS: " + "v" + "o" + "r" + letter4);
				JOptionPane.showMessageDialog(null, "Correct");

				// if guess is wrong then a message box will show up telling user to try again
			} else {
				JOptionPane.showMessageDialog(null, "Try Again");

			}
		}

		// if back button is clicked open the content frame and close this frame
		if (event.getSource() == backButton) {
			setVisible(false);
			new ContentFrame();

		}
		// if next button is clicked open the quiz frame and close this frame
		if (event.getSource() == nextButton) {
			setVisible(false);
			new QuizFrame();
		
		}
	}
}