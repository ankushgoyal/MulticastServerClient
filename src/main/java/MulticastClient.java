package main.java;

import java.net.*;
import java.io.*;

public class MulticastClient {
	
	public static void main(String args[]) throws Exception {
		MulticastSocket socket = new MulticastSocket(4446);
		InetAddress group = InetAddress.getByName("230.0.0.1");
		socket.joinGroup(group);
		
		while(true) {
			byte[] byteBuf = new byte[256];
			DatagramPacket packet = new DatagramPacket(byteBuf, byteBuf.length);
			
			socket.receive(packet);
			String rcvd = new String(packet.getData(), 0, packet.getLength());
			System.out.println("New Quote: " + rcvd);
		}
		
	}
}
