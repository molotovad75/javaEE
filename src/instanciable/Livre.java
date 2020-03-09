package instanciable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;

import application.AppliBiblioth�que;
import empruntable.*;

public class Livre implements Document {

	private int num;
	private String titre;
	private String nomAuteur;
	private Abonne possesseur = null;

	private Timer finR�servation;
	private static final long TEMPS_MAX_RESA = 7200000; // 2 heures

	private Etat statut;
	private LocalDateTime dateEmprunt = null;
	private static final int TEMPS_EMPRUNT_MAX = 2; // en mois

	public Livre(String t, String na) {
		titre = t;
		nomAuteur = na;
		num = AppliBiblioth�que.cpt_doc;
		AppliBiblioth�que.cpt_doc++;
		finR�servation = new Timer(t);
		statut = Etat.disponible;
	}

	@Override
	public int numero() {
		return num;
	}

	@Override
	public void reserver(Abonne ab) throws EmpruntException {
		synchronized (this) {
			if (ab.estSuspendu())
				throw new SuspenduException(ab.toString() + ", est suspendu et ne peut plus r�server de document.");
			else {
				if (estDispo()) {
					statut = Etat.r�serv�;
					possesseur = ab;
					finR�servation.schedule(new AnnulationR�servationAutomatique(this), TEMPS_MAX_RESA);
				}
				else
					throw new EmpruntException("Le " + toString() + " n'est pas disponible.");
			}
		}

	}

	@Override
	public void emprunter(Abonne ab) throws EmpruntException {
		synchronized (this) {
			if (ab.estSuspendu())
				throw new SuspenduException(ab.toString() + ", est suspendu et ne peut plus r�server de document.");
			else {
				if (estDispo()) {
					statut = Etat.emprunt�;
					possesseur = ab;
					dateEmprunt = LocalDateTime.now();
				}
				else if (possesseur().equals(ab)) {
					statut = Etat.emprunt�;
					dateEmprunt = LocalDateTime.now();
				}
				else
					throw new EmpruntException("Le " + toString() + " n'est pas disponible.");
			}
		}
	}

	@Override
	public void retour() throws RetourException {
		synchronized (this) {
			if (estDispo())
				throw new RetourException("Le " + toString() + " est d�j� libre.");
			else if (estR�serv�() == true) {
				possesseur = null;
				statut = Etat.disponible;
				finR�servation.cancel();
			} else if (estEmprunt�() == true) {
				if (Duration.between(dateEmprunt(), LocalDateTime.now()).toMillis() > Duration.between(dateEmprunt(), dateEmprunt().plusWeeks(TEMPS_EMPRUNT_MAX)).toMillis())
					possesseur.suspendre();
				possesseur = null;
				statut = Etat.disponible;
			}
		}
	}

	@Override
	public String titre() {
		return titre;
	}

	@Override
	public Etat statut() {
		return statut;
	}

	@Override
	public LocalDateTime dateEmprunt() {
		return dateEmprunt;
	}

	@Override
	public Abonne possesseur() {
		return possesseur;
	}

	@Override
	public boolean estR�serv�() {
		return statut().equals(Etat.r�serv�);
	}

	@Override
	public boolean estEmprunt�() {
		return statut().equals(Etat.emprunt�);
	}

	@Override
	public boolean estDispo() {
		return statut().equals(Etat.disponible);
	}

	@Override
	public String toString() {
		return ("livre \"" + titre + "\" de " + nomAuteur + " (doc n�" + numero() +")");
	}

}
