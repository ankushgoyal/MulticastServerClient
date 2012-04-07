package main.java;

import java.net.*;
import java.io.*;

public class MulticastServer {
	
	public static void main(String args[]) throws Exception {
		new MulticastServerThread().start();
	}
}
