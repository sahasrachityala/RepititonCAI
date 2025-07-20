
/*
Name(s): Sahasra Chityala

Date: Friday June 14th 2024 

Course Code:  ICS3U1-01 , Mr.Fernandes

Title: FSP Project - Repetition CAI 

Description: This program is a CAI for Repetition Structures mainly from chapters 4 and 5 of the textbook. The program consists of a main frame that gives users access to the other three frames. The first frame will be a concept frame that teaches users about the three main loops ( while loop, do-while loop, and for loop). The second frame will be a mini-activity for the user to apply the knowledge they just learned. This has 4 fill in the blank related questions which will each give the user a letter. The user will then descramble the letters to find the secret word. The last frame is a quiz frame that has 6 different multiple-choice questions which will be used to test the users understanding of the theory behind each loop. 

Features:
- Label that only displays the correct letter values after the user inputs their guesses - Activity Frame
- Score Label that displays if the user failed or passed based on the number of questions they get correct - QuizFrame 
-JMenuBar in all the frames for easier navigation 
- Input dialogue boxes used to receive users' guess 
- Output dialogue boxes were used to display if the user was correct or not 
- Variety of Swing elements used for quiz - Quiz Frame 
- Music (NightCrawler - Travis Scott )in the background - mainframe 
- Option to stop/start music in Menu Bar for all the frames 
- Clear Panel to have a unique background look - Concept Frame 
- Textfield to get users' secret word guess and based on that message boxes appear - Activity frame 

Major Skills:
-If else statements 
-Arrays 
-Methods 
-Radio buttons 
-Comboboxes 
-Gif images 
-Audios 
-JButtons
-JLabels 
-JTextField
-JOptionPane
-JScrollPane 
-Dialogue Box
-JPanels 
-JCheckBoxes
-Image Scaling 

Areas of Concern:
- During the planning phase, I intended to have another class to help with the code for the Activity frame. 
	The class would've been called GuessWord. However, after I started coding I realized I didn't need the extra 
	class anymore and it's alot easier to keep it in one class. 
- When i use a scroll bar in the panel for the concepts screen the content keeps appearing horizontally one after
  	the other, so to work around that I used a grid layout which makes the frame a little different from the design phase. 
- Most of my code was already known from pervious projects which i looked back at here and there but the few extra 
	sources I used for help are referenced in the code!

 */
package RepititonCAI;

public class RepititionApplication {
	
	public static void main (String[] args) {
		
		new MainFrame();
	}

}
