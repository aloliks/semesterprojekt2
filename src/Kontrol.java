/*
 * 
 */
import java.awt.Color;
import java.awt.event.*;

public class Kontrol implements ActionListener{
    
    GUI gui;
    
    public Kontrol(GUI gui){
        this.gui = gui;
        gui.addActionListener(this);
    }
    
 
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Test af actionPerformed klasse");
        gui.setKnap();
        
    }

    
}
