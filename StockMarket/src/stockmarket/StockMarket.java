package stockmarket;

import java.net.*;
import java.io.*;

public class StockMarket {

    //Create Socket instance
    static Socket echoSocket;
  
    public static void main(String[] args) {
       //Opens new form UI
       Form form1 = new Form();
       form1.setVisible(true);

       //Variables for Socket Constructor
        String hostName = "192.168.0.214";
        int portNumber = 5000;       
        
        //Create new Socket, SendMessage and ReceiveMessage objects
        try {
            echoSocket = new Socket(hostName, portNumber);
            SendMessage sendMessage = new SendMessage(echoSocket);
            ReceiveMessage receiveMessage = new ReceiveMessage(echoSocket);
              
    //BufferedReader stdIn =
        //new BufferedReader(
            //new InputStreamReader(System.in));
           
    sendMessage.start();
    receiveMessage.start();
        
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
        
        /*Close the connection
        try{
            echoSocket.close();
        }
        catch (Exception ex)
        {
            if (echoSocket.isClosed() == true)
                System.out.println("Socket already closed");
            else
                System.out.println(ex);
        }*/
    }
}
