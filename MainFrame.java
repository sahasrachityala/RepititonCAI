package RepititonCAI;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;

// this is the main frame class which is like the tittle to this program 
// in this class the user will have an option to choose from 3 different 
// classes which all have different tasks/activities that help them learn

//call the main method 
public class MainFrame extends JFrame implements ActionListener {

	// define all the GUi elements

	// this is for setting up the background gif
	private ImageIcon background = new ImageIcon("images/background1.gif");
	// scale the image so it fits the size of the frame
	private ImageIcon scaledBackground = new ImageIcon(
			background.getImage().getScaledInstance(1300, 800, java.awt.Image.SCALE_DEFAULT));
	private JLabel backgroundLabel = new JLabel(scaledBackground);

	// theze are the title and info labels ate the top of the screen as an
	// introuduction for users
	private JLabel titleLabel = new JLabel("CHAPTER 4/5 - REPETITION CAI!");
	private JLabel introLabel = new JLabel("Welcome to your quick guide to learning how to program ");
	private JLabel introLabel2 = new JLabel(" control structures repetition statements in java!\n");

	// there labels are used to give shorts description about each of the buttons
	private JLabel contentLabel = new JLabel("Learn The Content");
	private JLabel activityLabel = new JLabel("Apply Your Skills");
	private JLabel quizLabel = new JLabel("Test Your Knowledge");

	// these butttons will take user to other frames
	private JButton contentButton = new JButton("CONTENT");
	private JButton activityButton = new JButton("ACTIVITY");
	private JButton quizButton = new JButton("QUIZ");

	// this button will play music
	private JButton musicButton = new JButton("MUSIC");

	// this is used for playing the audio
	private Clip clip;

	public static JMenuBar menubar = new JMenuBar();

