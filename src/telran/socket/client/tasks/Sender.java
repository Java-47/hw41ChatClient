package telran.socket.client.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class Sender implements Runnable {
	String message;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	ObjectOutputStream oos;

	public Sender(ObjectOutputStream oos) throws IOException {
		this.oos = oos;
	}

	@Override
	public void run() {
		while (!"exit".equalsIgnoreCase(message)) {

			// System.out.println("Enter your message or type exit for quit");
			try {
				message = br.readLine();
				oos.writeObject(message);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
