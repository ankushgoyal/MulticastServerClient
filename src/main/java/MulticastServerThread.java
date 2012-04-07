package main.java;

import java.net.*;
import java.io.*;
import java.util.*;

public class MulticastServerThread extends Thread {
	
	private boolean moreQuotes = true;
	private List<String> quotes = new ArrayList<String>();
	private MulticastSocket socket;
	
	public MulticastServerThread() throws IOException {
		super("MulticastServerThread");
		this.socket = new MulticastSocket();
		quotes.add("cogito ergo sum.");
		quotes.add("yodle!");
		quotes.add("doodle!");
	}
	
	public void run() {
		while(moreQuotes) {
			try {
				byte[] byteBuf = new byte[256];
				String quote = getQuote();
				byteBuf = quote.getBytes();
				InetAddress group = InetAddress.getByName("230.0.0.1");
				DatagramPacket packet = new DatagramPacket(byteBuf, byteBuf.length, group, 4446);
				socket.send(packet);
				
				try {
					sleep((new Random().nextInt(6)) * 1000);
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private String getQuote() {
		return(quotes.get(new Random().nextInt(quotes.size())));
	}

}
