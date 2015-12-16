package stockmarket;

import java.net.*;
import java.io.*;


public class SendMessage {
    
    //Variable Declerations
    private Socket socket;
    private PrintWriter out = null;
    
    public SendMessage(Socket inputSocket){
        try{
            //Bound input socket to socket variable and set the output stream
            socket = inputSocket; 
            out = new PrintWriter(socket.getOutputStream(), true);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }        
    }
    
    public void sendMessage(String message)
    {
        //Set input message to output stream
        out.println(message);
    }
}
