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
 * @author Tom
 */
public class StockMarket {

    static Socket echoSocket;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //%new Form().setVisible(true);

        String hostName = "192.168.0.189";
        int portNumber = 5000;       
        
        try {
            echoSocket = new Socket(hostName, portNumber);
            SendMessage sendMessage = new SendMessage(echoSocket);
            ReceiveMessage receiveMessage = new ReceiveMessage(echoSocket);
              
    BufferedReader stdIn =
        new BufferedReader(
            new InputStreamReader(System.in));
           
    sendMessage.sendMessage("HELO");
    receiveMessage.receiveMessage();
        
        }
catch (IOException ex)
{
    System.out.println(ex);
}
    }
}