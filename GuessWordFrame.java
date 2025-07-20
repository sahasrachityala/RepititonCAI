package RepititonCAI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuessWordFrame {

	public  String letter1;
	public String letter2;
	public String letter3;
	public String letter4;
	public String guessWord;
    private JLabel letterDisplayLabel;

  

    public void guessLetter1() {
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

    public void guessLetter2() {
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

    public void guessLetter3() {
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


    public void guessLetter4() {
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
  

    public void guessWord(String guessWord) {
    	// output a dialog box depending on the input recived
    				// the correct answer is over
    				if (guessWord.equalsIgnoreCase("Guess Word: over")) {
    					JOptionPane.showMessageDialog(null,
    							"YOU GUESSED CORRECT! : SECRET WORD IS OVER BECAUSE LOOPS REPEAT OVER AND OVER AGAIN!");

    					// if guess is wrong then a message box will show up telling user to try again
    				} else {
    					JOptionPane.showMessageDialog(null, "TRY AGAIN");
    				}
    }
}

