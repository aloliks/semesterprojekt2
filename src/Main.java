/*
 *
 */
import javax.swing.*;

public class Main {
    private GUI gui;                             //Opretter variabel af GUI-klassen
    private Kontrol kontrol;                     //Opretter variabel af Kontrol-klassen
    
    public void init(){
        gui = new GUI();                        //Opretter objekt af GUI-klassen
        kontrol = new Kontrol(gui);             //Opretter objekt af Kontrol-klassen
    }
    
    public void opretGUI(){                       
        JFrame vindue = new JFrame("EKG");      //Opretter et vindue på skærmen
        vindue.add(gui);                        //Viser gui'en i vinduet
        vindue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindue.pack();                          //Sætter vinduets størrelse
        vindue.setVisible(true);                //Åbner vinduet
    }
    
    public static void main(String[] arg){
        Main main = new Main();
        main.init();
        main.opretGUI();
        
    }
    
}
