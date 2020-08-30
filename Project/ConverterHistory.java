/*
 *Afnan Mir
 *4th Period
 *Mr. Yee
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * class that creates the frame of the history of conversions
 */
class ConverterHistory extends JFrame /*implements ActionListener*/{
    private JTextField hist;
    private JButton clear;
    /**
     * creates the frame for the conversion history
     */
    public ConverterHistory(){
        setSize(750,750);
        setTitle("Unit Converter History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hist = new JTextField(50);
        clear = new JButton("Clear History");
        add(clear,BorderLayout.SOUTH);
        add(hist);
        //clear.addActionListener(this);
        setVisible(true);
    }
    /**
     * returns the clear button
     * @return the clear button
     */
    public JButton getClearButton(){
        return clear;
    }
    /**
     * clears the text in the history
     */
    public void clearText(){
        hist.setText("");
    }
    /**
     * adds a new entry to the history
     * @param start
     * @param end
     * @param s
     * @param e
     */
    public void addText(String start, String end, String s, String e){
        String in = hist.getText();
        hist.setForeground(Color.BLUE);
        in += start +" "+s+" = "+ end + " "+ e+"\n";
        hist.setText(in);
    }
    /*public void actionPerformed(ActionEvent e){
        if(((JButton)e.getSource()).getText().equals("Clear History")){
            hist.setText("");
        }
    }*/
}