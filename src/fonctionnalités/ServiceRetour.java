package fonctionnalit�s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import application.AppliBiblioth�que;
import empruntable.Document;
import empruntable.RetourException;

public class ServiceRetour implements Runnable {

	private Socket serveur;

	public ServiceRetour(Socket s) {
		serveur = s;
	}

	@Override
	public void run() {

		BufferedReader socketIn = null;
		PrintWriter socketOut = null;

		try {
			socketIn = new BufferedReader(new InputStreamReader(serveur.getInputStream()));
			socketOut = new PrintWriter(serveur.getOutputStream(), true);

			socketOut.println("needsanswer$Entrez le num�ro du document que vous souhaitez retourner : ");
			int num�roDoc = Integer.parseInt(socketIn.readLine());
			Document doc = null;
			for (Document d : AppliBiblioth�que.documents) {
				if (d.numero() == num�roDoc) {
					doc = d;
					break;
				}
			}

			if (doc == null)
				throw new IllegalArgumentException("Le document demand� n'existe pas.");

			doc.retour();
			socketOut.println("endsservice$Le " + doc.toString() + " a bien �t� retourn�.");
		}
		catch (IOException ioe) {
			socketOut.println("error$Une erreur s'est produite lors de la communication avec le serveur : " + ioe.getMessage());
		}
		catch (RetourException ee) {
			socketOut.println("error$" + ee.getMessage());
		}
		catch (IllegalArgumentException iae) {
			socketOut.println("error$" + iae.getMessage());
		}
		finally {
			if (socketIn != null) {
				try {
					socketIn.close();
				} catch (IOException e) {}
			}
			if (socketOut != null)
				socketOut.close();
		}

	}

	@Override
	protected void finalize() throws IOException {
		serveur.close();
	}

	@Override
	public String toString() {
		return "Service de retour de document";
	}

}
