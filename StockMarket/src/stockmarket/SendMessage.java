/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.net.*;
import java.io.*;
/**
 *
 * @author Computing
 */


public class SendMessage extends Thread {   
    
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
    
    @Override
    public void run(){
        String line = null;
        //Set line to a variable that is needed to be sent
        sendMessage(line);
    }
}
