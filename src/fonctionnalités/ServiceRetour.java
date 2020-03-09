package fonctionnalités;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import application.AppliBibliothèque;
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

			socketOut.println("needsanswer$Entrez le numéro du document que vous souhaitez retourner : ");
			int numéroDoc = Integer.parseInt(socketIn.readLine());
			Document doc = null;
			for (Document d : AppliBibliothèque.documents) {
				if (d.numero() == numéroDoc) {
					doc = d;
					break;
				}
			}

			if (doc == null)
				throw new IllegalArgumentException("Le document demandé n'existe pas.");

			doc.retour();
			socketOut.println("endsservice$Le " + doc.toString() + " a bien été retourné.");
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
