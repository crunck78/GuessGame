import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class GuessGame {
     private JPanel mainPanel;
     private JLabel tryCounter;
     private JLabel guessResult;
     private JButton takeGuess;
     private JTextField numberInput;

     int counter = 0;
     int guess;
     int random = genRandNum();

     public int genRandNum(){
          return ThreadLocalRandom.current().nextInt(0, 100 + 1);
     }

     public GuessGame() {
          takeGuess.addActionListener(e -> {
               counter++;
               tryCounter.setText(String.valueOf(counter));
               guess = Integer.parseInt(numberInput.getText());
               if(guess < random){
                    guessResult.setText("Falsch!! Die Zahl ist größer");
               }

               if(guess > random){
                    guessResult.setText("Falsch!! Die Zahl ist kleiner");
               }

               if(guess == random){
                    guessResult.setText("Richtig!! Die Zahl ist "+ random);
               }
               numberInput.setText("");
          });
     }

     public static void main(String[] args){

          JFrame frame = new JFrame("GuessGame");
          frame.setContentPane(new GuessGame().mainPanel);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.pack();
          frame.setVisible(true);
     }
}
