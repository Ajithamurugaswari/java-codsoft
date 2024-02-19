import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class Quiz extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookMark;
    ButtonGroup bg;
    int count = 0, current = 0;
    int x = 1, y = 1, now = 0;
    int m[] = new int[10];
    
    Quiz()
    {

        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i = 0; i<5 ; i++)
        {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookMark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookMark.addActionListener(this);
        add(btnNext);
        add(btnBookMark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookMark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }
    
    public void actionPerformed(ActionEvent ae )
    {
        if(ae.getSource() == btnNext)
        {
            if(check())
            {
                count = count + 1;
            }
            current++;
            set();
            if(current == 5)
            {
                btnNext.setEnabled(false);
                btnBookMark.setText("Result");
            }
        }
        
        if(ae.getActionCommand().equals("Bookmark"))
        {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30*x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if(current == 5)
            {
                btnBookMark.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }
        
        for(int i = 0, y =1; i<x; i++,y++)
        {
            if(ae.getActionCommand().equals("Bookmarks" + y))
            {
                if(check())
                {
                    count = count + i;
                }
                now = current;
                current = m[y];
                set();
                ((JButton)ae.getSource()).setEnabled(false);
                current = now;
            }
        }
        
        if(ae.getActionCommand().equals("Result"))
        {
            if(check())
            {
                count = count + 1;
            }
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answer = " + count);
            System.exit(0);
        }
    }
    
    void set()
    {
        radioButton[4].setSelected(true);
        if(current == 0)
        {
            label.setText("Q1) which one is latest version in java");
            radioButton[0].setText("java 21");
            radioButton[1].setText("java 5");
            radioButton[2].setText("java 28");
            radioButton[3].setText("java 9");
        }
        
        if(current == 1)
        {
            label.setText("Q2) who was the founder of java");
            radioButton[0].setText("Dennie Ritchus");
            radioButton[1].setText("James Gosling");
            radioButton[2].setText("Guido van Rossum");
            radioButton[3].setText("James Robert");
        }
        
        if(current == 2)
        {
            label.setText("Q3) what are the frameworks in java");
            radioButton[0].setText("Springboot");
            radioButton[1].setText("django");
            radioButton[2].setText("React");
            radioButton[3].setText("cherrypy");
        }
        
        if(current == 3)
        {
            label.setText("Q4) Which one is easiest language");
            radioButton[0].setText("python");
            radioButton[1].setText("java");
            radioButton[2].setText("c");
            radioButton[3].setText("None of the above");
        }
        
        if(current == 4)
        {
            label.setText("Q5) Sand is _____ in water");
            radioButton[0].setText("Soluble");
            radioButton[1].setText("Insoluble");
            radioButton[2].setText("Both");
            radioButton[3].setText("None of the above");
        }
        
        label.setBounds(30, 40, 450, 20);
        for(int i = 0, j = 0; i<=90; i+=30, j++)
        {
            radioButton[j].setBounds(50, 80 + i, 200, 20);
        }
    }
    
    boolean check()
    {
        if(current == 0)
        {
            return (radioButton[0].isSelected());
        }
        
        if(current == 1)
        {
            return (radioButton[1].isSelected());
        }
        
        if(current == 2)
        {
            return (radioButton[0].isSelected());
        }
        
        if(current == 3)
        {
            return (radioButton[0].isSelected());
        }
        
        if(current == 4)
        {
            return (radioButton[1].isSelected());
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        new Quiz();
}