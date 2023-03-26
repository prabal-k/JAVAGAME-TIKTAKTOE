import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class TikTacToe implements ActionListener {
    JFrame frame = new JFrame();                                //FOR FRAME
    JLabel textfield = new JLabel("TICK TAC TOE");           //LABEL TO DISPLAY AS TITLE OF GAME
    JPanel title_panel = new JPanel();                          //PANEL FOR TITLE
    JPanel button_panel = new JPanel();

    JButton[] buttons = new JButton[9];
    Random random = new Random();
    JTextField txt = new JTextField();
    JPanel panel2 = new JPanel();
    int turn, k = 0;

    TikTacToe()                                                    //CONSTRUCTOR
    {
        //FOR MAIN FRAME//
        frame.setSize(600, 700);                                             //TO SET FRAME PROPERTIES
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setResizable(false);
        frame.setLocation(600, 200);


        //LABEL FOR TITILE OF GAME

        //textfield.setBackground(Color.BLUE);
        textfield.setForeground(new Color(25, 250, 0));
        textfield.setBounds(120, 5, 400, 70);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 40));
        frame.add(textfield);


        //FOR PANEL USED IN TITLE
        title_panel.setBounds(0, 0, 600, 60);
        title_panel.setBackground(new Color(25, 25, 25));
        title_panel.add(textfield);
        title_panel.setLayout(null);
        frame.add(title_panel, BorderLayout.NORTH);


        //FOR 2ND PANEL WHERE BUTTONS ARE TO BE PLACED

        //button_panel.setBackground(new Color(20,30,40));
        button_panel.setBounds(0, 60, 600, 600);
        button_panel.setLayout(new GridLayout(3, 3));                //TO CREATE A 3*3 GRID IN BUTTON PANEL FOR BUTTONS
        // button_panel.setBackground(new Color(255));
        //button_panel.setForeground(new Color(255));
        frame.add(button_panel);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setFocusable(false);

        }
        frame.setVisible(true);
        first_turn();
        for (int i = 0; i < 9; i++) {
            buttons[i].addActionListener(this);
        }


    }

    @Override

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]) {                                                                //IT LETS ONE BUTTON TO BE PRESSED AT ONE TIME
                if (turn == 0) {
                   if (buttons[i].getText() == "") {                                                      //IT DOES NOT LET TO OVERWRITE THE PREVIOUS VALUE
                        buttons[i].setText("O");
                        buttons[i].setForeground(Color.BLUE);

                        buttons[i].setFont(new Font("Inkfree", Font.ITALIC, 120));
                        textfield.setText("X'S turn");
                        turn = 1;
                        check();
                   }
                } else {
                    if (buttons[i].getText() == "")                                                              //IT DOES NOT LET TO OVERWRITE THE PREVIOUS VALUE
                        buttons[i].setText("X");
                    buttons[i].setFont(new Font("Inkfree", Font.ITALIC, 120));
                    textfield.setText("O'S turn");
                    buttons[i].setForeground(Color.RED);
                    turn = 0;
                    check();
                }
            }
        }
    }
    void check()
    {
        //CONDITION FOR X WINS
        if(buttons[0].getText()=="X"&&buttons[1].getText()=="X"&&buttons[2].getText()=="X")
            {
                x_wins();
            }
        if(buttons[3].getText()=="X"&&buttons[4].getText()=="X"&&buttons[5].getText()=="X")
        {
            x_wins();
        }
        if(buttons[6].getText()=="X"&&buttons[7].getText()=="X"&&buttons[8].getText()=="X")
        {
            x_wins();
        }
        if(buttons[0].getText()=="X"&&buttons[3].getText()=="X"&&buttons[6].getText()=="X")
        {
            x_wins();
        }
        if(buttons[1].getText()=="X"&&buttons[4].getText()=="X"&&buttons[7].getText()=="X")
        {
            x_wins();
        }
        if(buttons[2].getText()=="X"&&buttons[5].getText()=="X"&&buttons[8].getText()=="X")
        {
            x_wins();
        }
        if(buttons[0].getText()=="X"&&buttons[4].getText()=="X"&&buttons[8].getText()=="X")
        {
            x_wins();
        }
        if(buttons[2].getText()=="X"&&buttons[4].getText()=="X"&&buttons[6].getText()=="X")
        {
            x_wins();
        }


        //CONDITION FOR Y WINS
        if(buttons[0].getText()=="O"&&buttons[1].getText()=="O"&&buttons[2].getText()=="O")
        {
            y_wins();
        }
        if(buttons[3].getText()=="O"&&buttons[4].getText()=="O"&&buttons[5].getText()=="O")
        {
            y_wins();
        }
        if(buttons[6].getText()=="O"&&buttons[7].getText()=="O"&&buttons[8].getText()=="O")
        {
            y_wins();
        }
        if(buttons[0].getText()=="O"&&buttons[3].getText()=="O"&&buttons[6].getText()=="O")
        {
            y_wins();
        }
        if(buttons[1].getText()=="O"&&buttons[4].getText()=="O"&&buttons[7].getText()=="O")
        {
            y_wins();
        }
        if(buttons[2].getText()=="O"&&buttons[5].getText()=="O"&&buttons[8].getText()=="O")
        {
            y_wins();
        }
        if(buttons[0].getText()=="O"&&buttons[4].getText()=="O"&&buttons[8].getText()=="O")
        {
            y_wins();
        }
        if(buttons[2].getText()=="O"&&buttons[4].getText()=="O"&&buttons[6].getText()=="O")
        {
            y_wins();
        }



    }
    void x_wins()
    {
        textfield.setText("X'S wins");
        for(int i=0;i<9;i++)
        {
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(false);
        }

    }
    void y_wins()
    {
        textfield.setText("O'S wins");
        for(int i=0;i<9;i++)
        {
            buttons[i].setBackground(Color.BLUE);
            buttons[i].setEnabled(false);
        }

    }



    void first_turn()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Ac");
        turn = random.nextInt(2);
        if(turn == 0)
        {
            textfield.setBounds(200,5,400,70);
            textfield.setText("0's TURN");
        }
        else
        {
            textfield.setBounds(200,5,400,70);
            textfield.setText("X's TURN");
        }
    }



}
