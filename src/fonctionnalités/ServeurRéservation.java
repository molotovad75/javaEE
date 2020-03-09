package fonctionnalit�s;

import java.io.IOException;
import java.net.ServerSocket;

public class ServeurR�servation implements Runnable {

	ServerSocket serveurR�servation;

	public ServeurR�servation(int port) throws IOException {

		serveurR�servation = new ServerSocket(port);

	}

	@Override
	public void run() {
		while (true) {
			try {
				while (true) {
					new Thread(new ServiceR�servation(serveurR�servation.accept())).start();
				}
			} catch (Exception e) {
				System.err.println("Le client du service de r�servation n'a pas �t� accept� :");
				System.err.println(e.getMessage());
			} 
		}
	}

	@Override
	protected void finalize() throws IOException {
		serveurR�servation.close();
	}

}
