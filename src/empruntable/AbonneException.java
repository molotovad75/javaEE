package empruntable;

public class AbonneException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AbonneException(String message){
		super(message);
	}
	
	public AbonneException(){
		super();
	}
}
