package instanciable;

import java.util.TimerTask;

import empruntable.Document;

public class AnnulationRéservationAutomatique extends TimerTask {

	private Document doc;

	public AnnulationRéservationAutomatique(Document d) {
		doc = d;
	}

	@Override
	public void run() {
		doc.retour();
	}

	@Override
	public String toString() {
		return "Annulation automatique de la réservation d'un document";
	}

}
