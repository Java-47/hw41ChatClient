package telran.socket.client.tasks;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver implements Runnable {

	ObjectInputStream ois;

	public Receiver(ObjectInputStream ois) {
		this.ois = ois;
	}

	@Override
	public void run() {
		while (true) {

			try {
				String response = ois.readObject().toString();
				System.out.println(response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
