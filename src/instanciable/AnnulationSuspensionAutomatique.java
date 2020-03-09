package instanciable;

import java.util.TimerTask;

public class AnnulationSuspensionAutomatique extends TimerTask {

	private Abonne abo;
	
	public AnnulationSuspensionAutomatique(Abonne a) {
		abo = a;
	}
	
	@Override
	public void run() {
		abo.r�habiliter();
	}
	
	@Override
	public String toString() {
		return "Annulation automatique de la suspension d'un client";
	}

}
