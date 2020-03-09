package empruntable;

@SuppressWarnings("serial")
public class RetourException extends RuntimeException {

	public RetourException(String s) {
		super(s);
	}
	
	public RetourException() {
		super();
	}

}
