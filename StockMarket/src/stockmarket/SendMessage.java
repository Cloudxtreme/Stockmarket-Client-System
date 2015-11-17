
package stockmarket;

import java.net.*;
import java.io.*;


public class SendMessage {   
    
    private Socket socket;
    private PrintWriter out = null;
    
    public SendMessage(Socket inputSocket){
        try{
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
        out.println(message);
    }
}
