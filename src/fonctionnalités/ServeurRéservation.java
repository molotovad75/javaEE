package fonctionnalités;

import java.io.IOException;
import java.net.ServerSocket;

public class ServeurRéservation implements Runnable {

	ServerSocket serveurRéservation;

	public ServeurRéservation(int port) throws IOException {

		serveurRéservation = new ServerSocket(port);

	}

	@Override
	public void run() {
		while (true) {
			try {
				while (true) {
					new Thread(new ServiceRéservation(serveurRéservation.accept())).start();
				}
			} catch (Exception e) {
				System.err.println("Le client du service de réservation n'a pas été accepté :");
				System.err.println(e.getMessage());
			} 
		}
	}

	@Override
	protected void finalize() throws IOException {
		serveurRéservation.close();
	}

}
