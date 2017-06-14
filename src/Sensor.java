/*
 * Denne klasse skal kunne følgende:
 * - oprette forbindelse til Arduino via en seriel port
 * - indhente målinger fra Arduino
 * - gemme målinger i Kø-klassen
 */

import jssc.*;

public class Sensor implements Runnable{

    private SerialPort serialPort;
    public String data;
    Sensor sensor;

    
    //Finder ud af hvilken port, Arduinoen er tilsluttet 
    public void searchPort(){
        String[] portNames = SerialPortList.getPortNames();
        for(int i=0; i<portNames.length;i++){
            serialPort = sensor.openPort(portNames[i]); //Muligvis problem med sensorobjekt
            
        }
        
    }
    
    
    //Opretter derefter forbindelse til porten
    public SerialPort openPort(String portname) {
        try {
            serialPort = new SerialPort(portname);
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_19200, 8, 1, 0); // sætter
            // parametre
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.setDTR(true);
            System.out.println("Porten blev oprettet");
            return serialPort;

        } catch (SerialPortException e) {
            System.out.println("Sensor ikke tilsluttet");
            return null;

        }
    }
    
    //Indhenter data fra porten
    public String getData() {
        try {
            if(serialPort.getInputBufferBytesCount()>0){    //Indhenter data fra Arduino
                data = serialPort.readString();             //Gemmer indhentede data som string
                
                
            }else{
                Thread.sleep(1000);
            }
            
        } catch (SerialPortException e) {
            System.out.println("Porten var ikke initialiseret");
            e.printStackTrace();
            
        //Obs. er måske slet ikke nødvendig
        //Kastes hvis en anden tråd afbryder den nuværende tråd, mens sleep er aktiv
        }catch(InterruptedException e){     
            System.out.println("Kunne ikke indhente målinger - forsøger igen");
            Thread.currentThread().interrupt();
        }
        return data;
    }
    
    //Kalder getData i løkke
    @Override
    public void run(){      

    }
    
    //Test af sensorklasse
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.initPort();
        
    }

}


