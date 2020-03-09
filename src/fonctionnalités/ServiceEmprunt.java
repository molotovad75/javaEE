package fonctionnalités;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import application.AppliBibliothèque;
import empruntable.Document;
import empruntable.EmpruntException;
import empruntable.SuspenduException;
import instanciable.Abonne;

public class ServiceEmprunt implements Runnable {

	private Socket serveur;

	public ServiceEmprunt(Socket s) {
		serveur = s;
	}

	@Override
	public void run() {

		BufferedReader socketIn = null;
		PrintWriter socketOut = null;

		try {
			socketIn = new BufferedReader(new InputStreamReader(serveur.getInputStream()));
			socketOut = new PrintWriter(serveur.getOutputStream(), true);

			socketOut.println("needsanswer$Entrez votre numéro d'abonné : ");
			int numéroAbonné = Integer.parseInt(socketIn.readLine());			
			Abonne abo = null;
			for (Abonne a : AppliBibliothèque.abonnés) {
				if (a.numero() == numéroAbonné) {
					abo = a;
					break;
				}	
			}
			if (abo == null)
				throw new IllegalArgumentException("L'abonné demandé n'existe pas.");

			socketOut.println("needsanswer$Entrez le numéro du document que vous souhaitez emprunter : ");
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

			doc.emprunter(abo);
			socketOut.println("endsservice$Le " + doc.toString() + " a bien été emprunté.");
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
		return "Service d'emprunt de document";
	}

}
