package RepititonCAI;

//Import all the different elements needed to run the code 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

// this is the content frame that will teach the user about the different loops 
// it will contain the flow charts describing each one and then step by step 
// instrcutions on how to make each one and the best time to use each different loop 
public class ContentFrame extends JFrame implements ActionListener {

	// define all the different elements that will be used in the frame

	// add the background gif image and change it into label
	private ImageIcon background = new ImageIcon("images/background1.gif");
	// scale the image so its same size as the frame
	private ImageIcon scaledBackground = new ImageIcon(
			background.getImage().getScaledInstance(1000, 800, java.awt.Image.SCALE_DEFAULT));
	private JLabel backgroundLabel = new JLabel(scaledBackground);

	// WHILE LOOP IMAGES
	// scale the picture that displays the flowchart for while loops
	private ImageIcon whileLoopOriginal = new ImageIcon("images/whileloop.png");
	private ImageIcon whileLoop = new ImageIcon(
			whileLoopOriginal.getImage().getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH));
	private JLabel whileLoopImage = new JLabel(whileLoop);

	// scale the picture that displays the example code for while loops
	private ImageIcon whileExampleOriginal = new ImageIcon("images/whileLoopExample.gif");
	private ImageIcon whileLoopExample = new ImageIcon(
			whileExampleOriginal.getImage().getScaledInstance(350, 250, java.awt.Image.SCALE_DEFAULT));
	private JLabel whileExampleImage = new JLabel(whileLoopExample);

	// DO-WHILE LOOP IMAGES
	// scale the picture that displays the flowchart for do while loops
	private ImageIcon doWhileLoopOriginal = new ImageIcon("images/doWhileChart.png");
	private ImageIcon doWhileLoop = new ImageIcon(
			doWhileLoopOriginal.getImage().getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH));
	private JLabel doWhileLoopImage = new JLabel(doWhileLoop);

	// scale the picture that displays the example code for do while loops
	private ImageIcon doWhileExampleOriginal = new ImageIcon("images/doWhileCode.png");
	private ImageIcon doWhileLoopExample = new ImageIcon(
			doWhileExampleOriginal.getImage().getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH));
	private JLabel doWhileExampleImage = new JLabel(doWhileLoopExample);

	// FOR LOOP IMAGES
	// scale the picture that displays the flowchart for while loops
	private ImageIcon forLoopOriginal = new ImageIcon("images/forLoopChart.png");
	private ImageIcon forLoop = new ImageIcon(
			forLoopOriginal.getImage().getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH));
	private JLabel forLoopImage = new JLabel(forLoop);

	// scale the picture that displays the example code for while loops
	private ImageIcon forExampleOriginal = new ImageIcon("images/forLoopExample.png");
	private ImageIcon forLoopExample = new ImageIcon(
			forExampleOriginal.getImage().getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH));
	private JLabel forExampleImage = new JLabel(forLoopExample);

	// add a panel as the bakcground so we can later use a scroll pane
	private JPanel backgroundpanel = new JPanel();

	// add a title image to make it asthetic
	private ImageIcon title = new ImageIcon("images/titleLabel.png");

	// scale the image so its same size as the frame
	private ImageIcon titleImage = new ImageIcon(
			title.getImage().getScaledInstance(800, 100, java.awt.Image.SCALE_DEFAULT));
	private JLabel titleLabel = new JLabel(titleImage);

	// when setting up the Label use <br> and </html> to add multiple lines and
	// words into one label
	// this is use to save time and space as its no longer nessiccary to make
	// multiple labels for each line
	// This is the information label that tells the user what the follwing frame is
	// about
	private JLabel infoLabel = new JLabel(
			"" + "<html>Control structures and repetition statements in Java are mainly made up of Loops.<br>"
					+ "Loops is the process of having a specific part of the program repeated when output <br>"
					+ "until desired amounts ( boolean amounts). The three main loops we will be learning  <br>"
					+ "     are While Loops, Do - While Loops, and For Loops.<br>" + "<br>" + "</html>");

	// WHILE LOOP LABELS
	// add a label to introduce the users to while loops and when its best to use
	// them
	private JLabel whileloopLabel = new JLabel("" + "<html>  WHILE LOOPS: <br>"
			+ "    This is a loop that will repeat until a set of criteria becomes false. The code will <br>"
			+ "   check to see if it satisfies the given condition, then it willexecute and then repeat the same <br>"
			+ "   steps.Eventually when the condition is no longer satisfied, it will stop/ skip to the next part. <br>"
			+ "   These loops are best to use when you don't know the number of repetitions beforehand. <br>" + "<br>"
			+ "</html>");
	// add a label that teaches user how to make a while loop step by step
	private JLabel whileStepsLabel = new JLabel("" + "<html>    Steps :<br> "
			+ "   1. After calling main method the first step would be to initialize a count ( set to 1)  <br>"
			+ "   which will help us with setting up the condition. <br>"
			+ "   2. In the bracket of the while loop, specify the condition <br>"
			+ "   3. Type out the desired code in the body of the while loop <br>"
			+ "   4. Type in “count ++” which allows the counter to go up by 1 each time the code gets  <br>"
			+ "   executed if the counter doesn't increase, condition will always be true so loop wont end. <br>"
			+ "   5. After the body is closed type out a print statement <br>" + "<br>" + "</html>");

	// DO WHILE LOOP LABELS
	// add a label to introduce the users to do-while loops and when its best to use
	// them
	private JLabel doWhileloopLabel = new JLabel("" + "<html>  DO-WHILE LOOPS: <br>"
			+ "   A do-while loop will execute the code in the body firstand then check the condition to either  <br>"
			+ "   exit or repeat. These are best to use when you want the condition/ code To appear at least once <br>"
			+ "   An example includes asking the user a question since it will appear and based on the results <br>"
			+ "	  of the user it will repeat or not<br>" + "<br>" + "</html>");

	// add a step by step guide to show user how to make a do while loop
	private JLabel doWhileStepsLabel = new JLabel("" + "<html>    Steps :<br> "
			+ "   1. Since this program is asking user for input type in proper code\n <br>"
			+ "   2. Define the variable that will be taking in users inpu <br>"
			+ "   3. Type in the do and fill the body with preferred code <br>"
			+ "   4. Then type the while loop with the condition in the code which will cause the  <br>"
			+ "   body to only be repeated if this is satisfied  <br>"
			+ "   5. End the code with a print statement  <br>" + "<br>" + "</html>");

	// FOR LOOP LABELS
	// add a label to introduce the users to do-while loops and when its best to use
	// them
	private JLabel forLoopLabel = new JLabel("" + "<html>  FOR LOOPS: <br>"
			+ " These loops are best to use when we know the number of times to repeat a certain code. <br>"
			+ " The code will run until the given condition is satisfied these loops are pretty simple <br> "
			+ " as the majority of the the components needed are in only one line! Make sure not to  <br>"
			+ " confuse the three different parts for loop statements as that a very common error. <br>" + "<br>"
			+ "</html>");

	// FOR LOOP LABELS
	// add a step by step guide to show user how to make a do while loop
	private JLabel ForLoopStepsLabel = new JLabel("" + "<html>    Steps :<br> "
			+ "   1. After calling the main method initialize a variable used to track the loops (counter) <br>"
			+ "   2. Next, make a for statement which is made up of three parts <br>"
			+ "   3. The first part is to initialize what number the counter will start from <br>"
			+ "   4. The second part is the gove the condition in which the loop will end <br>"
			+ "   5. The third part is to specify how much the counter will be incremented each loop <br>"
			+ "   6.  Then add the preferred continents in the body of the loop <br> "
			+ "   7. Finally, end with a blank print statement to skip a line for every loop. <br>" + "<br>"
			+ "</html>");

	// add a scroll pane to show more content on one frame
	private JScrollPane scrollPane;

	// add the bottons to make it easier to navigate from one frame to the other
	private JButton backButton = new JButton("BACK");
	private JButton nextButton = new JButton("NEXT");

	// this is the constructer method
	// setup the different elements in the frame specify there size, bounds, color
	// etc
	public ContentFrame() {

		// setup the frame
		setLayout(null);
		setTitle("CONTENT");
		setSize(1000, 800);

		// setup the background labels bounds
		// this is not apart of the panel since otherwise the background would disapear
		// after scrolling a little
		backgroundLabel.setBounds(0, 0, 1000, 800);
		add(backgroundLabel);

		// setup the layout for the panel and make it clear so the background can be
		// visible from the back
		// its no longer nessicary to add bounds to the elements since the layout isnt
		// NULL
		backgroundpanel.setLayout(new GridLayout(15, 2));
		backgroundpanel.setOpaque(false);

		// add all the elements (labels, images , etc) to the panel so they can all work
		// alligned with the scroll bar

		// setup the size, color etc for the title label
		titleLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(titleLabel);

		// setup the size, color etc for the info label
		infoLabel.setFont(new java.awt.Font("Times New Roman", 0, 28));
		infoLabel.setForeground(new Color(111, 111, 157));
		infoLabel.setBackground(new Color(15, 7, 33));
		infoLabel.setOpaque(true);
		backgroundpanel.add(infoLabel);

		// WHILE LOOP ELEMENTS
		// introduce the users to while loop and best time to use it
		whileloopLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		whileloopLabel.setForeground(Color.WHITE);
		whileloopLabel.setBackground(new Color(111, 111, 157));
		whileloopLabel.setOpaque(true);
		backgroundpanel.add(whileloopLabel);

		// setup the while loop flowchart image
		whileLoopImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(whileLoopImage);

		// add the label that gives step by step instuctions on how to make a while loop
		whileStepsLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		whileStepsLabel.setForeground(Color.WHITE);
		whileStepsLabel.setBackground(new Color(111, 111, 157));
		whileStepsLabel.setOpaque(true);
		backgroundpanel.add(whileStepsLabel);

		// add the image that has the example code
		whileExampleImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(whileExampleImage);

		// DO WHILE LOOP ELEMENTS
		// add the introduction label that teaches user about do while loops
		doWhileloopLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		doWhileloopLabel.setForeground(Color.WHITE);
		doWhileloopLabel.setBackground(new Color(111, 111, 157));
		doWhileloopLabel.setOpaque(true);
		backgroundpanel.add(doWhileloopLabel);

		// add the image that shows flowchart of how the loop works
		doWhileLoopImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(doWhileLoopImage);

		// this shows the steps on how to make a do while loop
		doWhileStepsLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		doWhileStepsLabel.setForeground(Color.WHITE);
		doWhileStepsLabel.setBackground(new Color(111, 111, 157));
		doWhileStepsLabel.setOpaque(true);
		backgroundpanel.add(doWhileStepsLabel);

		// add image that shows an example code
		doWhileExampleImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(doWhileExampleImage);

		// FOR LOOP ELEMENTS
		// introduce user to for loops and warn them about common erros
		forLoopLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		forLoopLabel.setForeground(Color.WHITE);
		forLoopLabel.setBackground(new Color(111, 111, 157));
		forLoopLabel.setOpaque(true);
		backgroundpanel.add(forLoopLabel);

		// this is the flowchart of the for loop shoing how the loop works
		forLoopImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(forLoopImage);

		// this shows the steps on how to make a for loop
		ForLoopStepsLabel.setFont(new java.awt.Font("Times New Roman", 0, 25));
		ForLoopStepsLabel.setForeground(Color.WHITE);
		ForLoopStepsLabel.setBackground(new Color(111, 111, 157));
		ForLoopStepsLabel.setOpaque(true);
		backgroundpanel.add(ForLoopStepsLabel);

		// setup the image with the example code
		forExampleImage.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backgroundpanel.add(forExampleImage);

		// add a scroll pane
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(0, 0, 980, 700);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(backgroundpanel);
		backgroundLabel.add(scrollPane);

		// add the back and next button and setup there colour, bounds, etc
		// we add these to the background label instead of panel so the user will always
		// have the option
		// to use the bottons even if they scroll down or not
		// since background Label is null layout you must use bounds again.
		backButton.setBounds(50, 700, 100, 30);
		backButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(new Color(111, 111, 157));
		backButton.setOpaque(true);
		backButton.addActionListener(this);
		backgroundLabel.add(backButton);

		nextButton.setBounds(800, 700, 100, 30);
		nextButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		nextButton.setForeground(Color.BLACK);
		nextButton.setBackground(new Color(111, 111, 157));
		nextButton.setOpaque(true);
		nextButton.addActionListener(this);
		backgroundLabel.add(nextButton);

		// call the menubar from the mainframe to allow the menu bar to appear on this
		// frame too
		setJMenuBar(MainFrame.menubar);

		// set visible to true so everything appears on the screen
		setVisible(true);

	}

	// action lister method ensures the buttons and functions all have proper
	// outputs
	@Override
	public void actionPerformed(ActionEvent event) {

		// if back button is clicked open the main frame and close content frame
		if (event.getSource() == backButton) {
			setVisible(false);
			new MainFrame();

		}
		// if back next is clicked open the activity frame and close content frame
		if (event.getSource() == nextButton) {
			setVisible(false);
			new ActivityFrame();
		}
	}
}
