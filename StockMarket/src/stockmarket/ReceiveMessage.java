package stockmarket;


import java.net.*;
import java.io.*;

public class ReceiveMessage extends Thread {
    private Socket socket;
    private BufferedReader in = null;
    
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
            Form.Received_txt.setText(received);
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
        }
    }
}
