package instanciable;

import java.util.TimerTask;

import empruntable.Document;

public class AnnulationR�servationAutomatique extends TimerTask {

	private Document doc;

	public AnnulationR�servationAutomatique(Document d) {
		doc = d;
	}

	@Override
	public void run() {
		doc.retour();
	}

	@Override
	public String toString() {
		return "Annulation automatique de la r�servation d'un document";
	}

}