	// constructer method
	// setup the elements and specity bounds, color, size and etc
	public MainFrame() {

		// setup the frame
		setLayout(null);
		setTitle("REPITITION CAI MAIN FRAME!");
		setBackground(Color.WHITE);
		setSize(1300, 800);

		// add the background image to the frame
		backgroundLabel.setSize(1300, 700);
		backgroundLabel.setBounds(0, 0, 1300, 800);
		backgroundLabel.setLayout(null);
		add(backgroundLabel);

		// setup bounds,color, size etc for title label and add to background label
		titleLabel.setBounds(250, 100, 800, 55);
		titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 50));
		titleLabel.setForeground(new Color(171, 162, 196));
		titleLabel.setBackground(new Color(15, 7, 33));
		titleLabel.setOpaque(true);
		backgroundLabel.add(titleLabel);

		// setup bounds,color, size etc for intro label # 1 and add to background label
		introLabel.setBounds(240, 250, 845, 40);
		introLabel.setFont(new java.awt.Font("Times New Roman", 0, 35));
		introLabel.setForeground(Color.WHITE);
		introLabel.setBackground(new Color(111, 111, 157));
		introLabel.setOpaque(true);
		backgroundLabel.add(introLabel);

		// setup bounds,color, size etc for intro label # 2 and add to background label
		// there are two labels as there are two sentences but on different lines
		introLabel2.setBounds(300, 310, 730, 40);
		introLabel2.setFont(new java.awt.Font("Times New Roman", 0, 35));
		introLabel2.setForeground(Color.WHITE);
		introLabel2.setBackground(new Color(111, 111, 157));
		introLabel2.setOpaque(true);
		backgroundLabel.add(introLabel2);

		// setup the contents discription label and specify color, size etc
		contentLabel.setBounds(130, 450, 290, 35);
		contentLabel.setFont(new java.awt.Font("Times New Roman", 0, 35));
		contentLabel.setForeground(Color.WHITE);
		contentLabel.setBackground(new Color(171, 162, 196));
		contentLabel.setOpaque(true);
		backgroundLabel.add(contentLabel);

		// setup the activity discription label and specify color, size etc
		activityLabel.setBounds(540, 450, 290, 30);
		activityLabel.setFont(new java.awt.Font("Times New Roman", 0, 35));
		activityLabel.setForeground(Color.WHITE);
		activityLabel.setBackground(new Color(171, 162, 196));
		activityLabel.setOpaque(true);
		backgroundLabel.add(activityLabel);

		// setup the quiz discription label and specify color, size etc
		quizLabel.setBounds(910, 450, 340, 35);
		quizLabel.setFont(new java.awt.Font("Times New Roman", 0, 35));
		quizLabel.setForeground(Color.WHITE);
		quizLabel.setBackground(new Color(171, 162, 196));
		quizLabel.setOpaque(true);
		backgroundLabel.add(quizLabel);

		// add the content button that opens the content frame
		contentButton.setBounds(180, 550, 200, 40);
		contentButton.setFont(new java.awt.Font("Times New Roman", 0, 40));
		contentButton.setForeground(Color.WHITE);
		contentButton.setBackground(new Color(111, 111, 157));
		contentButton.setOpaque(true);
		contentButton.setBorder(new EtchedBorder(EtchedBorder.RAISED)); // this adds a border around the button
		contentButton.addActionListener(this); // this ensures the button listens to the action listener bellow
		backgroundLabel.add(contentButton);

		// add the activity button that opens the activity frame
		activityButton.setBounds(580, 550, 200, 40);
		activityButton.setFont(new java.awt.Font("Times New Roman", 0, 40));
		activityButton.setForeground(Color.WHITE);
		activityButton.setBackground(new Color(111, 111, 157));
		activityButton.setOpaque(true);
		activityButton.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		activityButton.addActionListener(this); // this ensures the button listens to the action listener bellow
		backgroundLabel.add(activityButton);

		// add the quiz button that opens the quiz frame
		quizButton.setBounds(980, 550, 200, 40);
		quizButton.setFont(new java.awt.Font("Times New Roman", 0, 40));
		quizButton.setForeground(Color.WHITE);
		quizButton.setBackground(new Color(111, 111, 157));
		quizButton.setOpaque(true);
		quizButton.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		quizButton.addActionListener(this); // this ensures the button listens to the action listener bellow

		musicButton.setBounds(590, 650, 180, 30);
		musicButton.setFont(new java.awt.Font("Times New Roman", 0, 25));
		musicButton.setForeground(Color.BLACK);
		musicButton.setBackground(new Color(111, 111, 157));
		musicButton.setOpaque(true);
		musicButton.addActionListener(this);
		backgroundLabel.add(musicButton);

		backgroundLabel.add(quizButton);

		setupMenuBar();
		setJMenuBar(menubar);

		// set visible to true so all these elements appear on the screen
		setVisible(true);

	}

	// this method allows for the background music to exist
	// I was inspired to use this code by a freind Ramyan 
	private void playSound(String soundFile) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
			event.printStackTrace();
		}
	}

	// this method allows the user to also stop the msuic using the same button
	
	private void stopSound() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}

	// this method is used to setup the menu bar and its differnt options 
	
	public void setupMenuBar() {
		// setup the the first menu
		JMenu options = new JMenu("OPTIONS");
		menubar.add(options);

		// add differnt items inside the menu
		// this will let you exit the game fully
		JMenuItem exit = new JMenuItem("QUIT");
		options.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// this will take u back to the opening screen
		JMenuItem home = new JMenuItem("HOME");
		options.add(home);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == home) {
					setVisible(false);
					new MainFrame();
				}
			}
		});

		// this takes you to the content screen
		JMenuItem content = new JMenuItem("CONTENT");
		options.add(content);
		content.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == content) {
					new ContentFrame();
				}
			}

		});

		// this takes you to the activity screen
		JMenuItem activity = new JMenuItem("ACTIVITY");
		options.add(activity);
		activity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == activity) {
					new ActivityFrame();
				}
			}

		});

		// this takes you to the quiz screen
		JMenuItem quiz = new JMenuItem("QUIZ");
		options.add(quiz);
		quiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == quiz) {
					new QuizFrame();
				}
			}

		});

		// this starts playing the music
		JMenuItem music = new JMenuItem("PLAY MUSIC");
		options.add(music);
		music.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == music) {
					if (clip == null || !clip.isRunning()) {
						playSound("audios/gameMusic.wav");
						musicButton.setText("STOP MUSIC");
					}
				}
			}

		});
		// this stops playing the music
		JMenuItem stopMusic = new JMenuItem("STOP MUSIC");
		options.add(stopMusic);
		stopMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == stopMusic) {
					stopSound();
				}
			}

		});

	}

	// action lister method ensures the buttons and functions all have outputs
	@Override
	public void actionPerformed(ActionEvent event) {

		// add action listen for the first button so that when clicked the content frame
		// will open up
		if (event.getSource() == contentButton) {
			setVisible(false);
			new ContentFrame();
		}

		// add action listner for the second button so when clicked the activity game
		// will open up
		if (event.getSource() == activityButton) {
			setVisible(false);
			new ActivityFrame();
		}
		// add action listner for the third button so when clicked the quiz frame will
		// open up
		if (event.getSource() == quizButton) {
			setVisible(false);
			new QuizFrame();

		}
		// this button allwos user to stop and start the background music
		if (event.getSource() == musicButton) {
			if (clip == null || !clip.isRunning()) {
				playSound("audios/gameMusic.wav");
				musicButton.setText("STOP MUSIC");
			} else {
				stopSound();
				musicButton.setText("MUSIC");
			}
		}
	}
}
