package fonctionnalités;

import java.io.IOException;
import java.net.ServerSocket;

public class ServeurEmprunt implements Runnable {

	ServerSocket serveurEmprunt;

	public ServeurEmprunt(int port) throws IOException {

		serveurEmprunt = new ServerSocket(port);

	}

	@Override
	public void run() {
		while (true) {
			try {
				while (true) {
					new Thread(new ServiceEmprunt(serveurEmprunt.accept())).start();
				}
			} catch (Exception e) {
				System.err.println("Le client du service d'emprunt n'a pas été accepté :");
				System.err.println(e.getMessage());
			} 
		}
	}

	@Override
	protected void finalize() throws IOException {
		serveurEmprunt.close();
	}

}
