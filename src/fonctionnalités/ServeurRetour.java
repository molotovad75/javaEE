package fonctionnalités;

import java.io.IOException;
import java.net.ServerSocket;

public class ServeurRetour implements Runnable {

	ServerSocket serveurRetour;

	public ServeurRetour(int port) throws IOException {

		serveurRetour = new ServerSocket(port);

	}

	@Override
	public void run() {
		while (true) {
			try {
				while (true) {
					new Thread(new ServiceRetour(serveurRetour.accept())).start();
				}
			} catch (Exception e) {
				System.err.println("Le client du service de retour n'a pas été accepté :");
				System.err.println(e.getMessage());
			} 
		}
	}

	@Override
	protected void finalize() throws IOException {
		serveurRetour.close();
	}

}
