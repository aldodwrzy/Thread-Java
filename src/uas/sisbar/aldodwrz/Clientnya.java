/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas.sisbar.aldodwrz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ALDO DWIE RIZKY
 */
public class Clientnya {

    public static final int SERVICE_PORT = 13;
    
    public static void main(String[] args) throws IOException {
        try{
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection established\n");

            daytime.setSoTimeout(2000);

            BufferedReader br = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            String data = br.readLine();
            System.out.println(data);
            
            daytime.close();
        }catch(IOException ioe){
            System.out.println("Error "+ioe);
        }

    }
    
}
