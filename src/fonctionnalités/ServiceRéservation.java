package fonctionnalit�s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import application.AppliBiblioth�que;
import empruntable.Document;
import empruntable.EmpruntException;
import empruntable.SuspenduException;
import instanciable.Abonne;

public class ServiceR�servation implements Runnable {

	private Socket serveur;

	public ServiceR�servation(Socket s) {
		serveur = s;
	}

	@Override
	public void run() {

		BufferedReader socketIn = null;
		PrintWriter socketOut = null;

		try {
			socketIn = new BufferedReader(new InputStreamReader(serveur.getInputStream()));
			socketOut = new PrintWriter(serveur.getOutputStream(), true);

			socketOut.println("needsanswer$Entrez votre num�ro d'abonn� : ");
			int num�roAbonn� = Integer.parseInt(socketIn.readLine());			
			Abonne abo = null;
			for (Abonne a : AppliBiblioth�que.abonn�s) {
				if (a.numero() == num�roAbonn�) {
					abo = a;
					break;
				}	
			}
			if (abo == null)
				throw new IllegalArgumentException("L'abonn� demand� n'existe pas.");
			
			socketOut.println("needsanswer$Entrez le num�ro du document que vous souhaitez r�server : ");
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

			doc.reserver(abo);
			socketOut.println("endsservice$Le " + doc.toString() + " a bien �t� r�serv�.");
		}
		catch (IOException ioe) {
			socketOut.println("error$Une erreur s'est produite lors de la communication avec le serveur : " + ioe.getMessage());
		}
		catch (IllegalArgumentException iae) {
			socketOut.println("error$" + iae.getMessage());
		}
		catch (EmpruntException ee) {
			socketOut.println("error$" + ee.getMessage());
		}
		catch (SuspenduException se) {
			socketOut.println("error$" + se.getMessage());
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
		return "Service de r�servation de document";
	}

}
