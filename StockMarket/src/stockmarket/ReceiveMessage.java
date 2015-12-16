package stockmarket;


import java.net.*;
import java.io.*;

public class ReceiveMessage extends Thread {
    
    //Variable Declerations
    private Socket socket;
    private BufferedReader in = null;
    public static StringBuilder receivedData = new StringBuilder();
    
    
    public ReceiveMessage(Socket importSocket){
        try{
            socket = importSocket;
            in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void receiveMessage()
    {
        try{
            String received = in.readLine();
            
            if (received.contains("STK") == true){
                received = received.replaceAll("STK:", "");
                Form.jTextArea1.append(received + "\n");
            }
            else if (received.contains("BOUGHT") == true){
                received = received.replaceAll("ACK:BOUGHT:", "");
                Form.jTextArea3.append(received + "\n");
            }
            else if (received.equals("") || received.equals(null)){
                return;
            }
            else{       
            //Update the text field in the Form
                Form.jTextArea2.append(received + "\n");
            }
        }
        
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    //Asyncronous Method
    @Override
    public void run(){
        //While the socket is connected
        while(socket.isConnected() == true){
            receiveMessage();
        
            //Show if the socket is currently connected or not
            if (socket.isConnected() == false)
                Form.jLabel3.setText("Not Connected");
            else
                Form.jLabel3.setText("Connected");
        }
    }
}
