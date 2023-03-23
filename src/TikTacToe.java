import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TikTacToe implements ActionListener
{
    JFrame frame = new JFrame();                                //FOR FRAME
    JLabel textfield =new JLabel("TICK TAC TOE");           //LABEL TO DISPLAY AS TITLE OF GAME
    JPanel title_panel = new JPanel();                           //PANEL FOR TITLE
    TikTacToe()                                                    //CONSTRUCTOR
    {

        frame.setSize(600,600);                                             //TO SET FRAME PROPERTIES
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setResizable(false);

        frame.setLocation(600,200);


        //textfield.setBackground(Color.BLUE);
        textfield.setForeground(new Color(25,250,0));
        textfield.setBounds(120,2,400,70);
        textfield.setFont(new Font("Ink Free",Font.BOLD,40));


        title_panel.setBounds(0,0,600,50);
        title_panel.setBackground(new Color(0,0,0,255));
        title_panel.add(textfield);


        frame.add(textfield);

        frame.add(title_panel);

        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
