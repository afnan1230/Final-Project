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
 * class that creates a panel to be added in the unit converter
 */
public class UnitPanel extends JPanel{
    private JTextField numberOfUnits;
    private JTextField numWantedUnits;
    private JComboBox<String> type;
    private JComboBox<String> mass;
    private JComboBox<String> distance;
    private JComboBox<String> volume;
    private JComboBox<String> temperature;
    /**
     * creates the UnitPanel with dropdowns and text fields
     */
    public UnitPanel(){
      type = new JComboBox<String>();
        type.addItem("Volume");
        type.addItem("Mass");
        type.addItem("Distance");
        numberOfUnits = new JTextField(5);
        mass = new JComboBox<String>();
        mass.addItem("Milligrams");
        mass.addItem("Centigrams");
        mass.addItem("Decigrams");
        mass.addItem("Grams");
        mass.addItem("Dekagrams");
        mass.addItem("Hectagrams");
        mass.addItem("Kilograms");
        distance = new JComboBox<String>();
        distance.addItem("Millimeters");
        distance.addItem("Centimeters");
        distance.addItem("Decimeters");
        distance.addItem("Meters");
        distance.addItem("Dekameters");
        distance.addItem("Hectameters");
        distance.addItem("Kilometers");
        volume = new JComboBox<String>();
        volume.addItem("Milliliters");
        volume.addItem("Centiliters");
        volume.addItem("Deciliters");
        volume.addItem("Liters");
        volume.addItem("Dekaliters");
        volume.addItem("Hectaliters");
        volume.addItem("Kiloliters");
        temperature = new JComboBox<String>();
        temperature.addItem("Farenheit");
        temperature.addItem("Celsius");
        temperature.addItem("Kelvin");
        //volume.setVisible(false);
        add(numberOfUnits);
        add(mass);
        add(volume);
        add(distance);
        add(temperature);
        temperature.setVisible(false);
        mass.setVisible(false);
        distance.setVisible(false);
        
    }
    /*public void addBox(JComboBox<String> j){
    	add(j);
    }*/
    /**
     * returns the text field
     * @return the text field
     */
    public JTextField getTextField(){
        return numberOfUnits;
    }
    /*public void addText(JTextField j){
    	add(j);
    }*/
    /**
     * makes one dropdown visible depending on the type of unit you want to convert and changes the color of the text depending on the type of unit
     * @param s
     */
    public void invisible(String s){
    	switch(s){
    		case "Volume":
    			distance.setVisible(false);
    			mass.setVisible(false);
                volume.setVisible(true);
                temperature.setVisible(false);
                numberOfUnits.setForeground(Color.BLUE);
    			break;
    		case "Mass":
    			distance.setVisible(false);
    			mass.setVisible(true);
                volume.setVisible(false);
                temperature.setVisible(false);
                numberOfUnits.setForeground(Color.GREEN);
    			break;
    		case "Distance":
    			distance.setVisible(true);
    			mass.setVisible(false);
                volume.setVisible(false);
                temperature.setVisible(false);
                numberOfUnits.setForeground(Color.BLACK);
                break;
            case "Temperature":
                distance.setVisible(false);
                mass.setVisible(false);
                volume.setVisible(false);
                temperature.setVisible(true);
                numberOfUnits.setForeground(Color.RED);
                break;
    	}
    }
    /**
     * sets the text in the text field
     * @param s the text to be added
     */
    public void setText(String s){
    	numberOfUnits.setText(s);
    }
    /**
     * returns the text in the text field
     * @return the text in the text field
     */
    public String getText(){
    	return numberOfUnits.getText();
    }
    /*
    public String getType(){
        return ((String)type.getSelectedItem());
    }*/
    /**
     * returns the unit for volume
     * @return the unit for volume
     */
    public String getVolume(){
        return ((String)volume.getSelectedItem());
    }
    /**
     * returns the unit for mass selected
     * @return the unit for mass selected
     */
    public String getMass(){
        return ((String)mass.getSelectedItem());
    }
    /**
     * returns the unit for distance selected
     * @return the unit for distance selected
     */
    public String getDistance(){
        return ((String)distance.getSelectedItem());
    }
    /**
     * returns the unit for temperature selected
     * @return the unit for temperature selected
     */
    public String getTemperature(){
        return ((String)temperature.getSelectedItem());
    }
}