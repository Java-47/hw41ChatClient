package telran.socket.client.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;

import telran.socket.client.tasks.Receiver;
import telran.socket.client.tasks.Sender;

public class ClientSocketChatAppl {

	public static void main(String[] args) {
		String serverHost = "127.0.0.1";
		int port = 9000;
		try (Socket socket = new Socket(serverHost, port);) {

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			Sender senderTask = new Sender(oos);
			Thread senderThread = new Thread(senderTask);
			
			Receiver receiverTask = new Receiver(ois);
			Thread receiverThread = new Thread(receiverTask);
			receiverThread.setDaemon(true);
			
			senderThread.start();
			receiverThread.start();

			System.out.println("Enter your message or type exit for quit");

			senderThread.join();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
