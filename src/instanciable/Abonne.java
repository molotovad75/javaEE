package instanciable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;

import application.AppliBibliothèque;

public class Abonne {
	
	private int num;
	private String nom;
	private String prenom;
	private int age;
	
	private Timer finSuspension;
	private boolean suspendu;
	private static final int TEMPS_MAX_SUSP = 1; // en mois

	public Abonne(String n, String p, int a) {
		nom = n;
		prenom = p;
		age=a;
		num = AppliBibliothèque.cpt_abo;
		AppliBibliothèque.cpt_abo++;
		finSuspension = new Timer(p + " " + n);
		suspendu = false;
	}

	public int numero() {
		return num;
	}

	public int getAge() {
		return age;
	}
	
	public boolean estSuspendu() {
		return suspendu;
	}
	
	public void suspendre() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime finSusp = now.plusMonths(TEMPS_MAX_SUSP);
		long temps = Duration.between(now, finSusp).toMillis();
		finSuspension.schedule(new AnnulationSuspensionAutomatique(this), temps);
		suspendu = true;
	}
	
	public void réhabiliter() {
		suspendu = false;
	}

	@Override
	public String toString() {
		return (prenom + " " + nom.toUpperCase() + " (abo n°" + num + "), " + age + " ans");
	}

}
