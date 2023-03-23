import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TikTacToe implements ActionListener
{
    JFrame frame = new JFrame();                                //FOR FRAME
    JLabel textfield =new JLabel("TICK TAC TOE");           //LABEL TO DISPLAY AS TITLE OF GAME
    JPanel title_panel = new JPanel();                          //PANEL FOR TITLE
    JPanel button_panel = new JPanel();

    JButton[] buttons = new JButton[9];
    TikTacToe()                                                    //CONSTRUCTOR
    {
            //FOR MAIN FRAME//
        frame.setSize(600,700);                                             //TO SET FRAME PROPERTIES
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setResizable(false);
        frame.setLocation(600,200);


            //LABEL FOR TITILE OF GAME

        //textfield.setBackground(Color.BLUE);
        textfield.setForeground(new Color(25,250,0));
        textfield.setBounds(120,5,400,70);
        textfield.setFont(new Font("Ink Free",Font.BOLD,40));
        frame.add(textfield);


            //FOR PANEL USED IN TITLE
        title_panel.setBounds(0,0,600,60);
        title_panel.setBackground(new Color(0,0,0,255));
        title_panel.add(textfield);
        title_panel.setLayout(null);
        frame.add(title_panel,BorderLayout.NORTH);


                //FOR 2ND PANEL WHERE BUTTONS ARE TO BE PLACED

        button_panel.setBackground(new Color(20,30,40));
        button_panel.setBounds(0,60,600,600);
        button_panel.setLayout(new GridLayout(3,3));                //TO CREATE A 3*3 GRID IN BUTTON PANEL FOR BUTTONS
        frame.add(button_panel);


        for(int i=0;i<9;i++)
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);

            buttons[i].addActionListener(this);

        }
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
