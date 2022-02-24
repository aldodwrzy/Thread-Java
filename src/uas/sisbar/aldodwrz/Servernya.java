/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas.sisbar.aldodwrz;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ALDO DWIE RIZKY
 */
public class Servernya extends Thread {

        public static final int SERVICE_PORT = 13;
    
    public void serviceClients() throws IOException, ClassNotFoundException{
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        System.out.println("Service started\n");
        try {
            for (int i=1;;i++) {
                Socket nextClient = server.accept();
                System.out.println("Client connect : " + nextClient.getInetAddress() + " - on port " + nextClient.getPort());
                
                OutputStream os = nextClient.getOutputStream();
                PrintStream ps = new PrintStream(os);
                ps.println("Ahlan wa sahlan, Anda pengunjung ke-"+i);
                    
                os.flush();
                os.close();
                nextClient.close();
            }
            
        }catch(BindException be){
            System.err.println("Service already running on port "+SERVICE_PORT);
            System.out.println("Error: "+be);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Servernya server = new Servernya();
        server.serviceClients();

    }
    
}
