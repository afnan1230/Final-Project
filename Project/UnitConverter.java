
/*
 *Afnan Mir
 *4th Period
 *Mr. Yee
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
//enum Mass {MILLIGRAMS, CENTIGRAMS, DECIGRAMS, GRAMS, DEKAGRAMS, HECTAGRAMS, KILOGRAMS};
//@SuppressWarnings("unchecked")
/**
 * Class that creates the converter frame and performs the conversions
 */
public class UnitConverter extends JFrame implements ItemListener/*, ActionListener*/{
    //metric mass units
    String[] MASS = {"Milligrams","Centigrams","Decigrams","Grams", "Dekagrams", "Hectagrams", "Kilograms"};
    //metric volume units
    String[] VOLUME = {"MIlliliters","Centiliters","Deciliters", "Liters", "Dekaliters", "Hectaliters", "Kiloliters"};
    //metric distance units
    String[] DISTANCE = {"MIllimeters","Centimeters","Decimeters", "Meters", "Dekameters", "Hectameters", "Kilometers"};
    private JPanel beginningUnit;
    private static File therm;
    private static File vol;
    private static File mas;
    private static File dis;
    private JPanel desiredUnit;
    private JTextField numberOfUnits;
    private JTextField numWantedUnits;
    private JComboBox<String> type; //choose the type of unit to convert
    private JComboBox<String> mass;
    private JComboBox<String> distance;
    private JComboBox<String> volume;
    private JTextField bConvert;
    private JLabel units;
    private UnitPanel first; //top panel for units you have
    private UnitPanel second; //bottom panel for units you want
    private JLabel thermometer;
    private JLabel water;
    private JLabel balance;
    private JLabel ruler;
    /**
     * creates the UnitConverter frame
     */
    public UnitConverter() throws Exception{
        therm = new File("thermometer.png");
        vol = new File("volume.png");
        mas = new File("mass.jpg");
        dis = new File("ruler.jpg");
        setSize(750,750);
        setTitle("Unit Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        first = new UnitPanel();
        second = new UnitPanel();
        thermometer = new JLabel(new ImageIcon(therm.getAbsolutePath()),10);
        water = new JLabel(new ImageIcon(vol.getAbsolutePath()),10);
        balance = new JLabel(new ImageIcon(mas.getAbsolutePath()),10);
        ruler = new JLabel(new ImageIcon(dis.getAbsolutePath()),10);
        
        add(balance,BorderLayout.WEST);
        add(ruler,BorderLayout.CENTER);
        
        add(thermometer,BorderLayout.AFTER_LINE_ENDS);add(water,BorderLayout.AFTER_LINE_ENDS);
        balance.setVisible(false);
        ruler.setVisible(false); 
        water.setVisible(true);
        thermometer.setVisible(false);
        // desiredUnit = new JPanel();
        // beginningUnit = new JPanel();
         type = new JComboBox<String>();
         type.addItem("Volume");
         type.addItem("Mass");
         type.addItem("Distance");
         type.addItem("Temperature");
         numberOfUnits = new JTextField(5);
         numWantedUnits = new JTextField(5);
         //mass = new JComboBox<String>();
         //mass.addItem("Milligrams");
         //mass.addItem("Centigrams");
         //mass.addItem("Decigrams");
         //mass.addItem("Grams");
         //mass.addItem("Dekagrams");
         //mass.addItem("Hectagrams");
         //mass.addItem("Kilograms");
         //distance = new JComboBox<String>();
         //distance.addItem("Millimeters");
         //distance.addItem("Centimeters");
         //distance.addItem("Decimeters");
         //distance.addItem("Meters");
         //distance.addItem("Dekameters");
         //distance.addItem("Hectameters");
         //distance.addItem("Kilometers");
         //volume = new JComboBox<String>();
         //volume.addItem("Milliliters");
         //volume.addItem("Liters");
        bConvert = new JTextField("Click anywhere on the frame to convert");
        bConvert.setEditable(false);
         units = new JLabel();
//         first.addText(numberOfUnits);
//         first.addBox(type);
//         first.addBox(mass);first.addBox(volume);first.addBox(distance);
//         second.addText(numberOfUnits);
//         second.addBox(type);
//         second.addBox(mass);second.addBox(volume);second.addBox(distance);
        //add(beginningUnit,BorderLayout.NORTH);
        //add(desiredUnit,BorderLayout.SOUTH);
        
        first.add(type);
        first.add(bConvert);
        //bConvert.addActionListener(this);
        type.addItemListener(this);
        add(first,BorderLayout.NORTH);
        add(second,BorderLayout.SOUTH);
        setVisible(true);
        
    }
    /**
     * returns the convert text field
     * @return the convert text field
     */
    public JTextField getConvertButton(){
        return bConvert;
    }
    /**
     * returns the panel with units you have
     * @return the panel with unit you have
     */
    public UnitPanel getTopPanel(){
        return first;
    }
    /**
     * returns the panel with units you want
     * @return the panel with units you want
     */
    public UnitPanel getBottomPanel(){
        return second;
    }
    /**
     * returns where the unit is on the metric scale
     * @param st array of the whole metric scale
     * @param s the desired unit
     * @return the index the unit lies on
     */
    private static int index(String[]st,String s){
        for(int i=0;i<st.length;i++){
           
            if(st[i].equals(s)){
                System.out.println(st[i]);
                System.out.println(s);
                return i;
            }
        }
        return 0;
    }
    /**
     * if selected item in dropdown menu is changed the visible dropdown menu will change to the desired type of unit
     * @param e the event of the item being changed
     */
    public void itemStateChanged(ItemEvent e){
    	if(e.getStateChange() == ItemEvent.SELECTED){
    		String s = (String)type.getSelectedItem();
    		System.out.println (s);
    		first.invisible(s);
            second.invisible(s);
            first.setText("0");
            second.setText("0");
            switch((String)type.getSelectedItem()){
                case "Volume":
                water.setVisible(true);
                balance.setVisible(false);
                thermometer.setVisible(false);
                ruler.setVisible(false);
                
    			break;
    		case "Mass":
                System.out.println("HELLO");
                balance.setVisible(true);
                water.setVisible(false);
                thermometer.setVisible(false);
                ruler.setVisible(false);
    			break;
            case "Distance":
                ruler.setVisible(true);
                water.setVisible(false);
                balance.setVisible(false);
                thermometer.setVisible(false);
                
                break;
            case "Temperature":
                add(thermometer,BorderLayout.AFTER_LINE_ENDS);
                thermometer.setVisible(true);
                water.setVisible(false);
                balance.setVisible(false);
                ruler.setVisible(false);
                
                break;
            }
    	}
    }
    /*public void actionPerformed(ActionEvent e){
    	if(((JButton)e.getSource()).getText().equals("Convert")){
            convert();
    	}
    }*/
    /**
     * creates an array of your unit and desired unit
     * @return array containing your unit and desired unit
     */
    public String[] getUnit(){
        String[] startEnd = new String[2];
        String s = (String)type.getSelectedItem();
        if(s.equals("Volume")){
            startEnd[0] = first.getVolume();
            startEnd[1] = second.getVolume();
        }else if(s.equals("Mass")){
            startEnd[0] = first.getMass();
            startEnd[1] = second.getMass();
        }else if (s.equals("Distance")){
            startEnd[0] = first.getDistance();
            startEnd[1] = second.getDistance();
        }else{
            startEnd[0] = first.getTemperature();
            startEnd[1] = second.getTemperature();
        }
        return startEnd;
    }
    /**
     * returns the text in the text box of units you have
     * @return the text in the text box of units you have
     */
    public String getStart(){
        return first.getText();
    }
    /**
     * returns the text in the text box of units you want
     * @return the text in the text box of units you want
     */
    public String getEnd(){
        return second.getText();
    }
    /**
     * performs the conversion depending on type of unit
     */
    public void convert(){
        String s = (String)type.getSelectedItem();
        System.out.println(s);
        double answer = 0;

        double num = Double.parseDouble(first.getText());
        int power = 0;
        answer=0;
        if(s.equals("Volume")){
             power = index(VOLUME,first.getVolume())-index(VOLUME,second.getVolume());
             answer = num *(Math.pow(10,power));
        }else if(s.equals("Mass")){
             power = index(MASS,first.getMass())- index(MASS, second.getMass());
             answer = num *(Math.pow(10,power));
        }else if(s.equals("Distance")){
             power = index(DISTANCE,first.getDistance())- index(DISTANCE, second.getDistance());
             answer = num *(Math.pow(10,power));
        }else{
            switch(first.getTemperature()){
                case "Farenheit":
                    if(second.getTemperature().equals("Farenheit")){
                        answer = num;
                    } else if(second.getTemperature().equals("Celsius")){
                        answer = (num-32)*(5.0/9);
                    }else{
                        answer = ((num-32)*(5.0/9))+273;
                    }
                    break;
                case "Celsius":
                    if(second.getTemperature().equals("Farenheit")){
                        answer = (num*1.8)+32;
                    } else if(second.getTemperature().equals("Celsius")){
                        answer = num;
                    }else{
                        answer = num+273;
                    }
                    break;
                case "Kelvin":
                    if(second.getTemperature().equals("Farenheit")){
                        answer = (num-273)*1.8 +32;
                    } else if(second.getTemperature().equals("Celsius")){
                        answer = num-273;
                    }else{
                        answer =num;
                    }
                    break;
            }
            
        }
        //answer = num *(Math.pow(10,power));
        second.setText(""+answer);
    }
}



