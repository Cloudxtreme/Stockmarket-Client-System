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

    static PrintWriter out;
    static BufferedReader in;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Form().setVisible(true);

       String hostName = "192.168.0.189";
        int portNumber = 5000;

        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
    BufferedReader in =
        new BufferedReader(
            new InputStreamReader(echoSocket.getInputStream()));
    BufferedReader stdIn =
        new BufferedReader(
            new InputStreamReader(System.in));
            
        String output;
        out.println("HELO");
        System.out.println(in.readLine());
        }
catch (IOException ex)
{
    System.out.println(ex);
}
        
    }
}

