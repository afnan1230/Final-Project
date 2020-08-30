/*
 *Afnan Mir
 *4th Period
 *Mr. Yee
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * class that adds the converter and history into one component
 */
public class UnitComponent extends JComponent implements ActionListener, MouseListener{
    private UnitConverter con;
    private ConverterHistory h;
    /**
     * creates the component with the converter and history
     */
    public UnitComponent() throws Exception{
        con = new UnitConverter();
        h = new ConverterHistory();
        con.getConvertButton().addActionListener(this);
        h.getClearButton().addActionListener(this);
        con.addMouseListener(this);
    }
    /**
     * checks if a button is pressed and if its the convert button it will convert and if it is the clear button it will clear the text of the history
     * @param e the event of a button being pressed
     */
    public void actionPerformed(ActionEvent e){
        if(((JButton)e.getSource()).getText().equals("Convert")){
            con.convert();
            h.addText(con.getStart(), con.getEnd(), con.getUnit()[0], con.getUnit()[1]);
        }else if(((JButton)e.getSource()).getText().equals("Clear History")){
            h.clearText();
        }
        
    }
    /**
     * checks to see if mouse is pressed on the frame and if it is convert
     * @param e the event of a mouse being clicked
     */
    public void mousePressed(MouseEvent e){
        try{
        con.convert();
        h.addText(con.getStart(), con.getEnd(), con.getUnit()[0], con.getUnit()[1]);
        }catch(NumberFormatException ex){// catches if no input is found or wrong input is found

        }
    }
    /**
    * method not used
    @param event not used
    */
   public void mouseReleased(MouseEvent event) {}
   /**
    * method not used
    @param event not used
    */
   public void mouseClicked(MouseEvent event) {}
   /**
    * method not used
    @param event not used
    */
   public void mouseEntered(MouseEvent event) {}
   /**
    * method not used
    @param event not used
    */
   public void mouseExited(MouseEvent event) {}
}