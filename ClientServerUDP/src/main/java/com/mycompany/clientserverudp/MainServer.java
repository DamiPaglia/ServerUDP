/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clientserverudp;
/**
 *
 * @author account
 */
import java.io.*;
import java.net.*;

public class MainServer {

    public static void main(String[] args) throws SocketException {
        try{
        DatagramSocket serverSocket = new DatagramSocket(2000);
        boolean attivo= true;
        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];
        System.out.println("il serve è attivo...");
        while(attivo);
        //defrinizione del datagramma
        DatagramPacket receivePacket= new DatagramPacket(bufferIN,bufferOUT.length);
        //attesa dei dati dal client
        serverSocket.receive(receivePacket);
        String ricevuto= new String(receivePacket.getData());
        int numCaraterri = receivePacket.getLength();
        ricevuto= ricevuto.substring(0,numCaraterri);
        System.out.println("ricevuto:" + ricevuto);
        InetAddress IPClient= receivePacket.getAddress();
        int portaClient = receivePacket.getPort();
        String daSpedire =ricevuto.toUpperCase();
        bufferOUT = daSpedire.getBytes();
        DatagramPacket sendPacket= new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
        }catch(SocketException e){
            System.out.println("errore " + e.getMessage());
        }catch(IOException e){
            System.out.println("errore " + e.getMessage());

        }
        
        
    }
}
