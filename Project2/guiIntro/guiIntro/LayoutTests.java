package guiIntro;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;

public class LayoutTests extends JPanel
{


  public LayoutTests()
  {

    //Set layout manager of Frame to FlowLayout  CENTER hgap = 5, vgap = 5(setLayout)
    this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

    //Create JButton - Start
    JButton jb = new JButton("Start");


    //Creating a Serif font, Bold, and 24 point
    Font font = new Font("Serif",Font.BOLD , 24);

    //Set the font for the button  (Sets the preferred size of the button)
    jb.setFont(font);

    //Add an image to a label - use Bird.gif (Bird.gif must be in your project directory)
//    JLabel jlabel = new JLabel("Bird Pic",new ImageIcon("./guiIntro/Bird.gif"),JLabel.CENTER);
    JLabel jlabel = new JLabel("Bird Pic",new ImageIcon(this.getClass().getResource("/guiIntro/Bird.gif")),JLabel.CENTER);
    
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    //Add a text field (25 columns, Set default text to "Enter data here"
    JTextField jtf = new JTextField("Enter Data Here",25);

    //Set Text of JTextField to Cyan
    jtf.setForeground(Color.CYAN);

    //Set Color to Yellow
    jtf.setBackground(Color.GRAY);
    jtf.setFont(new Font("Times New Roman",Font.ITALIC,20));

    //Create a  Black Line Border of 2 pixels wide around the Button
    jb.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));


    //Add the components (Adds them left to right
    this.add(jb);
    this.add(jlabel);
    this.add(jtf);

    //Make visible
    setSize(300,500);

    setVisible(true);


  }
  public LayoutTests(int dummy1)
  {
    int i = 0;
    int j = 0;


    //Set layout manager of Frame to GridLayout
    JPanel outer_panel = new JPanel(new GridLayout(3,2));
    outer_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    //Add 3 rows x 2 columns consisting of  labels, and buttons
    for (i = 0; i < 3; i++)
    {
      
      
      for (j = 0; j < 2; j++)
      {
        String str_label = "Label " + (i+1) + "," + (j+1) ;
        String str_button = "Button " + (i+1) + "," + (j+1);

        //Create JLabel
        JLabel jlabel = new JLabel(str_label,JLabel.RIGHT);
        JButton jbutton = new JButton(str_button);

        //Add label then a button
       
        outer_panel.add(jlabel);
        outer_panel.add(jbutton);
      }
      //outer_panel.add(jp);
    }

    //Buffer
    JPanel jp = new JPanel();
    jp.add(outer_panel);
    this.add(jp,BorderLayout.CENTER);

    setSize(500,500);
    //pack();
    setVisible(true);

  }
  public LayoutTests(int dummy1, int dummy2)
  {

    int i = 0;
    int j = 0;


    //Set layout manager of Frame to FlowLayout
    this.setLayout(new GridLayout(3,4,5,5));

    //Add 3 rows x 2 columns consisting of  labels, and buttons
    for (i = 0; i < 3; i++)
    {
      for (j = 0; j < 2; j++)
      {
        String str_label = "Label " + (i+1) + "," + (j+1) ;
        String str_button = "Button " + (i+1) + "," + (j+1);

        //Create JLabel
        JLabel jlabel = new JLabel(str_label,JLabel.RIGHT);
        jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        JButton jbutton = new JButton(str_button);
       

        //Add label then a button
        this.add(jlabel);
        this.add(jbutton);
      }
    }

    setSize(300,500);
    setVisible(true);

  }
  
  public LayoutTests(int dummy1, int dummy2, int dummy3)
  {

    int i = 0;
    int j = 0;


    this.setLayout(new BorderLayout());

    JButton jb = new JButton("Start");
    Font font = new Font("Serif",Font.BOLD , 24);
    jb.setFont(font);
    JLabel jlabel = new JLabel("Bird Pic",new ImageIcon(this.getClass().getResource("/guiIntro/Bird.gif")),JLabel.CENTER);
    
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    JTextField jtf = new JTextField("Enter Data Here",25);
    jtf.setForeground(Color.CYAN);

    jtf.setBackground(Color.GRAY);
    jtf.setFont(new Font("Times New Roman",Font.ITALIC,20));
    jb.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));


    //Add the components (Adds them left to right
    this.add(jb, BorderLayout.CENTER);
    this.add(jlabel, BorderLayout.WEST);
    this.add(jtf, BorderLayout.SOUTH);

    //Make visible
    setSize(300,500);

    setVisible(true);

  }





}
