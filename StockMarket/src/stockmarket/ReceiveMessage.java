package stockmarket;


import java.net.*;
import java.io.*;

public class ReceiveMessage extends Thread {
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
            
            Form.jTextArea2.append(received + "\n");
        }
        
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    @Override
    public void run(){
        while(socket.isConnected() == true){
        receiveMessage();
        
        if (socket.isConnected() == false)
        Form.jLabel3.setText("Not Connected");
        else
        Form.jLabel3.setText("Connected");    
        }
    }
}
